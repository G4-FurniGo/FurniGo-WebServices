package com.furnigo.furniture.domain.model.commands;

import com.furnigo.furniture.domain.model.valueobjects.OrderStatus;

public record UpdateOrderStatusCommand(Long OrderId, OrderStatus NewStatus) {
}
