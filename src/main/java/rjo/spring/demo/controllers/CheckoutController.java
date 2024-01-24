package rjo.spring.demo.controllers;

import org.springframework.web.bind.annotation.*;
import rjo.spring.demo.services.CheckoutService;
import rjo.spring.demo.services.Purchase;
import rjo.spring.demo.services.PurchaseResponse;

@CrossOrigin
@RestController
@RequestMapping("/api/checkout")
public class CheckoutController {

    private CheckoutService checkoutService;

    public CheckoutController(CheckoutService checkoutService){
        this.checkoutService = checkoutService;
    }

    @PostMapping("/purchase")
    public PurchaseResponse placeOrder(@RequestBody Purchase purchase){

        PurchaseResponse purchaseResponse = checkoutService.placeOrder(purchase );

        return purchaseResponse;

    }





}
