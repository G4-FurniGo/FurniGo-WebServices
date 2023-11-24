package com.furnigo.furniture.interfaces.rest.controllers;
import com.furnigo.furniture.interfaces.rest.resources.CreateOrderResource;
import com.furnigo.furniture.interfaces.rest.resources.OrderResource;
import jakarta.transaction.Transactional;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import com.furnigo.furniture.domain.services.OrderCommandService;
import com.furnigo.furniture.domain.services.OrderQueryService;

import java.util.List;

@RestController
@RequestMapping(value="/api/v1/order", produces = MediaType.APPLICATION_JSON_VALUE)
public class OrderController {/*
    private final OrderCommandService orderCommandService;
    private final OrderQueryService orderQueryService;

    public OrderController(OrderCommandService orderCommandService, OrderQueryService orderQueryService) {
        this.orderCommandService = orderCommandService;
        this.orderQueryService = orderQueryService;
    }*/

    @GetMapping("/all/{userId}")
    @Transactional
    public List<OrderResource> getAllOrders(@PathVariable Long userId)
    {
        // Searches in the order table for all orders with the given user id
        // If user is a client, searches in order table for all orders with the given user id
        // If user is an expert, searches in offer tables and lists the id orders. Then searches in order table for all orders with the given id
        // Returns a list of OrderResource objects
        throw new UnsupportedOperationException();
    }

    @GetMapping("/{orderId}")
    @Transactional
    public OrderResource getOrder(@PathVariable Long orderId)
    {
        // Searches in the order table for the order with the given id
        // Returns the order DTO
        throw new UnsupportedOperationException();
    }

    @PutMapping("/{orderId}")
    @Transactional
    public OrderResource updateOrder(@PathVariable Long orderId, @RequestBody OrderResource orderResource)
    {
        // Searches in the order table for the order with the given id
        // Updates the order with the given data
        // Returns the order DTO
        throw new UnsupportedOperationException();
    }

    @PutMapping("/cancel/{orderId}")
    @Transactional
    public void cancelOrder(@PathVariable Long orderId)
    {
        // Searches in the order table for the order with the given id
        // Sets 'CANCELLED' status the order
        throw new UnsupportedOperationException();
    }

    @PutMapping("/built/{orderId}")
    @Transactional
    public void builtOrder(@PathVariable Long orderId)
    {
        // Searches in the order table for the order with the given id
        // Sets 'BUILT' status the order
        throw new UnsupportedOperationException();
    }

    @PutMapping("/done/{orderId}")
    @Transactional
    public void doneOrder(@PathVariable Long orderId)
    {
        // Searches in the order table for the order with the given id
        // Sets 'DONE' status the order
        throw new UnsupportedOperationException();
    }

    @PostMapping
    @Transactional
    public OrderResource createOrder(@RequestBody CreateOrderResource createOrderResource)
    {
        // Creates a new order with the given data
        // Returns the order DTO
        throw new UnsupportedOperationException();
    }

    @GetMapping("/all/inline/{userId}")
    @Transactional
    public List<OrderResource> getAllOrdersInline(@PathVariable Long userId)
    {
        // Searches in the order table for all orders that do not have an offer of the given user id
        // Searches in the order table for orders without an offer
        // Returns a list of OrderResource objects
        throw new UnsupportedOperationException();
    }

}
