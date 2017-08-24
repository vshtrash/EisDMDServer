package com.eis.dto.customer;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(value = {"customerDto"})
public class ProductDto {
    private long id;
    private Boolean enabled;
    private String name;

    private CustomerDto customerDto;

    public ProductDto() {

    }

    public ProductDto(long id, Boolean enabled, String name, CustomerDto customerDto) {
        this.id = id;
        this.enabled = enabled;
        this.name = name;
        this.customerDto = customerDto;
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

    public CustomerDto getCustomerDto() {
        return customerDto;
    }

    public void setCustomerDto(CustomerDto customerDto) {
        this.customerDto = customerDto;
    }
}
