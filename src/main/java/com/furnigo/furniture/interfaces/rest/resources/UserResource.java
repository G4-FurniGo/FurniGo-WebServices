package com.furnigo.furniture.interfaces.rest.resources;

public record UserResource(
        Long id,
        String name,
        String lastName,
        String pic,
        String role,
        String email,
        String phone
) {
}
