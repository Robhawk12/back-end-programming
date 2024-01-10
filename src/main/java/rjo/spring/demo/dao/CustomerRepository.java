package rjo.spring.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import rjo.spring.demo.entities.Customer;

@CrossOrigin
public interface CustomerRepository extends JpaRepository<Customer,Long> {
}
