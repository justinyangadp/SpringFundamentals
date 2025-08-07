package com.example.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.Date;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import com.example.Config;
import com.example.domain.Purchase;

//	TODO-04: Annotate this class to make it a Spring test class.
//  Include the configuration class you wish to load.
@SpringJUnitConfig(Config.class)
public class PurchaseServiceImplTests {

    //  TODO-05: Have Spring inject a PurchaseService into this class.
    @Autowired
    PurchaseService purchaseService;

    //  TODO-06: Have Spring inject the PlatformTransactionManager into this variable.
    //  Ordinarily, we do not use the transactionManager directly in our code, but
    //  here we will use it to do something interesting below...
    @Autowired
    PlatformTransactionManager transactionManager;

    @Test
    public void testSavePurchase() {

        //  TODO-07: Remove the @Disabled annotation from this test method. 
        //  Observe the following line of code.
        //  We are using the transactionManager to manually create a new transaction.
        //  No changes are needed here, move on to the next step.
		TransactionStatus status = 
            transactionManager.getTransaction(
                new DefaultTransactionDefinition());

        //  TODO-08: Observe the following line of code.
        //  We are creating test data.
        //  Adjust the test data values if you like.
        //  No changes are needed here, move on to the next step.
        //  ok
        Purchase p = new Purchase("Praveen", new Date(), "lava lamp");

        //  TODO-09: Call the method on the purchaseService 
        //  to save the test data purchase object:
        purchaseService.savePurchase(p);

        //  TODO-10: Observe the following line of code.
        //  We are using the transactionManager to rollback the transaction.
        //  Consider: will this rollback the previous save operation?  
        //  Or will it be a separate transaction?
        //  There is nothing you need to code here, move on to the next step.
		transactionManager.rollback(status);

        Purchase retrievedPurchase = null;
        try {

            //  TODO-11: Call the findPurchase method on purchaseService to retrieve what was just saved.
            //  The findPurchase method takes two parameters: the customer name and the purchase date.
            //  Use the values from the test data created above.
            //  Assign the result to the retrievedPurchase variable.
            retrievedPurchase =
                purchaseService.findPurchase(
                    p.getCustomerName(),
                    p.getPurchaseDate()
                );

        } catch (EmptyResultDataAccessException e) {
            fail("Could not retrieve the purchase that was just saved.  Was the transaction rolled back?");
        }


        //  TODO-12: observe the following lines of code.
        //  These assertions verify the purchase was saved properly.
        //  Organize imports, save your work.
        //  Run this test.  Initially it will FAIL.  Do your understand why?
        //  We will fix this, move on to the next step.
        assertThat(retrievedPurchase).isNotNull();
        assertThat(retrievedPurchase.getId()).isNotNull();
        assertThat(retrievedPurchase.getCustomerName()).isNotNull();
        assertThat(retrievedPurchase.getCustomerName()).isEqualTo(p.getCustomerName());
        assertThat(retrievedPurchase.getProduct()).isEqualTo(p.getProduct());
    }


}
