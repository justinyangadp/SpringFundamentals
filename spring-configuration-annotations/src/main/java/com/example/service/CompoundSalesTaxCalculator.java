package com.example.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

//  TODO-08:  (OPTIONAL) Our application should be able to be configured to handle different
//	tax calculators, including a "compound" sales tax calculator (local sales tax + standard sales tax).
//	Add an annotation to this class to define it as a Spring bean.
//  Use whichever stereotype annotation that you feel is most descriptive.
//  Now we have two @Beans that implement the TaxCalculator interface.  How will Spring behave?

public class CompoundSalesTaxCalculator implements TaxCalculator {

	private final double taxRate;	// default rate
	private final double localTaxRate;	// default rate

	//  TODO-09:  (OPTIONAL) Add @Value annotations to populate the constructor parameters.  
	//	The parameter keys can be found in the app.properties file.
	public CompoundSalesTaxCalculator(
		double taxRate,
		double localTaxRate) {
		this.taxRate = taxRate;
		this.localTaxRate = localTaxRate;
	}

	public double calculateTax(double amount) {
		return amount * (taxRate + localTaxRate);
	}	

	//  TODO-10: (OPTIONAL) Organize imports, save your work.
	//	Run the previous test, it should FAIL.  
	//	Find the root cause of the exception and try to understand why.

}	
