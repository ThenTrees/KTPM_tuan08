package com.iuh.fit.se.order_service.controller;

import com.iuh.fit.se.order_service.dto.ProductResponseDto;
import com.iuh.fit.se.order_service.grpc.ProductGrpcClient;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/orders")
@RequiredArgsConstructor
public class OrderController {
    private final ProductGrpcClient productGrpcClient;

    @GetMapping()
    public ResponseEntity<String> getAllOrders() {
        return ResponseEntity.status(HttpStatus.OK).body("Get all orders");
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<ProductResponseDto> getProduct(@PathVariable("id") String id) {
        return ResponseEntity.status(HttpStatus.OK).body(
                productGrpcClient.getProduct(id)
        );
    }

}
