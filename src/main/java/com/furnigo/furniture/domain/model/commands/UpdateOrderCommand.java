package com.furnigo.furniture.domain.model.commands;

import java.util.Date;

public record UpdateOrderCommand(
        Long targetOrderId,
        float estimatedPrice,
        String title,
        Date limitDate,
        String details
) {
}
