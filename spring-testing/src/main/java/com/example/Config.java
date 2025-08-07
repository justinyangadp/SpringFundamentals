package com.example;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;


@Configuration   
@PropertySource("classpath:app.properties")
@ComponentScan(basePackages = "com.example.service")
public class Config {

}
