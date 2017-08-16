package com.eis.model.customer;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "customers")
public class Customer implements Serializable {

    private static final long serialVersionUID = -3009157732242241606L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "enabled")
    private Boolean enabled;
    @Column(name = "name")
    private String name;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "customer")
    private Set<Product> products = new HashSet<Product>(0);

    protected Customer() {
    }

    public Customer(Boolean enabled, String name, Set<Product> products) {
        this.enabled = enabled;
        this.name = name;
        this.products = products;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", enabled=" + enabled +
                ", name='" + name + '\'' +
                ", products=" + products +
                '}';
    }
}
