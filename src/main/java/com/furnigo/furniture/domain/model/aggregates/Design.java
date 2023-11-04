package com.furnigo.furniture.domain.model.aggregates;

import com.furnigo.shared.domain.model.entities.AuditableModel;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Optional;

public class Design extends AuditableModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;

    private Optional<Integer> OrderId;

    private int UserId;

    private String DesignUrl;
}
