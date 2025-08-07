package com.example.service;

import org.springframework.stereotype.Component;

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
