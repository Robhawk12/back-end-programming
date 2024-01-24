package rjo.spring.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import rjo.spring.demo.dao.CustomerRepository;
import rjo.spring.demo.dao.DivisionRepository;
import rjo.spring.demo.entities.Customer;
import rjo.spring.demo.entities.Division;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {

		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner run(CustomerRepository customerRepository) throws Exception {
		Date date = new Date();
		return args -> {
			 int size = customerRepository.findAll().size();
			 if (size < 5) {

				 Customer customer1 = new Customer(Long.valueOf(2), "Robert", "Johnson", "124 Mountain hwy",
						 "45555", "555-555-5555", null, null, date, date);

				 Customer customer2 = new Customer(Long.valueOf(3), "Jeff", "Johns", "123 Giveway st",
						 "94565", "255-505-5555", null, null, date, date);

				 Customer customer3 = new Customer(Long.valueOf(4), "Karl", "Markus", "34 Democracy Dr",
						 "84565", "355-505-5555", null, null, date, date);

				 Customer customer4 = new Customer(Long.valueOf(5), "Han", "Solo", "77 Get-To-The-Falcon Way",
						 "74565", "455-505-5555", null, null, date, date);

				 customerRepository.save(customer1);
				 customerRepository.save(customer2);
				 customerRepository.save(customer3);
				 customerRepository.save(customer4);

			 }
		};
	}
}















