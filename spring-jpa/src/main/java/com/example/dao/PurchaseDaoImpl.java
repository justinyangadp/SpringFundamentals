package com.example.dao;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.domain.Purchase;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

// TODO-06: Annotate to this class to define it as a Spring bean.
// Select the most descriptive stereotype annotation.
@Repository
public class PurchaseDaoImpl implements PurchaseDao {

    //  TODO-07: Use the special JPA annotation to inject the EntityManager into this class.
    //  Hint: do NOT use @Autowired
    @PersistenceContext
    EntityManager em;

    @Override
    public List<Purchase> getAllPurchases() {
        String jpql = "SELECT p FROM Purchase p";

        //  TODO-08: Use the EntityManager to create a query to select all purchases.
        //  Use the JPQL string above to create the query.
        //  Make sure the result returns a List of Purchase objects.
        //  Your code should replace the "return null;" statement.
        return em
            .createQuery(
                jpql,
                Purchase.class)
            .getResultList();
    }

    @Override
    public Purchase getPurchase(int id) {
        //  TODO-09: Use the EntityManager to find a single Purchase by its id.
        //  Hint: use the EntityManager's find method, not createQuery().
        //  Your code should replace the "return null;" statement.
        return em.find(Purchase.class, id);
    }

    @Override
    public Purchase getPurchase(String name, Date date) {
        String jpql = "SELECT p FROM Purchase p WHERE p.customerName = :name AND p.purchaseDate = :date";
        //  TODO-10: Use the EntityManager to create a query to select a single purchase.
        //  Use the JPQL string above to create the query.
        //  Notice that the query has two parameters: :name and :date.
        //  Make sure the result returns a single Purchase object.
        //  Your code should replace the "return null;" statement.
        return em
            .createQuery(jpql, Purchase.class)
            .setParameter("name", name)
            .setParameter("date", date)
            .getSingleResult();
    }

    @Override
    public void savePurchase(Purchase purchase) {
        //  TODO-11: Use the EntityManager to persist the Purchase object.
        //  If the Purchase object has an id < 1, it does not yet exist 
        //  in the DB, so use the persist method.
        //  Otherwise, use the merge method.
        if(purchase.getId() < 1) {
            em.persist(purchase);
        } else {
            em.merge(purchase);
        }
    }

}
