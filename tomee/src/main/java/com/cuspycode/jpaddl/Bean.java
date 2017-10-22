package com.cuspycode.jpaddl;

import javax.ejb.*;
import javax.persistence.PersistenceContext;
import javax.persistence.EntityManager;

@Singleton
public class Bean {
    @PersistenceContext(unitName = "JPA-DDL")
    private EntityManager em;

    public Customer getCustomer(long id) {
	return em.find(Customer.class, id);
    }

    public void addCustomer(String name, String email) {
	Customer c = new Customer();
	c.setName(name);
	c.setEmail(email);
	em.persist(c);
    }
}

