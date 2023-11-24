package com.furnigo.furniture.infrastructure.persistance.jpa.repositories;

import com.furnigo.furniture.domain.model.aggregates.Design;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DesignRepository extends JpaRepository<Design, Long> {

}
