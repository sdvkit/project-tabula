package com.sdv.kit.projecttabula;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class ProjectTabulaApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProjectTabulaApplication.class, args);
    }
}
