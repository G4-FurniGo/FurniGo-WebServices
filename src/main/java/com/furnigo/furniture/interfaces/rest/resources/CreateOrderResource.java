package com.furnigo.furniture.interfaces.rest.resources;

public record CreateOrderResource(
        String title,
        float estimate,
        String limit,
        String details,
        Long clientId,
        String state
) {
}
