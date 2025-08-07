package com.example.dao;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.example.Config;
import com.example.domain.Purchase;

@SpringJUnitConfig(Config.class)
public class PurchaseDaoImplTests {

    @Autowired PurchaseDao dao;

    @Test
    @Disabled
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

    @Test
    public void	getPurchase() {
        Purchase p = dao.getPurchase(2);

        //  Make sure the purchase has its properties mapped:
        assertThat(p).isNotNull();
        assertThat(p.getId()).isNotNull();
        assertThat(p.getCustomerName()).isNotNull();
        assertThat(p.getCustomerName()).isEqualTo("Paul");
        assertThat(p.getProduct()).isEqualTo("Football");
    }

    @Test
    public void	savePurchase() {
        Purchase p = new Purchase();
        p.setCustomerName("Sample");
        p.setProduct("Sample Product");
        p.setPurchaseDate( new Date());

        dao.savePurchase(p);
        Purchase newPurchase = dao.getPurchase(p.getCustomerName(),p.getPurchaseDate());

        //  Make sure the purchase was saved properly:
        assertThat(newPurchase).isNotNull();
        assertThat(newPurchase.getId()).isNotNull();
        assertThat(newPurchase.getCustomerName()).isNotNull();
        assertThat(newPurchase.getCustomerName()).isEqualTo(p.getCustomerName());
        assertThat(newPurchase.getProduct()).isEqualTo(p.getProduct());
    }

}
