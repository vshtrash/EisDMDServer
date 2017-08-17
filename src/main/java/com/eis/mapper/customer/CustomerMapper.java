package com.eis.mapper.customer;


import com.eis.dto.customer.CustomerDto;
import com.eis.model.customer.Customer;
import org.modelmapper.ModelMapper;

//http://modelmapper.org/getting-started/
public  class CustomerMapper {
    public static CustomerDto toDto(Customer customer) {
        ModelMapper modelMapper = new ModelMapper();
        CustomerDto custDTO = modelMapper.map(customer, CustomerDto.class);
        return custDTO;
    }
}
