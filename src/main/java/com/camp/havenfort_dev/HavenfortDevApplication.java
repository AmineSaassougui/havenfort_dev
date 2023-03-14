package com.camp.havenfort_dev;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class HavenfortDevApplication {

    public static void main(String[] args) {
        SpringApplication.run(HavenfortDevApplication.class, args);
    }

}
