package com.example;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.PropertySource;

//  TODO-02: Add an annotation to this configuration class to enable AspectJ proxying:

@EnableAspectJAutoProxy
@Configuration
@PropertySource("classpath:app.properties")
@ComponentScan("com.example")
public class Config {

    
}
