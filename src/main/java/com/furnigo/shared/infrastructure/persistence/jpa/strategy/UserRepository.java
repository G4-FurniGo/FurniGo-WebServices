package com.furnigo.shared.infrastructure.persistence.jpa.strategy;

import com.furnigo.furniture.domain.model.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
