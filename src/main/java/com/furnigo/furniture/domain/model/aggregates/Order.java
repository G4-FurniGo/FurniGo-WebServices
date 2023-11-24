package com.furnigo.furniture.domain.model.aggregates;

import com.furnigo.furniture.domain.model.valueobjects.OrderDetails;
import com.furnigo.furniture.domain.model.valueobjects.OrderStatus;
import com.furnigo.furniture.domain.model.valueobjects.Resource;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;

@Entity
public class Order {
    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;
    private String Title;
    private String Design;
    private Long CarpentryId;
    private Long UserId;
    private int Estimate;
    private float Price;
    private String Description;
    public OrderStatus Status;
    private String Details;
}
