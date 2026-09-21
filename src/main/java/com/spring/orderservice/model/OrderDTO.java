package com.spring.orderservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderDTO {

    private String name;

    private Long customerId;

    private String productType;

    private Integer quantity;

    private BigDecimal price;

}


