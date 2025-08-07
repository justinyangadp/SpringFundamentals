package com.example.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.dao.PurchaseDao;
import com.example.domain.Purchase;


@Service
public class PurchaseServiceImpl implements PurchaseService {

	@Autowired PurchaseDao purchaseDAO;


	public List<Purchase> findAllPurchases() {
		return purchaseDAO.getAllPurchases();
	}

	public Purchase findPurchase(int id) {
		return purchaseDAO.getPurchase(id);
	}

	public Purchase findPurchase(String name, Date Date) {
		return purchaseDAO.getPurchase(name, Date);
	}


	public void savePurchase(Purchase purchase) {
		purchaseDAO.savePurchase(purchase);
	}


}
