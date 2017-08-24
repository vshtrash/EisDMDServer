package com.eis.mapper.customer;


import com.eis.dto.customer.CustomerDto;
import com.eis.dto.customer.ProductDto;
import com.eis.model.customer.Customer;
import com.eis.model.customer.Product;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ProductMapperTest {

    @Test
    public void toDtoTest() {
        Product product = new Product(true, "Prod1", null);
        Customer customer = new Customer(true, "name", null);
        customer.getProducts().add(product);
        product.setCustomer(customer);

        ProductDto productDto = ProductMapper.toDto(product);

        assertThat(product.getName()).as("check name: %s", product.getName()).isEqualTo(productDto.getName());
        assertThat(product.getEnabled()).as("check enabled: %s", product.getEnabled()).isEqualTo(productDto.getEnabled());
        assertThat(product.getCustomer().getName()).as("check customer name: %s", product.getCustomer().getName()).isEqualTo(productDto.getCustomerDto().getName());
    }

    @Test
    public void toEntityTest() {
        ProductDto productDto = new ProductDto(1L, true, "Prod1", null);
        CustomerDto customerDto = new CustomerDto(11L, true, "name", null);
        customerDto.getProducts().add(productDto);
        productDto.setCustomerDto(customerDto);

        Product product = ProductMapper.toEntity(productDto);

        assertThat(productDto.getName()).as("check name: %s", productDto.getName()).isEqualTo(product.getName());
        assertThat(productDto.getEnabled()).as("check enabled: %s", productDto.getEnabled()).isEqualTo(product.getEnabled());
        assertThat(productDto.getCustomerDto().getId()).as("check customer id: %s", productDto.getCustomerDto().getId()).isEqualTo(product.getCustomer().getId());
    }
}
