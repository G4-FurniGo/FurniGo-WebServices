package com.furnigo.furniture.domain.model.events;

public record OfferAcceptedEvent(Long OfferId, Long DesignId, Long OrderId) {
}
