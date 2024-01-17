package rjo.spring.demo.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rjo.spring.demo.dao.CustomerRepository;
import rjo.spring.demo.entities.Cart;
import rjo.spring.demo.entities.CartItem;
import rjo.spring.demo.entities.Customer;

import java.util.Set;
import java.util.UUID;

@Service
public class CheckoutServiceImpl implements CheckoutService{

    private CustomerRepository customerRepository;


    public CheckoutServiceImpl(CustomerRepository customerRepository){
        this.customerRepository =customerRepository;
    }

    @Override
    @Transactional
    public PurchaseResponse placeOrder(Purchase purchase) {

        //retrieve cart info from purchase
        Cart cart = purchase.getCart();

        //generate tracking number
        String order_tracking_number = generateOrderTrackingNumber();
        cart.setOrder_tracking_number(order_tracking_number);
        //populate cart with cartItems
        Set<CartItem> cartItems = purchase.getCartItems();
        cartItems.forEach(cartItem -> cart.add(cartItem));

        //populate customer with order
        Customer customer = cart.getCustomer();
        customer.add(cart);

        //save to DB
        customerRepository.save(customer);
        //return response
        return new PurchaseResponse(order_tracking_number);
    }

    private String generateOrderTrackingNumber() {
        //generate a rnd UUID
        return UUID.randomUUID().toString();
    }
}
