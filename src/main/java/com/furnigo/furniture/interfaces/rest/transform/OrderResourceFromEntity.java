package com.furnigo.furniture.interfaces.rest.transform;

import com.furnigo.furniture.domain.model.entities.Order;
import com.furnigo.furniture.interfaces.rest.resources.OrderResource;

public class OrderResourceFromEntity {

    public static OrderResource fromEntity(Order newOrder) {
        return new OrderResource(
                newOrder.getId(),
                newOrder.getClientId(),
                newOrder.getEstimatedPrice(),
                newOrder.getStatus().toString(),
                newOrder.getTitle(),
                newOrder.getLimitDate().toString(),
                newOrder.getDetails(),
                newOrder.getObjectUrl()
        );
    }
}
