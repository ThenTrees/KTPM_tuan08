package com.iuh.fit.se.customerservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Product {
    private String id;
    private String name;
    private String description;
    private double price;
    private int stock;
}
