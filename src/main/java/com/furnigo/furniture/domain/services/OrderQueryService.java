package com.furnigo.furniture.domain.services;


import com.furnigo.furniture.domain.model.aggregates.Order;
import com.furnigo.furniture.domain.model.queries.*;

import java.util.List;
import java.util.Optional;

public interface OrderQueryService {
    Optional<Order> handle(GetOrderByIdQuery query);
    List<Order> handle(GetOrdersByUserIdQuery query);
}
