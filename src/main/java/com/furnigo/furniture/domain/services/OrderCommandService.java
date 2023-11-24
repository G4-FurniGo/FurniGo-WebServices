package com.furnigo.furniture.domain.services;


import com.furnigo.furniture.domain.model.commands.AcceptOfferCommand;
import com.furnigo.furniture.domain.model.entities.Order;

public interface OrderCommandService {
    public Order handle(AcceptOfferCommand command);
}
