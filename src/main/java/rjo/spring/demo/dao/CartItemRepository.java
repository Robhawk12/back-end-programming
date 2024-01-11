package rjo.spring.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import rjo.spring.demo.entities.CartItem;

@CrossOrigin("http://localhost:4200")
@RepositoryRestResource(collectionResourceRel = "cartitems", path = "cartitems")
public interface CartItemRepository extends JpaRepository<CartItem, Long> {
}
