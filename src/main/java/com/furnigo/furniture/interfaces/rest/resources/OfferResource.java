package com.furnigo.furniture.interfaces.rest.resources;

public record OfferResource(
        Long id,
        Long orderId,
        Long expertId,
        float price,
        boolean accepted,
        String limit
) {
}
