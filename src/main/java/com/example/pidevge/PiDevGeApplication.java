package com.example.pidevge;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
@SpringBootApplication
@EnableScheduling
public class PiDevGeApplication {

    public static void main(String[] args) {
        SpringApplication.run(PiDevGeApplication.class, args);
    }

}
