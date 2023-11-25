package com.furnigo.furniture.domain.model.queries;

import com.furnigo.furniture.domain.model.valueobjects.OrderStatus;

public record GetOrdersByStatusQuery(OrderStatus status) {
}
