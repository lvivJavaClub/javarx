package com.lohika.javaclub.rxdata;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.github.javafaker.Faker;

import java.util.Locale;

@SpringBootApplication
public class RxВataApplication {

    public static void main(String[] args) {
        SpringApplication.run(RxВataApplication.class, args);
    }

    @Bean
    Faker faker() {
        return new Faker(new Locale("en"));
    }

}