package com.eis.mapper.customer;


import com.eis.dto.customer.ProductDto;
import com.eis.model.customer.Product;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ProductMapperTest {

    @Test
    public void toDto() {
        Product product = new Product(true, "Prod1", null);
        ProductDto productDto = ProductMapper.toDto(product);

        assertThat(product.getName()).as("check name: %s", product.getName()).isEqualTo(productDto.getName());
        assertThat(product.getEnabled()).as("check enabled: %s", product.getEnabled()).isEqualTo(productDto.getEnabled());
    }

}
