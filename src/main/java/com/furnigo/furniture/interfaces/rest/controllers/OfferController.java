package com.furnigo.furniture.interfaces.rest.controllers;

import com.furnigo.furniture.domain.model.commands.AcceptOfferCommand;
import com.furnigo.furniture.domain.model.entities.Offer;
import com.furnigo.furniture.domain.model.queries.GetOfferByIdQuery;
import com.furnigo.furniture.domain.services.OfferQueryService;
import com.furnigo.furniture.domain.services.OrderCommandService;
import com.furnigo.furniture.interfaces.rest.resources.*;
import com.furnigo.furniture.interfaces.rest.transform.OfferResourceFromEntity;
import com.furnigo.iam.interfaces.rest.transform.UserResourceFromEntity;
import com.furnigo.iam.domain.model.entities.User;
import com.furnigo.iam.domain.model.queries.GetAllExpertsQuery;
import com.furnigo.iam.domain.services.UserQueryService;
import jakarta.transaction.Transactional;
import org.springframework.web.bind.annotation.*;
import com.furnigo.furniture.interfaces.rest.transform.OrderResourceFromEntity;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value="/api/v1/offer", produces = "application/json")
public class OfferController {
    private final OfferQueryService offerQueryService;
    private final UserQueryService userQueryService;
    private final OrderCommandService orderCommandService;

    /*
    private final OfferCommandService offerCommandService;

    private final OrderQueryService orderQueryService;
    private final OrderCommandService orderCommandService;
*/
    public OfferController(OfferQueryService offerQueryService, UserQueryService userQueryService, OrderCommandService orderCommandService) {
        this.offerQueryService = offerQueryService;
        this.userQueryService = userQueryService;
        this.orderCommandService = orderCommandService;
    }

    @GetMapping("/allFromOrder/{orderId}")
    @Transactional
    public List<ExpertOfferResource> getAllOffersFromOrder(@PathVariable Long orderId) {
    List<Offer> offers = offerQueryService.getAllOffersFromOrder(orderId);

    List<User> experts = userQueryService.handle(new GetAllExpertsQuery());

        List<ExpertOfferResource> expertOfferResources = offers.stream().map(offer -> {
            User expert = experts.stream()
                    .filter(e -> e.getId().equals(offer.getExpertId()))
                    .findFirst()
                    .orElseThrow(() -> new RuntimeException("Expert not found"));

            return new ExpertOfferResource(OfferResourceFromEntity.fromEntity(offer),  UserResourceFromEntity.fromEntity(expert));
        }).collect(Collectors.toList());

    return expertOfferResources;
}

    @PutMapping("/{offerId}")
@Transactional
public OrderResource acceptOffer(@PathVariable Long offerId) {
    Offer offer = offerQueryService.handle(new GetOfferByIdQuery(offerId))
            .orElseThrow(() -> new RuntimeException("Offer not found"));

    var newOrder = orderCommandService.handle( new AcceptOfferCommand(offer.getOrderId(), offerId));

    return OrderResourceFromEntity.fromEntity(newOrder);
}

    @PostMapping
    @Transactional
    public void createOffer(@RequestBody CreateOfferResource createOfferResource)
    {
        // Creates a new offer with the given data
        throw new UnsupportedOperationException();
    }


}
