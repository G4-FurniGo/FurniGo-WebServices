package com.furnigo.furniture.domain.services;


import com.furnigo.furniture.domain.model.commands.AcceptOfferCommand;
import com.furnigo.furniture.domain.model.commands.CreateOrderCommand;
import com.furnigo.furniture.domain.model.commands.UpdateOrderCommand;
import com.furnigo.furniture.domain.model.entities.Order;

public interface OrderCommandService {
    Order handle(AcceptOfferCommand command);
    Order handle(UpdateOrderCommand command);
    void handle(Order updatedStatusOrder);

    Order handle(CreateOrderCommand command);
}
