package com.furnigo.furniture.application.internal.queryservices;

import com.furnigo.furniture.infrastructure.persistance.jpa.repositories.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderQueryServiceImpl implements com.furnigo.furniture.domain.services.OrderQueryService {
    private final OrderRepository orderRepository;

    public OrderQueryServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public Optional<Order> handle(GetOrderByIdQuery query) {
        return orderRepository.findById(query.OrderId());
    }

    @Override
    public List<Order> handle(GetOrdersByUserIdQuery query) {
        // return orderRepository.findAllById();
        return null;
    }
}
