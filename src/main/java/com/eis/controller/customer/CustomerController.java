package com.eis.controller.customer;


import com.eis.controller.RestSettingsPath;
import com.eis.dto.customer.CustomerDto;
import com.eis.service.customer.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class CustomerController {
    protected static final String PATH = RestSettingsPath.CUSTOMERS;
    @Autowired
    CustomerService customerService;


    //One
    @RequestMapping(value = PATH + "{id}", method = RequestMethod.GET)
    public ResponseEntity<CustomerDto> getCustomer(@PathVariable("id") Long id) {
        return ResponseEntity.ok(customerService.getById(id));
    }

    

    //All
    @RequestMapping(value = PATH, method = RequestMethod.GET)
    public ResponseEntity<List<CustomerDto>> findAll() {
        return ResponseEntity.ok(customerService.getAll());
    }

    //Create
    @RequestMapping(value = PATH, method = RequestMethod.POST)
    public ResponseEntity<CustomerDto> createCustomer(@RequestBody CustomerDto customerDto) {
        CustomerDto result = customerService.createCustomer(customerDto);
        return ResponseEntity.ok(result);
    }


    //Update
    @RequestMapping(value = PATH, method = RequestMethod.PUT)
    public ResponseEntity<CustomerDto> updateCustomer(@RequestBody CustomerDto customerDto) {
        CustomerDto result = customerService.updateCustomer(customerDto);
        return ResponseEntity.ok(result);
    }

}




