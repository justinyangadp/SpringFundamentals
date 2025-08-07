package com.example.service;

public class SalesTaxCalculator implements TaxCalculator {

	private double taxRate = 0.05;	// default rate

    public SalesTaxCalculator() {
	}

    public SalesTaxCalculator(double taxRate) {
		this.taxRate = taxRate;
	}

	public double calculateTax(double amount) {
		return amount * taxRate;
	}	
}
