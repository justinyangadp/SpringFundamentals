package com.example;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;


@Configuration
public class Config {

    @Bean
    public Greeting greetingBean() {
        return new Greeting();
    }
}
