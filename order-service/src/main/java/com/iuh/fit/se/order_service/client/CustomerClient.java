package com.iuh.fit.se.order_service.client;

import com.iuh.fit.se.order_service.dto.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "customer-service")
public interface CustomerClient {

    @GetMapping("/{phoneNumber}")
    ResponseEntity<Customer> getCustomer(@PathVariable String phoneNumber);
}
