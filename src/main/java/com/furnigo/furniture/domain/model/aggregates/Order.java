package com.furnigo.furniture.domain.model.aggregates;

import com.furnigo.furniture.domain.model.valueobjects.OrderStatus;

public class Order {
    private Long Id;
    private Long CarpentryId;
    private Long UserId;
    private float Price;
    private String Description;
    private OrderStatus Status;
}
