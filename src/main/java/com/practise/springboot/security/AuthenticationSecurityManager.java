package com.practise.springboot.security;

import com.practise.springboot.CustomUserDetails;
import com.practise.orm.entity.Users;
import com.practise.orm.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by root on 28/12/17.
 */
@Component
@Qualifier(value = "authenticationSecurityManager")
public class AuthenticationSecurityManager implements AuthenticationProvider {

    private UsersRepository usersRepository;
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        String username = authentication.getName();
        String password = authentication.getCredentials().toString();
        boolean authenticated = false;
        String pass = null;
        Users u = null;


        u = usersRepository.findByUsername(username);

        if (u == null) {
            throw new UsernameNotFoundException(username);
        }

        BCryptPasswordEncoder cryptPasswordEncoder = new BCryptPasswordEncoder();
        Collection<GrantedAuthority> authorities = new ArrayList<>();

        if(cryptPasswordEncoder.matches(password, u.getPassword())){

            UserDetails details = new CustomUserDetails(u, username, "", true, true, true, true, authorities);

            return new UsernamePasswordAuthenticationToken(details, null, authorities);

        }

        throw new BadCredentialsException("1000");
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return false;
    }
}
