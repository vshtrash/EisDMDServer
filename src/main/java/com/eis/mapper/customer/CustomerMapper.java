package com.eis.mapper.customer;


import com.eis.dto.customer.CustomerDto;
import com.eis.dto.customer.ProductDto;
import com.eis.model.customer.Customer;
import com.eis.model.customer.Product;
import org.modelmapper.ModelMapper;

//http://modelmapper.org/getting-started/
public class CustomerMapper {
    public static CustomerDto toDto(Customer customer) {
        ModelMapper modelMapper = new ModelMapper();
        CustomerDto customerDTO = modelMapper.map(customer, CustomerDto.class);
        for (ProductDto productDto : customerDTO.getProducts()) {
            productDto.setCustomerDto(customerDTO);
        }
        return customerDTO;
    }

    public static Customer toEntity(CustomerDto customerDto) {
        ModelMapper modelMapper = new ModelMapper();
        Customer customer = modelMapper.map(customerDto, Customer.class);
        for (Product product : customer.getProducts()) {
            product.setCustomer(customer);
        }
        return customer;
    }


}
