package com.iuh.fit.se.product_service;

import com.iuh.fit.se.product_service.model.Product;
import com.iuh.fit.se.product_service.repository.ProductRepository;
import net.datafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class ProductServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductServiceApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(ProductRepository productRepository) {
		return (args) -> {
			// Đợi 1 giây để chắc chắn bảng đã được tạo
			Thread.sleep(1000);

			Faker faker = new Faker();
			List<Product> products = new ArrayList<>();

			for (int i = 0; i < 50; i++) {
				Product product = new Product();
				product.setName(faker.commerce().productName());
				product.setDescription(faker.lorem().sentence());
				product.setPrice(Double.valueOf(faker.number().randomDouble(2, 1, 1000)));
				product.setStock(faker.number().numberBetween(1, 100));
				products.add(product);
			}

			productRepository.saveAll(products);
		};
	}
}