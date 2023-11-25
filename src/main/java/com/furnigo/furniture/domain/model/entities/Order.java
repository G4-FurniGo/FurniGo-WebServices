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

    private Long modelId;

    public Order() {
    }

    public Order(Long clientId, float estimatedPrice, OrderStatus status, String title, Date limitDate, String details, Long modelId) {
        this.clientId = clientId;
        this.estimatedPrice = estimatedPrice;
        this.status = status;
        this.title = title;
        this.limitDate = limitDate;
        this.details = details;
        this.modelId = modelId;
    }

    public void updateStatus(OrderStatus status) {
        if (this.status == OrderStatus.DONE && status == OrderStatus.CANCELLED) {
            throw new IllegalArgumentException("Cannot cancel a done order");
        }

        if(this.status.getValue() > status.getValue()) {
            throw new IllegalArgumentException("Cannot update status to a previous one");
        }

        this.status = status;
    }
}
