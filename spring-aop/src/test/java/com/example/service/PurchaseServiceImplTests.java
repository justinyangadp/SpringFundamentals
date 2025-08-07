package com.example.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.example.Config;


@SpringJUnitConfig(Config.class)
public class PurchaseServiceImplTests {

    @Autowired PurchaseService purchaseService;  
    

    @Test
    public void testSavePurchase() {

    }


}
