package com.furnigo.furniture.interfaces.rest.resources;

public record UpdateOrderResource(
        float estimatedPrice,
        String title,
        String limitDate,
        String details
) {
}
