package com.furnigo.furniture.interfaces.rest.resources;

public record OrderResource(
        Long id,
        Long clientId,
        float estimate,
        String state,
        String title,
        String limit,
        String details,
        Long modelId
) {
}
