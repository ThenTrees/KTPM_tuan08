package com.iuh.fit.se.customerservice.controller;

import com.iuh.fit.se.customerservice.model.Customer;
import com.iuh.fit.se.customerservice.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/customer")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping("/{phoneNumber}")
    public ResponseEntity<Customer> getCustomer(@PathVariable String phoneNumber) {
        return ResponseEntity.ok(
                customerService.getCustomer(phoneNumber)
        );
    }

}
