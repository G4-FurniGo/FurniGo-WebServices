package com.furnigo.furniture.interfaces.rest.controllers;

import com.furnigo.furniture.interfaces.rest.resources.CreateOrderResource;
import jakarta.transaction.Transactional;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import com.furnigo.furniture.domain.services.OrderCommandService;
import com.furnigo.furniture.domain.services.OrderQueryService;

@RestController
@RequestMapping(value="/api/v1/orders", produces = MediaType.APPLICATION_JSON_VALUE)
public class OrderController {
    private final OrderCommandService orderCommandService;
    private final OrderQueryService orderQueryService;

    public OrderController(OrderCommandService orderCommandService, OrderQueryService orderQueryService) {
        this.orderCommandService = orderCommandService;
        this.orderQueryService = orderQueryService;
    }

    @GetMapping
    @Transactional
    public String getOrders() {
        return "Hello World";
    }

    @PostMapping
    @Transactional
    public String createOrder(@RequestBody CreateOrderResource resource) {
        return "Hello World";
    }

}
