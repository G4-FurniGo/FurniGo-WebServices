package com.furnigo.furniture.infrastructure.persistance.jpa.repositories;

import com.furnigo.furniture.domain.model.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
}
