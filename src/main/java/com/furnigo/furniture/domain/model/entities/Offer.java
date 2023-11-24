package com.furnigo.furniture.domain.model.entities;

import jakarta.persistence.*;
import lombok.Getter;

import java.util.Date;
import java.util.Optional;

@Entity
@Getter
public class Offer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long orderId;

    private Long expertId;

    private float price;

    private boolean isAccepted;

    private Date limitDate;
}
