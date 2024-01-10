package rjo.spring.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import rjo.spring.demo.entities.Cart;

@CrossOrigin
public interface CartRepository extends JpaRepository<Cart, Long> {
}
