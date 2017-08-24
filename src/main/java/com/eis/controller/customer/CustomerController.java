package com.eis.controller.customer;


import com.eis.dto.customer.CustomerDto;
import com.eis.model.customer.Customer;
import com.eis.repo.customer.CustomerRepo;
import com.eis.service.customer.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class CustomerController {
    protected static final String PATH = "/customers/";
    @Autowired
    CustomerRepo repository;

    @Autowired
    CustomerService customerService;


    @RequestMapping(value = PATH + "{id}", method = RequestMethod.GET)
    public ResponseEntity<CustomerDto> getCustomer(@PathVariable("id") Long id) {
        return ResponseEntity.ok(customerService.getById(id));
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


    //--------------Example
    @RequestMapping(PATH + "save")
    public ResponseEntity<Customer> process() {
        Customer cust = new Customer(true, "AAA", null);
        cust = repository.save(cust);
        return ResponseEntity.ok(cust);
    }


    @RequestMapping(PATH + "findall")
    public ResponseEntity<List<CustomerDto>> findAll() {

        return ResponseEntity.ok(customerService.getAll());
    }

    @RequestMapping(PATH + "findbyid")
    public CustomerDto findById(@RequestParam("id") long id) {
        return customerService.getById(id);
    }


//    @RequestMapping(PATH + "findbyname")
//    public String fetchDataByLastName(@RequestParam("name") String lastName){
//        String result = "<html>";
//
//        for(Customer cust: repository.findByName(lastName)){
//            result += "<div>" + cust.toString() + "</div>";
//        }
//
//        return result + "</html>";
//    }

}




