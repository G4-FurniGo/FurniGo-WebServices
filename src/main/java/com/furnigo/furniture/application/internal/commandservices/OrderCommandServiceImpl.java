package com.furnigo.furniture.application.internal.commandservices;

import com.furnigo.furniture.domain.model.commands.CompleteOrderCommand;
import com.furnigo.furniture.domain.model.commands.UpdateOrderStatusCommand;

public class OrderCommandServiceImpl implements com.furnigo.furniture.domain.services.OrderCommandService{
    @Override
    public Long handle(CompleteOrderCommand command) {
        return null;
    }

    @Override
    public Long handle(UpdateOrderStatusCommand command) {
        return null;
    }
}
