package com.furnigo.furniture.domain.model.aggregates;

import com.furnigo.furniture.domain.model.valueobjects.OrderDetails;
import com.furnigo.furniture.domain.model.valueobjects.OrderStatus;
import com.furnigo.furniture.domain.model.valueobjects.Resource;
import lombok.Getter;

public class Order {
    private Long Id;
    private String Title;
    private Resource Design;
    private Long CarpentryId;
    private Long UserId;
    private int Estimate;
    private float Price;
    private String Description;
    public OrderStatus Status;
    private OrderDetails Details;
}
