package com.furnigo.furniture.domain.model.commands;

public record CreateOfferCommand(Long CarpentryId, Long UserId, float Price, String Description) {
}
