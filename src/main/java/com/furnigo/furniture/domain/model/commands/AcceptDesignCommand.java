package com.furnigo.furniture.domain.model.commands;

public record AcceptDesignCommand(Long CarpentryId, Long DesignId, float FinalPrice) {
}
