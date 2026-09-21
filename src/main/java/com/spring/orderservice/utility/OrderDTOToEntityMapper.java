package com.spring.orderservice.utility;

import com.spring.orderservice.entity.Order;
import com.spring.orderservice.model.OrderDTO;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class OrderDTOToEntityMapper {
    public static Order toOrderDTO(OrderDTO orderDTO) {
        return Order.builder()
                .name(orderDTO.getName())
                .price(orderDTO.getPrice())
                .customerId(orderDTO.getCustomerId())
                .orderDate(LocalDateTime.now())
                .quantity(orderDTO.getQuantity())
                .build();
    }
}
