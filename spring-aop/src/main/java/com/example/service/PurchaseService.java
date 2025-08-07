package com.example.service;

import java.util.Date;
import java.util.List;

import com.example.domain.Purchase;

public interface PurchaseService {
	public void savePurchase(Purchase purchase);
	public List<Purchase> findAllPurchases();
	public Purchase findPurchase(int id);
	public Purchase findPurchase(String name, Date Date);
}
