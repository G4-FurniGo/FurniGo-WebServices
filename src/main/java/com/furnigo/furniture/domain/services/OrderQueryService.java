package com.furnigo.furniture.domain.services;


import com.furnigo.furniture.domain.model.aggregates.Order;
import com.furnigo.furniture.domain.model.queries.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface OrderQueryService {
    Optional<Order> handle(GetOrderByIdQuery query);
    List<Order> handle(GetOrdersByUserIdQuery query);
}
