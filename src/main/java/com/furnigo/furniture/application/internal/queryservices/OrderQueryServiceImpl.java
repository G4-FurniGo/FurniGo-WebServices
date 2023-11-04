package com.furnigo.furniture.application.internal.queryservices;

import com.furnigo.furniture.domain.model.aggregates.Order;
import com.furnigo.furniture.domain.model.queries.GetOrderByIdQuery;
import com.furnigo.furniture.domain.model.queries.GetOrdersByUserIdQuery;
import com.furnigo.shared.infrastructure.persistence.jpa.strategy.OrderRepository;

import java.util.List;
import java.util.Optional;

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
