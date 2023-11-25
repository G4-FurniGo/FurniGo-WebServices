package com.furnigo.furniture.domain.services;

import java.util.Optional;

import com.furnigo.furniture.domain.model.entities.Design;

public interface DesignQueryService {
    Optional<Design> getDesignFromOrder(Long orderId);
}
