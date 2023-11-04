package com.furnigo.shared.infrastructure.persistence.jpa.strategy;

import com.furnigo.furniture.domain.model.aggregates.Design;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DesignRepository extends JpaRepository<Design, Long> {

}
