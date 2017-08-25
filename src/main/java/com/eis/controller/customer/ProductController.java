package com.eis.controller.customer;

import com.eis.controller.ControllerPathNodes;
import com.eis.dto.customer.CustomerDto;
import com.eis.dto.customer.ProductDto;
import com.eis.repo.customer.CustomerRepo;
import com.eis.service.customer.CustomerService;
import com.eis.service.customer.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    protected static final String PATH = ControllerPathNodes.PRODUCTS;
    @Autowired
    ProductService productService;


    //One
    @RequestMapping(value = PATH + "{id}", method = RequestMethod.GET)
    public ResponseEntity<ProductDto> getProduct(@PathVariable("customerId") Long customerId, @PathVariable("id") Long id) {
        return ResponseEntity.ok(productService.getById(id));
    }

    //All
    @RequestMapping(value = PATH, method = RequestMethod.GET)
    public ResponseEntity<List<ProductDto>> findAll(@PathVariable("customerId") Long customerId) {
        return ResponseEntity.ok(productService.getAll(customerId));
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




