package com.spring.orderservice.utility;

import com.spring.orderservice.entity.Order;
import com.spring.orderservice.entity.Outbox;
import com.spring.orderservice.model.OrderDTO;
import org.springframework.stereotype.Component;
import tools.jackson.databind.ObjectMapper;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Locale;

@Component
public class OrderToOutboxMapper {
    public static Outbox toOutbox(Order order) {
        return Outbox.builder().aggregateId(order.getCustomerId().toString())
                .payload(new ObjectMapper().writeValueAsString(order))
                .processed(false)
                .createdAt(new Date())
                .build();

    }
}
