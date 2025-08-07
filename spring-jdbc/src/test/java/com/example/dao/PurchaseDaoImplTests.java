package com.example.dao;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Date;
import java.util.List;

import com.example.Config;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.example.domain.Purchase;

//	TODO-11: Annotate this class to make it a Spring test class.
//  Include the configuration class you wish to load.
@SpringJUnitConfig(Config.class)
public class PurchaseDaoImplTests {

    // TODO-12: Have Spring inject a PurchaseDao into this class.
    @Autowired
    PurchaseDao dao;
    
    //  TODO-13: Examine the test logic in the following method.
    //  It retrieves all purchases, then asserts that there are multiple purchases.
    //  It also asserts that the first purchase has its properties mapped;
    //  This verifies that the BeanPropertyRowMapper is working.
    //  Remove the @Disabled annotation.  Run this test, it should pass.
    //  It did
    @Test
    public void	findAllPurchases() {
        List<Purchase> purchases = dao.getAllPurchases();

        //  Make sure there are multiple purchases, and 
        //  that purchases have their properties mapped:
        assertThat(purchases).isNotNull();
        assertThat(purchases.size()).isGreaterThan(0);
        Purchase p = purchases.get(0);
        assertThat(p).isNotNull();
        assertThat(p.getId()).isNotNull();
        assertThat(p.getCustomerName()).isNotNull();
        assertThat(p.getCustomerName()).isEqualTo("Bruce");
    }

    //  TODO-14: Implement the getPurchase() test method.
    //  This method should retrieve a single purchase by its id.
    //  Use an ID value of 1, 2, or 3 to match the data in data.sql
    //  Validate that the purchase has its properties values mapped correctly. 
    //  Use the previous test method for guidance. 
    @Test
    public void	getPurchase() {
        Purchase p = dao.getPurchase(2);

        assertThat(p).isNotNull();
        assertThat(p.getId()).isNotNull();
        assertThat(p.getCustomerName()).isNotNull();
        assertThat(p.getCustomerName()).isEqualTo("Paul");
        assertThat(p.getProduct()).isEqualTo("Football");
    }

    //  TODO-15: Implement the savePurchase() test method.
    //  Alter the Purchase test data as you like, and call the savePurchase() method.
    //  A getPurchase(String customerName, Date date) method is available to retrieve the purchase you just saved.
    //  Add assertions to make sure the purchase retrieved matches the one that was saved.
    @Test
    public void	savePurchase() {

        Purchase p = new Purchase();
        p.setCustomerName("Sample");
        p.setProduct("Sample Product");
        p.setPurchaseDate( new Date());

        dao.savePurchase(p);
        Purchase newPurchase = dao.getPurchase(p.getCustomerName(),p.getPurchaseDate());

        assertThat(newPurchase).isNotNull();
        assertThat(newPurchase.getId()).isNotNull();
        assertThat(newPurchase.getCustomerName()).isNotNull();
        assertThat(newPurchase.getCustomerName()).isEqualTo(p.getCustomerName());
        assertThat(newPurchase.getProduct()).isEqualTo(p.getProduct());

    }
    //  TODO-16: Organize your imports, save your work
    //  Run this test class.  All tests should pass.

}
