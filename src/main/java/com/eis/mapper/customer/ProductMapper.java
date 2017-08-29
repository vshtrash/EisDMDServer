package com.eis.mapper.customer;


import com.eis.dto.customer.ProductDto;
import com.eis.model.customer.Product;
import org.modelmapper.ModelMapper;

public class ProductMapper {

    public static ProductDto toDto(Product product) {
        if (product == null) {
            return null;
        }
        ModelMapper modelMapper = new ModelMapper();
        ProductDto prodDto = modelMapper.map(product, ProductDto.class);
        prodDto.setCustomerDto(CustomerMapper.toDto(product.getCustomer()));
        return prodDto;
    }

    public static Product toEntity(ProductDto productDto) {
        if (productDto == null) {
            return null;
        }
        ModelMapper modelMapper = new ModelMapper();
        Product prod = modelMapper.map(productDto, Product.class);
        prod.setCustomer(CustomerMapper.toEntity(productDto.getCustomerDto()));
        return prod;
    }
}
