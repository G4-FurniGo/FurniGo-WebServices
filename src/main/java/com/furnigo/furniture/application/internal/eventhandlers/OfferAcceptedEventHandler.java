package com.furnigo.furniture.application.internal.eventhandlers;

import com.furnigo.furniture.domain.model.commands.AcceptOfferCommand;
import com.furnigo.furniture.domain.model.events.OfferAcceptedEvent;
import com.furnigo.furniture.domain.services.*;
import org.springframework.context.event.EventListener;

public class OfferAcceptedEventHandler {
    private final OrderCommandService orderCommandService;
    private final DesignCommandService designCommandService;
    private final OfferCommandService offerCommandService;

    public OfferAcceptedEventHandler(OrderCommandService orderCommandService, DesignCommandService designCommandService, OfferCommandService offerCommandService) {
        this.orderCommandService = orderCommandService;
        this.designCommandService = designCommandService;
        this.offerCommandService = offerCommandService;
    }

    @EventListener(OfferAcceptedEvent.class)
    public void on(OfferAcceptedEvent event) {
        var acceptOfferCommand = new AcceptOfferCommand(event.OfferId(), event.DesignId(), event.OrderId());
        offerCommandService.handle(acceptOfferCommand);

    }
}