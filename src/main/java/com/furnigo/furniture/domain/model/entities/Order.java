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

    public Order() {
    }

    public Order(Long clientId, float estimatedPrice, OrderStatus status, String title, Date limitDate, String details, String objectUrl) {
        this.clientId = clientId;
        this.estimatedPrice = estimatedPrice;
        this.status = status;
        this.title = title;
        this.limitDate = limitDate;
        this.details = details;
        this.objectUrl = objectUrl;
    }
}
