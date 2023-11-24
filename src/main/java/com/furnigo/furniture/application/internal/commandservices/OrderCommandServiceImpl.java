package com.furnigo.furniture.application.internal.commandservices;

import com.furnigo.furniture.domain.model.commands.AcceptOfferCommand;
import com.furnigo.furniture.domain.model.entities.Order;
import com.furnigo.furniture.domain.services.OrderCommandService;
import org.springframework.stereotype.Service;

@Service
public class OrderCommandServiceImpl implements OrderCommandService {

    @Override
    public Order handle(AcceptOfferCommand command) {
        return null;
    }
}
