package com.itjs.jolokia.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

import java.util.logging.Logger;

@Configuration
@EnableWebSecurity
@Profile("ssl")
public class WebSSLSecurity {

    Logger logger = Logger.getLogger(WebSSLSecurity.class.getName());

    @Value("${spring.profiles.active}")
    private String profile;

    @Bean
    public SecurityFilterChain configure(HttpSecurity http) throws Exception {

        logger.info("active profiles is: "+profile );

        http
                .requiresChannel(channel -> channel.antMatchers("/*").requiresSecure())
                .cors().and()
                .csrf().disable()
                .authorizeRequests()
                .anyRequest().hasRole("admin")
                .and()
                .formLogin();
        return http.build();
    }
}