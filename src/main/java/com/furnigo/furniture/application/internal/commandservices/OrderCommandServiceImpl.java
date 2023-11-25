package com.furnigo.furniture.application.internal.commandservices;

import com.furnigo.furniture.domain.model.commands.AcceptOfferCommand;
import com.furnigo.furniture.domain.model.commands.CreateOrderCommand;
import com.furnigo.furniture.domain.model.commands.UpdateOrderCommand;
import com.furnigo.furniture.domain.model.entities.Order;
import com.furnigo.furniture.domain.model.valueobjects.OrderStatus;
import com.furnigo.furniture.domain.services.OrderCommandService;
import com.furnigo.furniture.infrastructure.persistance.jpa.repositories.OrderRepository;
import org.springframework.stereotype.Service;

@Service
public class OrderCommandServiceImpl implements OrderCommandService {
    private final OrderRepository orderRepository;

    public OrderCommandServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public Order handle(AcceptOfferCommand command) {
        return null;
    }

    @Override
    public Order handle(UpdateOrderCommand command) {
        var existingOrder = orderRepository.findById(command.targetOrderId());

        if (existingOrder.isEmpty()) {
            throw new IllegalArgumentException("Order does not exist");
        }

        var orderToUpdate = existingOrder.get();

        orderToUpdate.setDetails(command.details());
        orderToUpdate.setTitle(command.title());
        orderToUpdate.setLimitDate(command.limitDate());
        orderToUpdate.setEstimatedPrice(command.estimatedPrice());

        return orderRepository.save(orderToUpdate);
    }

    @Override
    public void handle(Order updatedStatusOrder) {
        orderRepository.save(updatedStatusOrder);
    }

    @Override
    public Order handle(CreateOrderCommand command) {
        var order = new Order(
            command.clientId(),
            command.estimatedPrice(),
            OrderStatus.INLINE,
            command.title(),
            command.limitDate(),
            command.details(),
            command.objectUrl()
        );
        return orderRepository.save(order);
    }
}
