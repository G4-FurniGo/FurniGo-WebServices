package com.furnigo.furniture.interfaces.rest.resources;

import com.furnigo.furniture.domain.model.entities.User;

public record LoggedInUserResource(
        UserResource user,
        String accessToken
) {
}
