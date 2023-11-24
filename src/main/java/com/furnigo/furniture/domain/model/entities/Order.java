package com.furnigo.furniture.domain.model.entities;

import com.furnigo.furniture.domain.model.valueobjects.OrderStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;

import java.util.Date;

@Entity
@Getter
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long clientId;

    private float estimatedPrice;

    private OrderStatus status;

    private String title;

    private Date limitDate;

    private String details;

    private String objectUrl;
}
