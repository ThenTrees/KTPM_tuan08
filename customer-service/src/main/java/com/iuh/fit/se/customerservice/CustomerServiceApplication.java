package com.iuh.fit.se.customerservice;
import com.iuh.fit.se.customerservice.model.Customer;
import com.iuh.fit.se.customerservice.repository.CustomerRepository;
import net.datafaker.Faker;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class CustomerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApplication.class, args);
    }
    @Bean
    public CommandLineRunner demo(CustomerRepository customerRepository) {
        return (args) -> {
            // Đợi 1 giây để chắc chắn bảng đã được tạo
            Thread.sleep(1000);

            Faker faker = new Faker();
            List<Customer> products = new ArrayList<>();

            for (int i = 0; i < 20; i++) {
                Customer customer = new Customer();
                customer.setName(faker.name().firstName());
                customer.setPhone(faker.phoneNumber().phoneNumber());
                products.add(customer);
                products.add(customer);
            }
            customerRepository.saveAll(products);
        };
    }
}
