package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

//  TODO-05:  Add an annotation to this class to define it as a Spring bean.
//  Use whichever stereotype annotation that you feel is most descriptive.
//  Ok

@Component
public class SalesTaxCalculator implements TaxCalculator {

	private double taxRate;	// default rate

	//	TODO-06:  This class has multiple constructors.  
	//	Do you remember which one Spring will use by default?
	//	Add an annotation to direct Spring to use the constructor that takes a double parameter.
	//	Add an annotation to have Spring inject the "tax.rate" property into this parameter.
	//	The value should come from the app.properties file.
	//	Organize your imports, save your work.
	//  The first one. Ok added


    public SalesTaxCalculator() {
	}

	@Autowired
    public SalesTaxCalculator(@Value("${tax.rate}") double taxRate) {
		this.taxRate = taxRate;
	}

	public double calculateTax(double amount) {
		return amount * taxRate;
	}	








    //  TODO-13: (OPTIONAL) The two TaxCalculator beans should be mutually exclusive.
    //  Add a @Profile("!compound") annotation to this SalesTaxCalculator class.
    //  Organize imports, save work, re-run the RegisterCompoundTest.  It should PASS.
    //  Be sure that the original RegisterTest still passes as well.

}
