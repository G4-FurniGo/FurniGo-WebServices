package com.furnigo.furniture.domain.model.commands;

public record AddDesignToOrderCommand(
    Long orderId,
    String objName,
    byte[] objFile
) {
    
}
