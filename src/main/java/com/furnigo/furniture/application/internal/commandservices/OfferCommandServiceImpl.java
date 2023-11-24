package com.furnigo.furniture.application.internal.commandservices;

import com.furnigo.furniture.domain.model.commands.CreateOfferCommand;
import com.furnigo.furniture.domain.model.entities.Offer;
import com.furnigo.furniture.domain.services.OfferCommandService;
import com.furnigo.furniture.infrastructure.persistance.jpa.repositories.OfferRepository;
import org.springframework.stereotype.Service;

@Service
public class OfferCommandServiceImpl implements OfferCommandService {
    private final OfferRepository offerRepository;

    public OfferCommandServiceImpl(OfferRepository offerRepository) {
        this.offerRepository = offerRepository;
    }

    @Override
public Long handle(CreateOfferCommand command) {
    var newOffer = new Offer(
        command.orderId(),
        command.expertId(),
        command.price(),
        command.isAccepted(),
        command.limitDate()
    );

    Offer savedOffer = offerRepository.save(newOffer);

    return savedOffer.getId();
    }
}
