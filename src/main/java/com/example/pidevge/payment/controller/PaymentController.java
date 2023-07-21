package com.example.pidevge.payment.controller;


import com.example.pidevge.payment.service.StripeClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/payment")
public class PaymentController {
    private StripeClient stripeClient;

    @Autowired
    PaymentController(StripeClient stripeClient) {
        this.stripeClient = stripeClient;
    }

//    @PreAuthorize("hasAnyAuthority('USER', 'ADMIN')")
    @PostMapping("/charge")
    public ResponseEntity<String> chargeCard(HttpServletRequest request) throws Exception {
        String token = request.getHeader("token");
        Double amount = Double.parseDouble(request.getHeader("amount"));
        System.out.println("Payment was called");
        this.stripeClient.chargeCreditCard(token, amount);
        return ResponseEntity.status(HttpStatus.OK).body("Charged");
    }

}
