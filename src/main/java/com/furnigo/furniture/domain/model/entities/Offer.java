package com.furnigo.furniture.domain.model.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
public class Offer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long orderId;

    private Long expertId;

    private float price;

    @Setter
    private boolean isAccepted;

    private Date limitDate;

    public Offer() {
    }

    public Offer(Long orderId, Long expertId, float price, boolean isAccepted, Date limitDate) {
        this.orderId = orderId;
        this.expertId = expertId;
        this.price = price;
        this.isAccepted = isAccepted;
        this.limitDate = limitDate;
    }
}
