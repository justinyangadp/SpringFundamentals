package com.example.service;

import org.springframework.stereotype.Component;

//  TODO-04:  Add an annotation to this class to define it as a Spring bean.
//  Use whichever stereotype annotation that you feel is most descriptive.
//  Organize your imports, save your work.
//  Sure

@Component
public class Register {

    private TaxCalculator taxCalc;

    public Register (TaxCalculator taxCalculator) {
        taxCalc = taxCalculator;
    }

	public double computeTotal(double beforeTax) {
		return beforeTax + taxCalc.calculateTax(beforeTax);
  }


}
