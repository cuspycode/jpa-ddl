package com.cuspycode.jpaddl;

import java.util.Set;
import java.util.List;

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

    public void addOrder(long id, String orderData) {
	Customer c = em.find(Customer.class, id);
	if (c != null) {
	    Order order = new Order();
	    order.setOrderData(orderData);
	    order.setCustomer(c);
	    c.getOrders().add(order);
	}
	em.persist(c);
    }

    public String showOrders(List<Order> orders) {
	StringBuilder b = new StringBuilder();
	b.append("(");
	String delim = "";
	for (Order o: orders) {
	    b.append(delim);
	    b.append(o.getId());
	    b.append(". ");
	    b.append(o.getOrderData());
	    delim = ", ";
	}
	b.append(")");
	return b.toString();
    }

}

