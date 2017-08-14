package com.eis.model.customer;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "customer")
public class Customer implements Serializable {

    private static final long serialVersionUID = -3009157732242241606L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "enabled")
    private Boolean enabled;
    @Column(name = "name")
    private String name;


    protected Customer() {
    }

    public Customer(Boolean enabled, String name) {
        this.name = name;
        this.enabled = enabled;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", enabled=" + enabled +
                ", name='" + name + '\'' +
                '}';
    }
}
