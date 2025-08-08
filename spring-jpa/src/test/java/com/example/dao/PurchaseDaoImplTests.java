package com.example.dao;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Date;
import java.util.List;

import com.example.Config;
import jakarta.persistence.PersistenceContext;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.domain.Customer;
import com.example.domain.Purchase;

import jakarta.persistence.EntityManager;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.transaction.annotation.Transactional;

//	TODO-14: Annotate this class to make it a Spring test class.
//  Include the configuration class you wish to load.
//  Make the test Transactional, be sure to import the org.springframework.transaction.annotation.Transactional class.
@SpringJUnitConfig(Config.class)
@Transactional
public class PurchaseDaoImplTests {
    
    //  TODO-15: Use @PersistenceContext to inject the EntityManager into this class.
    @PersistenceContext EntityManager em;
    
    //  TODO-16: Inject the PurchaseDao into this class.
    @Autowired PurchaseDao repo;


    //  TODO-17: Examine the test logic in the following method.
    //  It retrieves all purchases, then asserts that there are multiple purchases.
    //  It also asserts that the first purchase has its properties mapped;
    //  This verifies that the JPA mapping metadata is correct.
    //  Notice that customer name is accessed on the Customer referenced through the Purchase object.
    //  Remove the @Disabled annotation.  Run this test, it should pass.
    @Test
    public void	findAllPurchases() {
        List<Purchase> purchases = repo.getAllPurchases();

        //  Make sure there are multiple purchases, and 
        //  that purchases have their properties mapped:
        assertThat(purchases).isNotNull();
        assertThat(purchases.size()).isGreaterThan(0);
        Purchase p = purchases.get(0);
        assertThat(p).isNotNull();
        assertThat(p.getId()).isNotNull();
        assertThat(p.getCustomer().getName()).isNotNull();
        assertThat(p.getCustomer().getName()).isEqualTo("Bruce");
    }

    //  TODO-18: Implement the getPurchase() test method.
    //  This method should retrieve a single purchase by its id.
    //  Use an ID value of 1, 2, or 3 to match the data in data.sql
    //  Make sure the purchase has its properties mapped.  
    //  Use the method above for guidance.
    @Test
    public void	getPurchase() {
        Purchase p = repo.getPurchase(2);

        assertThat(p).isNotNull();
        assertThat(p.getId()).isNotNull();
        assertThat(p.getCustomer().getName()).isNotNull();
        assertThat(p.getCustomer().getName()).isEqualTo("Paul");
        assertThat(p.getProduct()).isEqualTo("Football");
    }

    //  TODO-19: Implement the savePurchase() test method.
    //  Alter the Purchase test data as you like, and call the savePurchase() method.
    //  After saving, clear the persistence context by calling 'em.clear()'
    //  Retrieve the purchase you just saved by calling getPurchase(String customerName, Date date)
    //  Add assertions to make sure the purchase was saved properly.
    //  Remove the @Disabled annotation.
    @Test
    public void testSaveAndFind() {

        //  Get an existing customer:
        Customer c = em.find(Customer.class, 1);

        //  Create a new purchase:
        Purchase p = new Purchase();
        p.setCustomer(c);
        p.setProduct("Incan ceremonial headmask");
        p.setPurchaseDate(new Date());

        //  Save...
        repo.savePurchase(p);

        //  Clear...
        em.clear();

        //  Find...
        Purchase purchase = repo.getPurchase(p.getId());

        //  Assert...
        assertEquals(p.getProduct(), purchase.getProduct());
        assertEquals(p.getPurchaseDate(), purchase.getPurchaseDate());
    }

    //  TODO-20: Organize all imports, save all work.  Run this test, it should pass
}
