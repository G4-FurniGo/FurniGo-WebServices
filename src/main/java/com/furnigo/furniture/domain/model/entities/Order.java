package com.furnigo.furniture.domain.model.entities;

import com.furnigo.furniture.domain.model.valueobjects.OrderStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long clientId;
    @Setter
    private float estimatedPrice;

    private OrderStatus status;
    @Setter
    private String title;
    @Setter
    private Date limitDate;
    @Setter
    private String details;

    public Order() {
    }

    public Order(Long clientId, float estimatedPrice, OrderStatus status, String title, Date limitDate, String details) {
        this.clientId = clientId;
        this.estimatedPrice = estimatedPrice;
        this.status = status;
        this.title = title;
        this.limitDate = limitDate;
        this.details = details;
    }

    public void updateStatus(OrderStatus status) {
        if (this.status == OrderStatus.DONE && status == OrderStatus.CANCELLED) {
            throw new IllegalArgumentException("Cannot cancel a done order");
        }

        this.status = status;
    }
}
