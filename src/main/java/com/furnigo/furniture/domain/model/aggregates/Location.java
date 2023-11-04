package com.furnigo.furniture.domain.model.aggregates;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

public class Location {
    private Long Id;
    private float Latitude;
    private float Longitude;
    private int CarpentryId;
}
