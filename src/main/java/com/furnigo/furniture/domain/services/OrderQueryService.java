package com.furnigo.furniture.domain.services;


import com.furnigo.furniture.domain.model.queries.*;

public interface OrderQueryService {
    Long handle(GetOrderByIdQuery query);
    Long handle(GetOrdersByUserIdQuery query);
}
