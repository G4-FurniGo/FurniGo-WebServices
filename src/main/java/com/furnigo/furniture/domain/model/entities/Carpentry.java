package com.furnigo.furniture.domain.model.entities;

import com.furnigo.furniture.domain.model.aggregates.Location;
import jakarta.persistence.*;

import java.util.Date;
import com.furnigo.furniture.domain.model.aggregates.Location;

@Entity
public class Carpentry {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;

    private String Name;

    @Embedded
    private Location Location;

    private String PhoneNumber;

    private String Email;

    private String Address;

    private Date CreatedAt;
}
