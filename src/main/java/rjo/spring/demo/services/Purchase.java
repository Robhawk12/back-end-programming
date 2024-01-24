package rjo.spring.demo.services;

import lombok.Data;
import org.springframework.web.bind.annotation.CrossOrigin;
import rjo.spring.demo.entities.Cart;
import rjo.spring.demo.entities.CartItem;
import rjo.spring.demo.entities.Customer;

import java.util.Set;

@Data
public class Purchase {

    private Customer customer;
    private Cart cart;
    private Set<CartItem> cartItems;

}
