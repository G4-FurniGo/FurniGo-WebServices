package com.furnigo.furniture.infrastructure.persistance.jpa.repositories;

import com.furnigo.furniture.domain.model.entities.Model;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModelRepository extends JpaRepository<Model, Long> {

}
