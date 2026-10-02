package com.spring.orderservice.service;

import com.spring.orderservice.entity.Order;
import com.spring.orderservice.model.OrderDTO;
import com.spring.orderservice.repository.OrderRepository;
import com.spring.orderservice.repository.OutboxRepository;
import com.spring.orderservice.utility.OrderDTOToEntityMapper;
import com.spring.orderservice.utility.OrderToOutboxMapper;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OutboxRepository outboxRepository;
    @Transactional
    public Order createOrder(OrderDTO orderDTO) {
        Order order = OrderDTOToEntityMapper.toOrderDTO(orderDTO);
        order = orderRepository.save(order);
        outboxRepository.save(OrderToOutboxMapper.toOutbox(order));
        return order;
    }

}
