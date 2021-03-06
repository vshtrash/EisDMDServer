package com.eis.model.customer;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "customers")
public class Customer implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "enabled")
    private Boolean enabled;
    @Column(name = "name")
    private String name;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "customer", cascade = CascadeType.ALL)
    private List<Product> products = new ArrayList<>();

    protected Customer() {
    }

    public Customer(Boolean enabled, String name, List<Product> products) {
        this.enabled = enabled;
        this.name = name;
        if (products == null) {
            this.products = new ArrayList<>();
        } else {
            this.products = products;
        }
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }

    public Product addProduct(Product product) {
        product.setCustomer(this);
        this.getProducts().add(product);
        return product;
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
