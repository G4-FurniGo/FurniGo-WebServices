package com.furnigo.furniture.application.internal.eventhandlers;

import com.furnigo.furniture.domain.services.*;
import org.springframework.context.event.EventListener;

public class OfferAcceptedEventHandler {
    private final OrderCommandService orderCommandService;
    private final OfferCommandService offerCommandService;

    public OfferAcceptedEventHandler(OrderCommandService orderCommandService, OfferCommandService offerCommandService) {
        this.orderCommandService = orderCommandService;
        this.offerCommandService = offerCommandService;
    }
}