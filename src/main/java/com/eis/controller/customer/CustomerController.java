package com.eis.controller.customer;


import com.eis.model.customer.Customer;
import com.eis.repo.customer.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;


@RestController
public class CustomerController {
    protected static final String PATH = "/customers/";
    @Autowired
    CustomerRepo repository;

    @RequestMapping(PATH + "save")
    public ResponseEntity<Customer> process(){
        Customer cust = new Customer(true, "AAA");
        cust = repository.save(cust);
        return ResponseEntity.ok(cust);
    }


    @RequestMapping(PATH + "findall")
    public ResponseEntity<ArrayList<Customer>> findAll(){
        ArrayList<Customer> result;
        result = (ArrayList<Customer>) repository.findAll();
        //String result = "<html>";

        //for(Customer cust : repository.findAll()){
        //    result += "<div>" + cust.toString() + "</div>";
        //}

        //return result + "</html>";
        return ResponseEntity.ok(result);
    }

    @RequestMapping(PATH + "findbyid")
    public String findById(@RequestParam("id") long id){
        String result = "";
        result = repository.findOne(id).toString();
        return result;
    }

    @RequestMapping(PATH + "findbyname")
    public String fetchDataByLastName(@RequestParam("name") String lastName){
        String result = "<html>";

        for(Customer cust: repository.findByName(lastName)){
            result += "<div>" + cust.toString() + "</div>";
        }

        return result + "</html>";
    }



    @RequestMapping(path=PATH +"greeting", method= RequestMethod.GET)
    public ResponseEntity<Greeting> greeting() {
        Greeting gr = new Greeting(1, "dgdflgkd;flgd;lkglj");
        return ResponseEntity.ok(gr);

    }

}




