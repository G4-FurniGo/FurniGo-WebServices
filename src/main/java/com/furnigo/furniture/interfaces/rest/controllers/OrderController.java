package com.furnigo.furniture.interfaces.rest.controllers;

import com.furnigo.furniture.interfaces.rest.resources.CreateOrderResource;
import jakarta.transaction.Transactional;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import com.furnigo.furniture.domain.services.OrderCommandService;
import com.furnigo.furniture.domain.services.OrderQueryService;

@RestController
@RequestMapping(value="/api/v1/order", produces = MediaType.APPLICATION_JSON_VALUE)
public class OrderController {
    private final OrderCommandService orderCommandService;
    private final OrderQueryService orderQueryService;

    public OrderController(OrderCommandService orderCommandService, OrderQueryService orderQueryService) {
        this.orderCommandService = orderCommandService;
        this.orderQueryService = orderQueryService;
    }

    @PutMapping("/edit")
    @Transactional
    public void editOrder(@RequestBody CreateOrderResource createOrderResource) {
        orderCommandService.editOrder(createOrderResource);
        // Confirm that the order is edited or why is not edited
        // It must be temporal, not edit the actual resource yet
    }

    @PostMapping("/accept-changes")
    @Transactional
    public void acceptChanges(@RequestBody CreateOrderResource createOrderResource) {
        orderCommandService.acceptChanges(createOrderResource);
        // Confirm that the order is accepted or why is not accepted
        // Accept the temporal change
    }

    @DeleteMapping("/cancel")
    @Transactional
    public void cancelOrder(@RequestBody CreateOrderResource createOrderResource) {
        orderCommandService.cancelOrder(createOrderResource);
        // Confirm that the order is canceled or why is not canceled
        // Cancel the temporal change
    }

    @PutMapping("/update")
    @Transactional
    public void updateOrder(@RequestBody CreateOrderResource createOrderResource) {
        orderCommandService.updateOrder(createOrderResource);
        // Only the technician can update. Return if successfully updated
    }
}
