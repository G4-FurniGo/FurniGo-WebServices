package com.furnigo.iam.infrastructure.persistence.jpa.repositories;

import com.furnigo.iam.domain.model.entities.User;
import com.furnigo.iam.domain.model.valueobjects.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);

    boolean existsByEmail(String email);

    List<User> findAllByRole(UserRole role);
}
