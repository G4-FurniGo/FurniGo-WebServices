package com.furnigo.furniture.interfaces.rest.resources;

public record CreateOfferResource(
        Long orderId,
        Long expertId,
        float price,
        String date
) {
}
