package com.example.dao;

import java.util.Date;

import com.example.Config;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;


import com.example.domain.Purchase;

//	TODO-07: Annotate this class to make it a Spring test class.
//  Include the configuration class you wish to load.
@SpringJUnitConfig(Config.class)
public class PurchaseDaoImplTests {

    // TODO-08: Have Spring inject a PurchaseDao into this class.
    @Autowired
    PurchaseDao dao;
        
    //  TODO-09: Organize imports, save your work.
    //  Notice the two test methods below.
    //  Run these tests.  They should pass and you should see output from the LoggingAspect.
    //  If you do not see the expected output, review your annotations and pointcut expressions.
    //  Done

    @Test
    public void	getAllPurchases() {
        dao.getAllPurchases();
        //  Note: This is not a real test; it is just demonstrating the aspect in action.
    }

    @Test
    public void	getPurchase() {
        dao.getPurchase(2);
        //  Note: This is not a real test; it is just demonstrating the aspect in action.
    }



    //  TODO-16: (OPTIONAL) Remove the @Disabled annotation below.
    //  Run this test.  It should pass and you should see output from the StopwatchAspect.
    //  If you do not see the expected output, review your annotations and pointcut expressions.
    @Test
    public void	savePurchase() {
        Purchase p = new Purchase();
        p.setCustomerName("Sample");
        p.setProduct("Sample Product");
        p.setPurchaseDate( new Date());

        dao.savePurchase(p);
        //  Note: This is not a real test; it is just demonstrating the aspect in action.
    }

}
