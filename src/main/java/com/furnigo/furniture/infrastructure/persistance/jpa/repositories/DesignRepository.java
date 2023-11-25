package com.furnigo.furniture.infrastructure.persistance.jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.furnigo.furniture.domain.model.entities.Design;
import java.util.List;
import java.util.Optional;


public interface DesignRepository extends JpaRepository<Design, Long> {
    Optional<Design> findByOrderId(Long orderId);
}

