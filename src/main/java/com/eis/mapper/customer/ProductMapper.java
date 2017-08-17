package com.eis.mapper.customer;


import com.eis.dto.customer.ProductDto;
import com.eis.model.customer.Product;
import org.modelmapper.ModelMapper;

public class ProductMapper {

    public static ProductDto toDto(Product product) {
        ModelMapper modelMapper = new ModelMapper();
        ProductDto prodDTO = modelMapper.map(product, ProductDto.class);
        return prodDTO;
    }
}
