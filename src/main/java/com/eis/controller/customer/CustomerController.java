package com.eis.controller.customer;


import com.eis.dto.customer.CustomerDto;
import com.eis.model.customer.Customer;
import com.eis.repo.customer.CustomerRepo;
import com.eis.service.customer.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class CustomerController {
    protected static final String PATH = "/customers/";
    @Autowired
    CustomerRepo repository;

    @Autowired
    CustomerService customerService;


    @RequestMapping(PATH + "save")
    public ResponseEntity<Customer> process() {
        Customer cust = new Customer(true, "AAA", null);
        cust = repository.save(cust);
        return ResponseEntity.ok(cust);
    }


    @RequestMapping(PATH + "findall")
    public ResponseEntity<List<CustomerDto>> findAll(){

        return ResponseEntity.ok(customerService.getAll());
    }

    @RequestMapping(PATH + "findbyid")
    public String findById(@RequestParam("id") long id) {
        String result = "";
        result = repository.findOne(id).toString();
        return result;
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




