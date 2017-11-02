package com.cuspycode.jpaddl;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "ORDERS")
public class Order implements Serializable {
    private long id;
    private Customer customer;
    private String orderData;

    @Column(name = "ORDER_ID")
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    public long getId() { return id; }
    public void setId(long x) { id = x; }


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID")
    public Customer getCustomer() { return customer; }
    public void setCustomer(Customer x) { customer = x; }

    @Column(name = "ORDERDATA")
    public String getOrderData() { return orderData; }
    public void setOrderData(String x) { orderData = x; }

}

