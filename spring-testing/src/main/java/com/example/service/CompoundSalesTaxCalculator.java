package com.example.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("compound")
public class CompoundSalesTaxCalculator implements TaxCalculator {

	private final double taxRate;	// default rate
	private final double localTaxRate;	// default rate

    public CompoundSalesTaxCalculator(
		@Value("${tax.rate}") double taxRate,
		@Value("${local.tax.rate}") double localTaxRate) {
		this.taxRate = taxRate;
		this.localTaxRate = localTaxRate;
	}

	public double calculateTax(double amount) {
		return amount * (taxRate + localTaxRate);
	}	

}	
