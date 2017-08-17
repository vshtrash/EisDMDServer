package com.eis.mapper.customer;

import com.eis.dto.customer.CustomerDto;
import com.eis.model.customer.Customer;
import com.eis.model.customer.Product;
import org.junit.Test;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

public class CustomerMapperTest {
    @Test
    public void toDto() {
        Customer customer = new Customer(true, "CustomerName", new ArrayList<>());
        customer.getProducts().add(new Product(true, "Prod1", customer));
        customer.getProducts().add(new Product(true, "Prod2", customer));
        CustomerDto customerDto = CustomerMapper.toDto(customer);

        assertThat(customer.getName()).as("check name: %s", customer.getName()).isEqualTo(customerDto.getName());
        assertThat(customer.getEnabled()).as("check enabled: %s", customer.getEnabled()).isEqualTo(customerDto.getEnabled());
        assertThat(customer.getProducts().size()).as("check count of products: %s", customer.getProducts().size()).isEqualTo(customerDto.getProducts().size());

    }
}





