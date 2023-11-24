package com.furnigo.furniture.application.internal.eventhandlers;

import com.furnigo.furniture.domain.services.OrderCommandService;
import org.springframework.context.event.EventListener;

public class OrderCompletedEventHandler {
    private final OrderCommandService orderCommandService;

    public OrderCompletedEventHandler(OrderCommandService orderCommandService) {
        this.orderCommandService = orderCommandService;
    }

    @EventListener(OrderCompletedEvent.class)
    public void on(OrderCompletedEvent event) {
        orderCommandService.handle(new CompleteOrderCommand(event.OrderId()));

    }
}
