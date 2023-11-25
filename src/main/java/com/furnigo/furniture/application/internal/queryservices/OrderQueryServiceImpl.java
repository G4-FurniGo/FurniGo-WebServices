package com.furnigo.furniture.application.internal.queryservices;

import com.furnigo.furniture.domain.model.entities.Order;
import com.furnigo.furniture.domain.model.queries.GetOrderByIdQuery;
import com.furnigo.furniture.domain.model.queries.GetOrdersByClientIdQuery;
import com.furnigo.furniture.domain.model.queries.GetOrdersByStatusQuery;
import com.furnigo.furniture.domain.services.OrderQueryService;
import com.furnigo.furniture.infrastructure.persistance.jpa.repositories.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderQueryServiceImpl implements OrderQueryService {
    private final OrderRepository orderRepository;

    public OrderQueryServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public List<Order> handle(GetOrdersByClientIdQuery query) {
        return orderRepository.findAllByClientId(query.clientId());
    }

    @Override
    public Order handle(GetOrderByIdQuery query) {
        return orderRepository.getReferenceById(query.orderId());
    }

    @Override
    public List<Order> handle(GetOrdersByStatusQuery query) {
        return orderRepository.findAllByStatus(query.status());
    }
}
