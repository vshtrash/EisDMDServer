package com.eis.repo.customer;

import com.eis.model.customer.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepo extends CrudRepository<Product, Long> {
    //List<Customer> findByName(String name);
}
