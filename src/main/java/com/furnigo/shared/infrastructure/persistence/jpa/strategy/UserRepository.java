package com.furnigo.shared.infrastructure.persistence.jpa.strategy;

import com.furnigo.furniture.domain.model.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


public interface UserRepository extends JpaRepository<User, Long> {
}
