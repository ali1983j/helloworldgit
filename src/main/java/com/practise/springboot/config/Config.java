package com.practise.springboot.config;

import com.practise.orm.entity.audit.AuditorAwareImpl;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Mohammed Shoukath Ali
 */

@EntityScan(basePackages = {"com.practise.orm.entity", "org.springframework.data.jpa.domain.support"})
@EnableJpaRepositories(basePackages = {"com.practise.orm.repository"})
@EnableJpaAuditing
@Configuration

public class Config {

//    @Bean
//    AuditorAwareImpl auditorAware() {
//        return new AuditorAwareImpl();
//    }
}
