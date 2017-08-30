package com.eis.repo.dmdversion;

import com.eis.model.dmdversion.DmdVersion;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DmdVersionRepo extends CrudRepository<DmdVersion, Long> {
    //List<Customer> findByName(String name);
}
