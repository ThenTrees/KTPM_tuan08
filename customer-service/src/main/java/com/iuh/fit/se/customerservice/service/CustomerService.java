package com.iuh.fit.se.customerservice.service;

import com.iuh.fit.se.customerservice.model.Customer;
import com.iuh.fit.se.customerservice.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;

    public Customer getCustomer(String phoneNumber) {

        Customer customer = customerRepository.findByPhone(phoneNumber);

        if (customer == null) {
            throw new RuntimeException("Customer not found");
        }

        return customer;
    }

}
