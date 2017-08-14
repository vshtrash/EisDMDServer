package com.eis.repo.customer;

import com.eis.model.customer.Customer;
import org.springframework.data.repository.CrudRepository;
import java.util.List;
import java.util.List;
import org.springframework.data.repository.CrudRepository;



public interface CustomerRepo extends CrudRepository<Customer, Long> {
    List<Customer> findByName(String name);
}
