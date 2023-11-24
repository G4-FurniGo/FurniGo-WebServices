package com.furnigo.furniture.interfaces.rest.resources;

import com.furnigo.iam.interfaces.rest.resources.UserResource;

public record OrderExpertClientOfferResource(
        OrderResource order,
        UserResource createdBy,
        OfferResource acceptedOffer,
        UserResource acceptedFrom
) {
}
