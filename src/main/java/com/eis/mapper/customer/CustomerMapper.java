package com.eis.mapper.customer;


import com.eis.dto.customer.CustomerDto;
import com.eis.dto.customer.ProductDto;
import com.eis.model.customer.Customer;
import com.eis.model.customer.Product;
import org.modelmapper.ModelMapper;

//http://modelmapper.org/getting-started/
public class CustomerMapper {
    public static CustomerDto toDto(Customer customer) {
        if (customer == null) {
            return null;
        }
        ModelMapper modelMapper = new ModelMapper();
        CustomerDto customerDto = modelMapper.map(customer, CustomerDto.class);
        for (ProductDto productDto : customerDto.getProducts()) {
            productDto.setCustomerDto(customerDto);
        }
        return customerDto;
    }

    public static Customer toEntity(CustomerDto customerDto) {
        if (customerDto == null) {
            return null;
        }
        ModelMapper modelMapper = new ModelMapper();
        Customer customer = modelMapper.map(customerDto, Customer.class);
        for (Product product : customer.getProducts()) {
            product.setCustomer(customer);
        }
        return customer;
    }


}
