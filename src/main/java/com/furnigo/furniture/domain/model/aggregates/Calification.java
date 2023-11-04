package com.furnigo.furniture.domain.model.aggregates;

import com.furnigo.furniture.domain.model.entities.Carpentry;
import com.furnigo.furniture.domain.model.entities.User;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

public class Calification {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;

    @Max(5)
    @Min(0)
    private int Score;

    private User Reviewer;

    private Carpentry ReviewedCarpentry;
}
