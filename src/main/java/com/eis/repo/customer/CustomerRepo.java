package com.eis.repo.customer;

import com.eis.model.customer.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepo extends CrudRepository<Customer, Long> {
    //List<Customer> findByName(String name);
}
