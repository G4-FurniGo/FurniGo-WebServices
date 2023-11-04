package com.furnigo.furniture.domain.model.valueobjects;

public record OrderDetails(String details) {

        public OrderDetails {
            if (details == null || details.isBlank()) {
                throw new IllegalArgumentException("Order details cannot be null or blank");
            }
        }
}
