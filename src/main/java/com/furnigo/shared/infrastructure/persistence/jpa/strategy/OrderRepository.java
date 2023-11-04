package com.furnigo.shared.infrastructure.persistence.jpa.strategy;

import com.furnigo.furniture.domain.model.aggregates.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
