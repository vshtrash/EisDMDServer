package com.eis.mapper.customer;

import com.eis.dto.customer.CustomerDto;
import com.eis.dto.customer.ProductDto;
import com.eis.model.customer.Customer;
import com.eis.model.customer.Product;
import org.junit.Test;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

public class CustomerMapperTest {
    @Test
    public void toDtoTest() {
        Customer customer = new Customer(true, "CustomerName", new ArrayList<>());
        customer.addProduct(new Product(true, "Prod1", customer));
        customer.addProduct(new Product(true, "Prod2", customer));
        CustomerDto customerDto = CustomerMapper.toDto(customer);

        assertThat(customer.getName()).as("check name: %s", customer.getName()).isEqualTo(customerDto.getName());
        assertThat(customer.getEnabled()).as("check enabled: %s", customer.getEnabled()).isEqualTo(customerDto.getEnabled());
        assertThat(customer.getProducts().size()).as("check count of products: %s", customer.getProducts().size()).isEqualTo(customerDto.getProducts().size());

    }

    @Test
    public void toEntityTest() {
        CustomerDto customerDto = new CustomerDto(1L, true, "CustomerName", new ArrayList<>());
        customerDto.addProduct(new ProductDto(11L, true, "Prod1", customerDto));
        customerDto.addProduct(new ProductDto(22L, true, "Prod1", customerDto));
        Customer customer = CustomerMapper.toEntity(customerDto);

        assertThat(customerDto.getName()).as("check name: %s", customerDto.getName()).isEqualTo(customer.getName());
        assertThat(customerDto.getEnabled()).as("check enabled: %s", customerDto.getEnabled()).isEqualTo(customer.getEnabled());
        assertThat(customerDto.getProducts().size()).as("check count of products: %s", customerDto.getProducts().size()).isEqualTo(customer.getProducts().size());

    }
}





