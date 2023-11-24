package com.furnigo.furniture.domain.services;

import com.furnigo.furniture.domain.model.entities.Offer;
import com.furnigo.furniture.domain.model.queries.GetOfferByIdQuery;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public interface OfferQueryService {
    List<Offer> getAllOffersFromOrder(Long orderId);

    Optional<Offer> handle(GetOfferByIdQuery query);
}
