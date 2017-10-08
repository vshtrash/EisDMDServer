package com.eis.controller.dmdversion;


import com.eis.controller.RestSettingsPath;
import com.eis.dto.customer.CustomerDto;
import com.eis.dto.customer.ProductDto;
import com.eis.dto.dmdversion.DmdVersionDto;
import com.eis.mapper.customer.CustomerMapper;
import com.eis.mapper.dmdversion.DmdVersionMapper;
import com.eis.model.customer.Customer;
import com.eis.model.customer.Product;
import com.eis.repo.customer.ProductRepo;
import com.eis.service.customer.CustomerService;
import com.eis.service.dmdversion.DmdVersionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
public class DmdVersionController {
    protected static final String PATH = RestSettingsPath.DMD_VERSIONS;
    @Autowired
    DmdVersionService dmdVersionService;


    //One
    @RequestMapping(value = PATH + "{id}", method = RequestMethod.GET)
    public ResponseEntity<DmdVersionDto> getDmdVersion(@PathVariable("productId") Long productId, @PathVariable("id") Long id) {
        return ResponseEntity.ok(dmdVersionService.getByProductIdAndId(productId, id));
    }

    //All
    @RequestMapping(value = PATH, method = RequestMethod.GET)
    public ResponseEntity<List<DmdVersionDto>> findAll(@PathVariable("productId") Long productId) {
        return ResponseEntity.ok(dmdVersionService.getAll(productId));
    }

//    //Create
//    @RequestMapping(value = PATH, method = RequestMethod.POST)
//    public ResponseEntity<CustomerDto> createCustomer(@RequestBody CustomerDto customerDto) {
//        CustomerDto result = customerService.createCustomer(customerDto);
//        return ResponseEntity.ok(result);
//    }
//
//
//    //Update
//    @RequestMapping(value = PATH, method = RequestMethod.PUT)
//    public ResponseEntity<CustomerDto> updateCustomer(@RequestBody CustomerDto customerDto) {
//        CustomerDto result = customerService.updateCustomer(customerDto);
//        return ResponseEntity.ok(result);
//    }

}




