package com.eis.service.customer;

import com.eis.dto.customer.CustomerDto;
import com.eis.dto.customer.ProductDto;
import com.eis.mapper.customer.CustomerMapper;
import com.eis.mapper.customer.ProductMapper;
import com.eis.model.customer.Customer;
import com.eis.model.customer.Product;
import com.eis.repo.customer.CustomerRepo;
import com.eis.repo.customer.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@Service("productService")
public class ProductService {
    @Autowired
    CustomerRepo customerRepo;
    @Autowired
    ProductRepo productRepo;


    @Transactional
    public ArrayList<ProductDto> getAll(Long customerId) {
        ArrayList<ProductDto> result = new ArrayList<>();
        if (customerId != null) {
            Customer customer = customerRepo.findOne(customerId);
            if (customer != null) {
                CustomerDto customerDto = CustomerMapper.toDto(customer);
                result = (ArrayList<ProductDto>) customerDto.getProducts();
            }
        }
        return result;
    }

    @Transactional
    public ProductDto getByCustomerAndId(Long customerId, Long id) {
        Product product = productRepo.findOne(id);
        if (product.getCustomer().getId() != customerId) {
            return null;
        }
        return ProductMapper.toDto(product);
    }

    @Transactional
    public ProductDto createUpdateProduct(Long customerId, ProductDto productDto) {
        Customer customer = customerRepo.findOne(customerId);
        if (customer == null || customerId == null) {
            return null;
        }
        Product product = ProductMapper.toEntity(productDto);
        customer.addProduct(product);

        product = productRepo.save(product);
        return ProductMapper.toDto(product);
    }

}

