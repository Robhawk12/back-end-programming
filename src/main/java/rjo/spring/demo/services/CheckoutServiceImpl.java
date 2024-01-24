package rjo.spring.demo.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rjo.spring.demo.dao.CartRepository;
import rjo.spring.demo.dao.CustomerRepository;
import rjo.spring.demo.entities.Cart;
import rjo.spring.demo.entities.CartItem;


import java.util.Set;
import java.util.UUID;

import static rjo.spring.demo.entities.StatusType.ordered;
import static rjo.spring.demo.entities.StatusType.pending;

@Service
public class CheckoutServiceImpl implements CheckoutService{

    private CustomerRepository customerRepository;
    private CartRepository cartRepository;


    public CheckoutServiceImpl(CustomerRepository customerRepository,CartRepository cartRepository){
        this.customerRepository =customerRepository;
        this.cartRepository = cartRepository;
    }

    @Override
    @Transactional
    public PurchaseResponse placeOrder(Purchase purchase) {


        Cart cart = purchase.getCart();
        if (cart.getCart_items().isEmpty())
        {    String order_tracking_number = " Empty Cart";
            cart.setStatus(pending);
            return new PurchaseResponse(order_tracking_number);

        } else {
            cart.setStatus(ordered);

            String order_tracking_number = generateOrderTrackingNumber();
            cart.setOrderTrackingNumber(order_tracking_number);

            Set<CartItem> cartItems = purchase.getCartItems();
            for (CartItem cartItem : cartItems) {
                cart.add(cartItem);
            }


            cartRepository.save(cart);
            //return response
            return new PurchaseResponse(order_tracking_number);
        }
    }
    private String generateOrderTrackingNumber() {
        return UUID.randomUUID().toString();
    }
}
