package com.example.dao;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.domain.Purchase;

@Repository
public class PurchaseDaoImpl implements PurchaseDao {


	@Override
	public List<Purchase> getAllPurchases() {
		randomDelay();
		return null;
	}

	@Override
	public Purchase getPurchase(int id) {
		randomDelay();
		return null;
	}

	@Override
	public void savePurchase(Purchase purchase) {
		randomDelay();
	}


	@Override
	public Purchase getPurchase(String name, Date date) {
		randomDelay();
		return null;
	}


	private void randomDelay() {
		//	Simulate database activitiy; sleep for 
		//	a random amount of time between .5 and 3 seconds:
		try {
			Thread.sleep((long) (Math.random() * 2500) + 500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}


}
