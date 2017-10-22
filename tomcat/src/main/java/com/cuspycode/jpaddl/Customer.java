package com.cuspycode.jpaddl;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "CUSTOMER")
public class Customer implements Serializable {
    private long id;
    private String name;
    private String email;

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
}

