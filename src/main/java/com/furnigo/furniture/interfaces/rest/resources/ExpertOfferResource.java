package com.furnigo.furniture.interfaces.rest.resources;

import com.furnigo.iam.interfaces.rest.resources.UserResource;

public record ExpertOfferResource(
        OfferResource offer,
        UserResource user
) {
}
