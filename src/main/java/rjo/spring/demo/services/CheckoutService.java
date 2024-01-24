package rjo.spring.demo.services;

import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("http://4200")
public interface CheckoutService {

    PurchaseResponse placeOrder(Purchase purchase);

}
