package com.furnigo.furniture.interfaces.rest.transform;

import com.furnigo.furniture.domain.model.entities.Offer;
import com.furnigo.furniture.interfaces.rest.resources.OfferResource;

public class OfferResourceFromEntity {

    public static OfferResource fromEntity(Offer offer) {
        return new OfferResource(
            offer.getId(),
                offer.getOrderId(),
                offer.getExpertId(),
                offer.getPrice(),
                offer.isAccepted(),
                offer.getLimitDate().toString()
        );
    }
}
