package com.iuh.fit.se.order_service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Customer {
    private Long id;
    private String name;
    private String address;
    private String phone;
}
