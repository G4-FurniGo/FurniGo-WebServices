package com.furnigo.furniture.application.internal.commandservices;

import com.furnigo.furniture.application.internal.queryservices.OrderQueryServiceImpl;
import com.furnigo.furniture.domain.model.commands.CompleteOrderCommand;
import com.furnigo.furniture.domain.model.commands.UpdateOrderStatusCommand;
import com.furnigo.furniture.domain.model.queries.GetOrderByIdQuery;
import com.furnigo.furniture.domain.model.valueobjects.OrderStatus;
import com.furnigo.shared.infrastructure.persistence.jpa.strategy.OrderRepository;

public class OrderCommandServiceImpl implements com.furnigo.furniture.domain.services.OrderCommandService{

    private final OrderRepository orderRepository;

    public OrderCommandServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    // Sets the status of the order as completed.
    @Override
    public Long handle(CompleteOrderCommand command) {
        var order = orderRepository.getById(command.OrderId());
        order.Status = OrderStatus.COMPLETED;
        orderRepository.save(order);
        return null;
    }

    // Updates the status of the order.
    @Override
    public Long handle(UpdateOrderStatusCommand command) {
        var order = orderRepository.getById(command.OrderId());
        order.Status = command.NewStatus();
        orderRepository.save(order);
        return null;
    }
}
