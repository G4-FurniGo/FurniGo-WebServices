package com.furnigo.furniture.domain.services;


public interface OrderCommandService {
    Long handle(CompleteOrderCommand command);
    Long handle(UpdateOrderStatusCommand command);
}
