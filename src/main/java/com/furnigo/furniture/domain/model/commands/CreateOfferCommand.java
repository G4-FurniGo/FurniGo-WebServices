package com.furnigo.furniture.domain.model.commands;

import java.util.Date;

public record CreateOfferCommand(
        Long orderId,
        Long expertId,
        float price,
        boolean isAccepted,
        Date limitDate
) {
}
