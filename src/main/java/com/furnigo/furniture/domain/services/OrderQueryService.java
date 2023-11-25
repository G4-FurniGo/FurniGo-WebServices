package com.furnigo.furniture.domain.services;


import com.furnigo.furniture.domain.model.entities.Order;
import com.furnigo.furniture.domain.model.queries.*;

import java.util.List;

public interface OrderQueryService {
    List<Order> handle(GetOrdersByClientIdQuery query);
    Order handle(GetOrderByIdQuery query);
    List<Order> handle(GetOrdersByStatusQuery query);
}
