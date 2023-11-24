package com.furnigo.furniture.infrastructure.persistance.jpa.repositories;

import com.furnigo.furniture.domain.model.entities.Offer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OfferRepository extends JpaRepository<Offer, Long> {
    List<Offer> findAllByOrderId(Long orderId);
}
