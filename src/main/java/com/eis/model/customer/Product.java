package com.eis.model.customer;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "products")
public class Product implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "enabled")
    private Boolean enabled;
    @Column(name = "name")
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    protected Product() {
    }

    public Product(Boolean enabled, String name, Customer customer) {
        this.enabled = enabled;
        this.name = name;
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", enabled=" + enabled +
                ", name='" + name + '\'' +
                //", customer=" + customer +
                '}';
    }
}
