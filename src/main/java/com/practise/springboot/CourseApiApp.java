package com.practise.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.ErrorPageFilter;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.context.WebApplicationContext;

/**
 * Created by root on 26/12/17.
 */
@ComponentScan(basePackages = {
        "com.practise", "com.sky"
})
@SpringBootApplication
@EnableAutoConfiguration
public class CourseApiApp extends SpringBootServletInitializer {


//    @Override
//    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
//        return application.sources(CourseApiApp.class);
//    }
//
//
//    protected WebApplicationContext run(SpringApplication application) {
//        application.getSources().remove(ErrorPageFilter.class);
//        return super.run(application);
//    }

    public static void main(String[] args){

        SpringApplication.run(CourseApiApp.class, args);

    }


}
