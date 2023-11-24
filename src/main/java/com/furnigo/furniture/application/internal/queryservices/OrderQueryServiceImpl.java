package com.furnigo.furniture.application.internal.queryservices;

import com.furnigo.furniture.domain.model.entities.Order;
import com.furnigo.furniture.domain.services.OrderQueryService;
import com.furnigo.furniture.infrastructure.persistance.jpa.repositories.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderQueryServiceImpl implements OrderQueryService {
    private final OrderRepository orderRepository;

    public OrderQueryServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }
}
