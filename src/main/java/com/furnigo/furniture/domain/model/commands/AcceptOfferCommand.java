package com.furnigo.furniture.domain.model.commands;

public record AcceptOfferCommand(
        Long orderId,
        Long offerId) {
}
