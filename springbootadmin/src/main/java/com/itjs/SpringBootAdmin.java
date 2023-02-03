package com.itjs;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableAdminServer
@SpringBootApplication
public class SpringBootAdmin {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootAdmin.class, args);
    }
}