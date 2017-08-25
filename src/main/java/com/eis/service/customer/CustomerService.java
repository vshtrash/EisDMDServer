package com.eis.service.customer;

import com.eis.dto.customer.CustomerDto;
import com.eis.mapper.customer.CustomerMapper;
import com.eis.model.customer.Customer;
import com.eis.repo.customer.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@Service("customerService")
public class CustomerService {
    @Autowired
    CustomerRepo customerRepo;


    @Transactional
    public ArrayList<CustomerDto> getAll() {
        ArrayList<CustomerDto> result = new ArrayList<>();

        for (Customer cust : customerRepo.findAll()) {
            result.add(CustomerMapper.toDto(cust));
        }
        return result;
    }

    @Transactional
    public CustomerDto getById(Long id) {
        return CustomerMapper.toDto(customerRepo.findOne(id));
    }

    @Transactional
    public CustomerDto createCustomer(CustomerDto customerDto) {
        Customer customer = CustomerMapper.toEntity(customerDto);
        customer = customerRepo.save(customer);
        customerDto = CustomerMapper.toDto(customer);
        return customerDto;
    }

    @Transactional
    public CustomerDto updateCustomer(CustomerDto customerDto) {
        Customer customer = CustomerMapper.toEntity(customerDto);
        customer = customerRepo.save(customer);
        customerDto = CustomerMapper.toDto(customer);
        return customerDto;
    }

}
