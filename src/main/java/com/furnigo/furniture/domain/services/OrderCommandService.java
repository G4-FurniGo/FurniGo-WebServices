package com.furnigo.furniture.domain.services;

import com.furnigo.furniture.domain.model.commands.CompleteOrderCommand;
import com.furnigo.furniture.domain.model.commands.UpdateOrderStatusCommand;

public interface OrderCommandService {
    Long handle(CompleteOrderCommand command);
    Long handle(UpdateOrderStatusCommand command);
}
