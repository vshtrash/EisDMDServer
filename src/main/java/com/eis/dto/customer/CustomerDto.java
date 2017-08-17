package com.eis.dto.customer;


import java.util.ArrayList;
import java.util.List;

public class CustomerDto {
    private long id;

    private Boolean enabled;

    private String name;

    private List<ProductDto> products = new ArrayList<ProductDto>();

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

    public List getProducts() {
        return products;
    }

    public void setProducts(ArrayList<ProductDto> products) {
        this.products = products;
    }
}
