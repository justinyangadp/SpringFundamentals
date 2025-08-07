package com.example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.service.Register;
import com.example.service.SalesTaxCalculator;
import com.example.service.TaxCalculator;

//  TODO-01: Add an annotation to mark this class as a Configuration class:
@Configuration
public class Config {

    //  TODO-02: Write a method to define a Spring Bean.
    //  Be sure to annotate the method with @Bean.
    //  The bean's type should be SalesTaxCalculator.  
    //  The bean's name should be "taxCalculator"
    //  The method should return a new instance of SalesTaxCalculator.
    @Bean
    public SalesTaxCalculator taxCalculator() {
        return new SalesTaxCalculator();
    }

    
    //  TODO-03: Write a method to define a Spring Bean.
    //  The bean's type should be Register.  
    //  The bean's name should be "register"
    //  The method should take one parameter of type TaxCalculator.
    //  The method should instantiate and return a Register instance.
    //  Dependency inject the instance with the TaxCalculator.
    @Bean
    public Register register(TaxCalculator taxCalculator) {
        return new Register(taxCalculator);
    }



    //  TODO-04: Organize your imports.  Save your work.
    //  Done
}
