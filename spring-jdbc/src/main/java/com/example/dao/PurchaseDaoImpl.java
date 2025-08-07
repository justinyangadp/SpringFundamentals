package com.example.dao;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;

import com.example.domain.Purchase;

// TODO-04: Annotate to this class to define it as a Spring bean.
// Select the most descriptive stereotype annotation.

public class PurchaseDaoImpl implements PurchaseDao {

	// TODO-05: Have Spring inject the JdbcClient into this class.
	// Use whatever injection technique you like (constructor, setter, field).
	private JdbcClient jdbcClient;

	//	TODO-06:  Modify the getAllPurchases() method below.
	//	Use the jdbcClient to retrieve purchases from the DB:
	//  - The provided SQL retrieves all rows from the PURCHASE table.
	//  - Utilize the ".sql" method to specify the SQL statement.
	//  - Utilize the ".query" method to specify row mapping.
	//	  - Specify Purchase.class to easily map columns to Purchase properties.
	//	- The goal is to return a List of Purchase objects.
	@Override
	public List<Purchase> getAllPurchases() {
		String sql = "SELECT * FROM PURCHASE";
		// Replace this statement with the call to jdbcClient.
		return null;
	}

	//	TODO-07: Modify the getPurchase() method below.
	//	Use the jdbcClient to retrieve purchases from the DB:
	//  - The provided SQL retrieves all rows from the PURCHASE table.
	//  - Utilize the ".sql" method to specify the SQL statement.
	//  - Utilize the ".param" method to specify the id parameter.
	//  - Utilize the ".query" method to specify row mapping.
	//	  - Specify Purchase.class to easily map columns to Purchase properties.
	//	The goal is to return a single Purchase object.
	@Override
	public Purchase getPurchase(int id) {
		String sql = "SELECT * FROM PURCHASE WHERE ID = ?";
		// Add code here
		return null;
	}

	//	TODO-08:  Modify the savePurchase() method below.
	//	Use the jdbcClient to insert a purchase into the DB:
	//  - The provided SQL inserts a new row into the PURCHASE table.
	//  - Utilize the ".sql" method to specify the SQL statement.
	//  - Utilize the ".param" method to specify the name, product, and date parameters, in order.
	//  - Utilize the ".update" method to execute the insert.
	@Override
	public void savePurchase(Purchase purchase) {
		String sql = "insert into PURCHASE (CUSTOMERNAME, PRODUCT, PURCHASEDATE) values(?,?,?)";
	}


	@Override
	public Purchase getPurchase(String name, Date date) {
		String sql = "SELECT * FROM PURCHASE WHERE CUSTOMERNAME = ? and PURCHASEDATE = ?";
		return jdbcClient
			.sql(sql)
			.param(name)
			.param(date)
			.query(Purchase.class)
			.single();
	}


}
