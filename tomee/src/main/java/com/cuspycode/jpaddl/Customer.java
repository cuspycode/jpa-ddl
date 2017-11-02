package com.cuspycode.jpaddl;

import java.util.Set;
import java.util.List;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "CUSTOMER")
public class Customer implements Serializable {
    private long id;
    private String name;
    private String email;
    private List<Order> orders;

    public Customer() {
	orders = new ArrayList<Order>();
    }

    @Column(name = "ID")
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    public long getId() { return id; }
    public void setId(long x) { id = x; }

    @Column(name = "NAME")
    public String getName() { return name; }
    public void setName(String x) { name = x; }

    @Column(name = "EMAIL")
    public String getEmail() { return email; }
    public void setEmail(String x) { email = x; }

    @OneToMany(
	       mappedBy = "customer",
	       cascade = CascadeType.ALL,
	       orphanRemoval = true
	       )
    @OrderBy					// Order by primary key
    public List<Order> getOrders() {
	return orders;
    }

    public void setOrders(List<Order> x) {
	orders = x;
    }
}

