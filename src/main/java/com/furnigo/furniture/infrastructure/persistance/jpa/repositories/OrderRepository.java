package com.furnigo.furniture.infrastructure.persistance.jpa.repositories;

import com.furnigo.furniture.domain.model.entities.Order;
import com.furnigo.furniture.domain.model.valueobjects.OrderStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findAllByClientId(Long clientId);

    List<Order> findAllByStatus(OrderStatus status);
}
