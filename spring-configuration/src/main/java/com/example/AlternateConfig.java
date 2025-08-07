package com.example;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

import com.example.service.Register;
import com.example.service.SalesTaxCalculator;
import com.example.service.TaxCalculator;

//  TODO-13: (OPTIONAL) Add an annotation to make this class a Configuration class:
//  Make it a member of the "alternate" profile.
//  Add a @PropertySource annotation to read 'app.properties' from the classpath root.

public class AlternateConfig {

    //  TODO-14: (OPTIONAL) Define a "taxCalculator" Bean of type SalesTaxCalculator.  
    //  Define a method parameter of type double named "taxRate".
    //  Use the @Value annotation to inject the value of the property "${tax.rate}".  
    //  Instantiate SalesTaxCalculator. Use the constructor which takes a tax rate.
    //  Return the SalesTaxCalculator instance.


    
    //  TODO-15: (OPTIONAL) Organize your imports.  Save your work.
    //  Open the app.properties file in src/main/resources.
    //  Adjust the tax rate to a different value if you like.    

    @Bean
    public Register register(TaxCalculator taxCalculator) {
        return new Register(taxCalculator);
    }

}
