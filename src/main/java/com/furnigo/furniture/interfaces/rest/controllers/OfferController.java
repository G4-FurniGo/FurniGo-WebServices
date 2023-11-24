package com.furnigo.furniture.interfaces.rest.controllers;

import com.furnigo.furniture.domain.services.OfferCommandService;
import com.furnigo.furniture.domain.services.OfferQueryService;
import com.furnigo.furniture.domain.services.OrderCommandService;
import com.furnigo.furniture.domain.services.OrderQueryService;
import com.furnigo.furniture.interfaces.rest.resources.*;
import jakarta.transaction.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/api/v1/offer", produces = "application/json")
public class OfferController {/*
    private final OfferCommandService offerCommandService;
    private final OfferQueryService offerQueryService;
    private final OrderQueryService orderQueryService;
    private final OrderCommandService orderCommandService;

    public OfferController(OfferCommandService offerCommandService, OfferQueryService offerQueryService, OrderCommandService orderCommandService, OrderQueryService orderQueryService) {
        this.offerCommandService = offerCommandService;
        this.offerQueryService = offerQueryService;
        this.orderCommandService = orderCommandService;
        this.orderQueryService = orderQueryService;
    }*/

    @GetMapping("/allFromOrder/{orderId}")
    @Transactional
    public List<ExpertOfferResource> getAllOffersFromOrder(@PathVariable Long orderId)
    {
        // Searches in the offer table for all offers with the given order id
        // Gets the offers objects
        // Gets the expert objects from the id in the offer objects
        // Returns a list of ExpertOfferResource objects
        throw new UnsupportedOperationException();

    }

    @PutMapping("/{offerId}")
    @Transactional
    public OrderResource acceptOffer(@PathVariable Long offerId)
    {
        // Gets the data of the offer.
        // Generates a new order with the data of the offer.
        // Deletes the offer.
        // Returns the order DTO
        throw new UnsupportedOperationException();
    }

    @PostMapping
    @Transactional
    public void createOffer(@RequestBody CreateOfferResource createOfferResource)
    {
        // Creates a new offer with the given data
        throw new UnsupportedOperationException();
    }


}
