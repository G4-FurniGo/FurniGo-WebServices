package com.furnigo.furniture.interfaces.rest.controllers;

import com.furnigo.furniture.domain.services.OfferCommandService;
import com.furnigo.furniture.domain.services.OfferQueryService;
import com.furnigo.furniture.domain.services.OrderCommandService;
import com.furnigo.furniture.domain.services.OrderQueryService;
import com.furnigo.furniture.interfaces.rest.resources.AcceptOfferResource;
import com.furnigo.furniture.interfaces.rest.resources.CreateNewOfferResource;
import com.furnigo.furniture.interfaces.rest.resources.DeleteOfferResource;
import jakarta.transaction.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="/api/v1/offer", produces = "application/json")
public class OfferController {
    private final OfferCommandService offerCommandService;
    private final OfferQueryService offerQueryService;
    private final OrderQueryService orderQueryService;
    private final OrderCommandService orderCommandService;

    public OfferController(OfferCommandService offerCommandService, OfferQueryService offerQueryService, OrderCommandService orderCommandService, OrderQueryService orderQueryService) {
        this.offerCommandService = offerCommandService;
        this.offerQueryService = offerQueryService;
        this.orderCommandService = orderCommandService;
        this.orderQueryService = orderQueryService;
    }

    @PostMapping("/new")
    @Transactional
    public void newOffer(@RequestBody CreateNewOfferResource resource)
    {
        offerCommandService.newOffer(resource);
    }

    @DeleteMapping("/remove")
    @Transactional
    public void deleteOffer(@RequestBody DeleteOfferResource resource)
    {
        offerCommandService.deleteOffer(resource);
    }

    @PostMapping("/accept")
    @Transactional
    public void acceptOffer(@RequestBody AcceptOfferResource resource)
    {
        offerCommandService.acceptOffer(resource);
        orderCommandService.createOrder(resource);
        // return order object
    }
}
