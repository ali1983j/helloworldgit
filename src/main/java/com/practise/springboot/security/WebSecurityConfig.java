package com.practise.springboot.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Arrays;

/**
 * Created by root on 28/12/17.
 */
@Configuration
//@EnableWebSecurity
//@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    @Qualifier("authenticationSecurityManager")
    AuthenticationSecurityManager authenticationSecurityManager;

    @Bean
    public BCryptPasswordEncoder configEncoder(){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder;
    }


    @Override
    protected AuthenticationManager authenticationManager() throws Exception{
        return new ProviderManager(Arrays.asList((AuthenticationProvider) authenticationSecurityManager));
    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.csrf().disable();
//    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }


    @Configuration
    @Order(1)
    public class RestSecurityConfig extends WebSecurityConfigurerAdapter {
        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http.csrf().disable();
        }
    }

    @Configuration
    @Order(1)
    public static class ApiWebSecurityConfig extends WebSecurityConfigurerAdapter {
//        @Override
//        protected void configure(HttpSecurity http) throws Exception {
//            http.authorizeRequests()
//                    .antMatchers(
//                            "/api/sign-up"
//
//                    ).permitAll();
//
//            http.csrf().disable().antMatcher("/api/users").authorizeRequests()
//                    .anyRequest().hasAnyRole("USER", "ADMIN")
//                    .and().httpBasic();
//
//        }

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http.authorizeRequests().anyRequest().authenticated()
                    .and()
                    .httpBasic();
        }
    }

    @Configuration
    @Order(2)
    public static class FormWebSecurityConfig extends WebSecurityConfigurerAdapter {


        @Value("${ilm.landing.page}")
        protected String landingPage;
        @Autowired
        SkyAuthenticationHandler customAuthenticationHandler;

        @Override
        protected void configure(HttpSecurity http) throws Exception {

            http.authorizeRequests()
                    .antMatchers(
                            "/src/**",
                            "/api/users/sign-up",
                            "/landing/**",
                            "/login.html",
                            "/*.txt",
                            "/**.txt",
                            "/*.png",
                            "/*.ico",
                            "/api/users/product/*/public",
                            "/api/users/login-status"

                    ).permitAll();

            http.authorizeRequests()
                    .antMatchers("index.html").hasAnyRole("USER", "ADMIN");

            http.authorizeRequests()
                    .anyRequest().authenticated()
                    .and()
                    .formLogin()
                    .loginPage(landingPage)
                    .loginProcessingUrl("/login")
                    .usernameParameter("username")
                    .passwordParameter("password")
                    .failureHandler(customAuthenticationHandler).defaultSuccessUrl("/index.html").permitAll()
                    .and()
                    .logout().logoutUrl("/logout").logoutSuccessUrl(landingPage + "?logout").permitAll();

            http.csrf().disable();
        }

        @Bean
        SkyAuthenticationHandler authenticationHandler() {
            return new SkyAuthenticationHandler();
        }
    }
}
