package com.furnigo.furniture.domain.model.aggregates;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class ExpertTraits {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;

    private String StoreName;

    private String PhoneNumber;

    private Location Location;

    private Long UserId;

    // private Long CarpentryId;

    // private List<Offer> Offers;

    // private List<Order> Orders;
}
