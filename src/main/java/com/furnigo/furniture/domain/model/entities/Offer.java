package com.furnigo.furniture.domain.model.entities;

import jakarta.persistence.*;

import java.util.Date;
import java.util.Optional;

@Entity
public class Offer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;

    private Long OrderId;

    private Long ExpertId;

    private Long UserId;

    private float Price;

    private String Description;

    private Date LimitDate;
}
