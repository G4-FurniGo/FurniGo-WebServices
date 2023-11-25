package com.furnigo.furniture.domain.model.commands;

public record CreateDesignCommand(
    Long orderId,
    byte[] objFile,
    String objName){
}
