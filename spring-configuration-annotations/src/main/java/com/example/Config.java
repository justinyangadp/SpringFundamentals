package com.example;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.example.service.Register;
import com.example.service.SalesTaxCalculator;
import com.example.service.TaxCalculator;


@Configuration   
@PropertySource("classpath:app.properties")
@ComponentScan(basePackages = "com.example.service")
public class Config {

    //  TODO-02: Comment out the @Bean definitions in this class (below).
    //  Re-run the previous test.  It should fail.  Do you understand why?
    //  Yah bc they couldn't find the beans

//    @Bean
    public SalesTaxCalculator taxCalculator(@Value("${tax.rate}") double taxRate) {
        return new SalesTaxCalculator(taxRate);
    }

//    @Bean
    public Register register(TaxCalculator taxCalculator) {
        return new Register(taxCalculator);
    }

    //  TODO-03:  Add a @ComponentScan annotation to this class.
    //  Set the basePackages attribute to reference the service package.
    //  Organize your imports, save your work.
    // Ok

}
