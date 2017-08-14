package com.eis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.eis.model.CustomerTest;
import com.eis.repo.CustomerRepository;

@RestController
public class WebController {
	@Autowired
	CustomerRepository repository;
	
	@RequestMapping("/save")
	public String process(){
		repository.save(new CustomerTest("Jack", "Smith"));
		repository.save(new CustomerTest("Adam", "Johnson"));
		repository.save(new CustomerTest("Kim", "Smith"));
		repository.save(new CustomerTest("David", "Williams"));
		repository.save(new CustomerTest("Peter", "Davis"));
		return "Done";
	}
	
	
	@RequestMapping("/findall")
	public String findAll(){
		String result = "<html>";
		
		for(CustomerTest cust : repository.findAll()){
			result += "<div>" + cust.toString() + "</div>";
		}
		
		return result + "</html>";
	}
	
	@RequestMapping("/findbyid")
	public String findById(@RequestParam("id") long id){
		String result = "";
		result = repository.findOne(id).toString();
		return result;
	}
	
	@RequestMapping("/findbylastname")
	public String fetchDataByLastName(@RequestParam("lastname") String lastName){
		String result = "<html>";
		
		for(CustomerTest cust: repository.findByLastName(lastName)){
			result += "<div>" + cust.toString() + "</div>"; 
		}
		
		return result + "</html>";
	}
}

