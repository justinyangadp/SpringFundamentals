package com.example.service;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.dao.PurchaseDao;
import com.example.domain.Purchase;

//  TODO-17: (OPTIONAL) Annotate this class as a Mockito test class.
//  You will need to use the JUnit @ExtendWith annotation combined with the MockitoExtension class.
//  This test will use Java, JUnit, Mockito, and AssertJ.  It will not use Spring.

public class PurchaseServiceImplTests {

    //	TODO-18: (OPTIONAL) Define a variable called purchaseDao of type PurchaseDao.
    //  Annotate this variable with @Mock.


    //  TODO-19: (OPTIONAL) Define a variable called purchaseService of type PurchaseServiceImpl.
    //  Annotate this variable with @InjectMocks.  This tells Mockito to inject it with the mock purchaseDao.
    

    @Test
    public void testFindAllPurchases() {
        List<Purchase> expectedPurchases = expectedPurchases();

        //  TODO-20: (OPTIONAL) Use Mockito's when() method to program the mock.
        //  When the mock's getAllPurchases() method is called, 
        //  then return expectedPurchases (defined above).

        
        //  TODO-21: (OPTIONAL) Call the method under test.
        //  Capture the results of the findAllPurchases() method in a variable.

        
        //  TODO-22: (OPTIONAL) Test the result.
        //  Assert that the returned result contains the same elements in the expectedPurchase list.

        
        //  TODO-23: (OPTIONAL) Verify that the mock had its getAllPurchases() method called.
        //  Hint: use the verify() method.  Your mock object is the parameter to this method.
        //  (For some tests, verify() is critical; for others, it's trivial.)


    }
    //  TODO-24: Organize your imports, save your work
    //  Run this test class.  All tests should pass.

    //  Sample test data:
    private List<Purchase> expectedPurchases() {
        return  List.of(
            new Purchase(1, "Praveen", new Date(), "lava lamp"),
            new Purchase(2, "Srinivas", new Date(), "badmitton set"),
            new Purchase(3, "Ramachandran", new Date(), "parachute retainer clip"),
            new Purchase(4, "Sunil", new Date(), "scuba regulator")
        );
    }

}
