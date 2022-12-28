package com.example.addressbookappspringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication

public class AddressBookAppSpringBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(AddressBookAppSpringBootApplication.class, args);
    }

}
