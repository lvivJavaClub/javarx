package com.lohika.javaclub.rxdata;

import com.github.javafaker.Faker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Locale;

@SpringBootApplication
public class RxApplication {

  public static void main(String[] args) {
    SpringApplication.run(RxApplication.class, args);
  }

  @Bean
  Faker faker() {
    return new Faker(new Locale("en"));
  }

}
