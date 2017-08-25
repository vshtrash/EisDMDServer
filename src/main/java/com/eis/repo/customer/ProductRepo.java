package com.eis.repo.customer;

import com.eis.model.customer.Product;
import org.springframework.data.repository.CrudRepository;


public interface ProductRepo extends CrudRepository<Product, Long> {
    //List<Customer> findByName(String name);
}
