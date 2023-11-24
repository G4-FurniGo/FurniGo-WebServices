package com.furnigo.furniture.interfaces.rest.resources;

public record OrderExpertClientOfferResource(
        OrderResource order,
        UserResource createdBy,
        OfferResource acceptedOffer,
        UserResource acceptedFrom
) {
}
