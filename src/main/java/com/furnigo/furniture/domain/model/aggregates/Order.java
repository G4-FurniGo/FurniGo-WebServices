package com.furnigo.furniture.domain.model.aggregates;

import com.furnigo.furniture.domain.model.valueobjects.OrderStatus;
import lombok.Getter;

public class Order {
    private Long Id;
    private Long CarpentryId;

    private Long UserId;
    private float Price;
    private String Description;
    public OrderStatus Status;
}
