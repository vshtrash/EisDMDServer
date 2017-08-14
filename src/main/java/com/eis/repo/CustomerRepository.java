package com.eis.repo;

		import java.util.List;

		import org.springframework.data.repository.CrudRepository;

		import com.eis.model.CustomerTest;

public interface CustomerRepository extends CrudRepository<CustomerTest, Long>{
	List<CustomerTest> findByLastName(String lastName);
}
