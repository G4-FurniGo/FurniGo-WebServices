package com.furnigo.iam.interfaces.rest.resources;

public record LoggedInUserResource(
        UserResource user,
        String accessToken
) {
}
