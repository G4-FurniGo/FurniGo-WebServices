package com.furnigo.furniture.domain.model.commands;

import java.util.Date;

public record CreateOrderCommand(
        Long clientId,
        float estimatedPrice,
        String title,
        Date limitDate,
        String details
) {
}
