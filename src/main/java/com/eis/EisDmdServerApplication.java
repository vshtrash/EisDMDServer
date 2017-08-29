package com.eis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

// http://javasampleapproach.com/spring-framework/use-spring-jpa-postgresql-spring-boot


@SpringBootApplication
//@EntityScan(basePackages = {"com.eis."} )
@EnableJpaRepositories(basePackages = {"com.eis.repo"})
public class EisDmdServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(EisDmdServerApplication.class, args);
	}
}
