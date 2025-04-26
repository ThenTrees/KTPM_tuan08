package com.iuh.fit.se.customerservice.repository;

import com.iuh.fit.se.customerservice.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Customer findByPhone(String phone);

    String phone(String phone);
}
