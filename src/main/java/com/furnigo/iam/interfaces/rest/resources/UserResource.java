package com.furnigo.iam.interfaces.rest.resources;

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
