package com.furnigo.furniture.interfaces.rest.controllers;

import com.furnigo.furniture.domain.model.commands.AcceptOfferCommand;
import com.furnigo.furniture.domain.model.commands.CreateOfferCommand;
import com.furnigo.furniture.domain.model.entities.Offer;
import com.furnigo.furniture.domain.model.queries.GetOfferByIdQuery;
import com.furnigo.furniture.domain.services.OfferCommandService;
import com.furnigo.furniture.domain.services.OfferQueryService;
import com.furnigo.furniture.domain.services.OrderCommandService;
import com.furnigo.furniture.interfaces.rest.resources.*;
import com.furnigo.furniture.interfaces.rest.transform.OfferResourceFromEntity;
import com.furnigo.furniture.interfaces.rest.transform.OrderResourceFromEntity;
import com.furnigo.iam.interfaces.rest.transform.UserResourceFromEntity;
import com.furnigo.iam.domain.model.entities.User;
import com.furnigo.iam.domain.model.queries.GetAllExpertsQuery;
import com.furnigo.iam.domain.services.UserQueryService;
import jakarta.transaction.Transactional;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value="/api/v1/offer", produces = "application/json")
public class OfferController {
    private final OfferQueryService offerQueryService;
    private final UserQueryService userQueryService;
    private final OrderCommandService orderCommandService;
    private final OfferCommandService offerCommandService;

    public OfferController(OfferQueryService offerQueryService, UserQueryService userQueryService, OrderCommandService orderCommandService, OfferCommandService offerCommandService) {
        this.offerQueryService = offerQueryService;
        this.userQueryService = userQueryService;
        this.orderCommandService = orderCommandService;
        this.offerCommandService = offerCommandService;
    }

    @GetMapping("/allFromOrder/{orderId}")
@Transactional
public List<ExpertOfferResource> getAllOffersFromOrder(@PathVariable Long orderId) {
    List<Offer> offers = offerQueryService.getAllOffersFromOrder(orderId);
    List<User> experts = userQueryService.handle(new GetAllExpertsQuery());

    return offers.stream().map(offer -> {
        User expert = experts.stream()
                .filter(e -> e.getId().equals(offer.getExpertId()))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Expert not found"));

        return new ExpertOfferResource(OfferResourceFromEntity.fromEntity(offer),  UserResourceFromEntity.fromEntity(expert));
    }).collect(Collectors.toList());
}

    @PutMapping("/{offerId}")
@Transactional
public ResponseEntity<OrderResource> acceptOffer(@PathVariable Long offerId) {
    Offer offer = offerQueryService.handle(new GetOfferByIdQuery(offerId))
            .orElseThrow(() -> new RuntimeException("Offer not found"));

    var newOrder = orderCommandService.handle( new AcceptOfferCommand(offer.getOrderId(), offerId));

    return ResponseEntity.ok(OrderResourceFromEntity.fromEntity(newOrder));
}

    @PostMapping
@Transactional
public ResponseEntity<Long> createOffer(@RequestBody CreateOfferResource createOfferResource) throws ParseException {
    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
    Date date = formatter.parse(createOfferResource.date());

    var command = new CreateOfferCommand(
        createOfferResource.orderId(),
        createOfferResource.expertId(),
        createOfferResource.price(),
        false,
        date
    );

    return ResponseEntity.ok(offerCommandService.handle(command));
}


}
