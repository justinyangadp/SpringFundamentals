package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("!compound")
public class SalesTaxCalculator implements TaxCalculator {

	private double taxRate;	// default rate

    public SalesTaxCalculator() {
	}

	@Autowired
    public SalesTaxCalculator(@Value("${tax.rate}") double taxRate) {
		this.taxRate = taxRate;
	}

	public double calculateTax(double amount) {
		return amount * taxRate;
	}	
}
