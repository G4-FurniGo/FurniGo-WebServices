package com.furnigo.furniture.application.internal.queryservices;

import com.furnigo.furniture.domain.model.entities.Offer;
import com.furnigo.furniture.domain.model.queries.GetOfferByIdQuery;
import com.furnigo.furniture.domain.services.OfferQueryService;
import com.furnigo.furniture.infrastructure.persistance.jpa.repositories.OfferRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OfferQueryServiceImpl implements OfferQueryService{

    private final OfferRepository offerRepository;

    public OfferQueryServiceImpl(OfferRepository offerRepository) {
        this.offerRepository = offerRepository;
    }

    @Override
    public List<Offer> getAllOffersFromOrder(Long orderId) {
        return offerRepository.findAllByOrderId(orderId);
    }

    @Override
    public Optional<Offer> handle(GetOfferByIdQuery query) {
    return offerRepository.findById(query.offerId());
    }
}
