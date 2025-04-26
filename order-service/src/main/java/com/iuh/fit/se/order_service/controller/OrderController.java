package com.iuh.fit.se.order_service.controller;

import com.iuh.fit.se.grpc.product.ProductResponse;
import com.iuh.fit.se.order_service.client.CustomerClient;
import com.iuh.fit.se.order_service.dto.CallExample;
import com.iuh.fit.se.order_service.dto.Customer;
import com.iuh.fit.se.order_service.service.ProductGrpcClient;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/orders")
@RequiredArgsConstructor
public class OrderController {
    private final ProductGrpcClient productGrpcClient;
    private final CustomerClient customerClient;
    @PostMapping
    public String createOrder(@RequestBody CallExample callExample) {

        // Call the customer service to get customer information
        ResponseEntity<Customer> customer = customerClient.getCustomer(callExample.getPhone());
        ProductResponse product = productGrpcClient.GetProduct(callExample.getProductId());

        System.out.println("Customer: " + customer.getBody().toString());
        System.out.println("Product: " + product.toString());
        return "Order created successfully!";
    }



}
