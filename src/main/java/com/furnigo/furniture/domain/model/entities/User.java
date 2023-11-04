package com.furnigo.furniture.domain.model.entities;

import com.furnigo.shared.domain.model.entities.AuditableModel;
import jakarta.persistence.*;
import com.furnigo.furniture.domain.model.valueobjects.Name;

@Entity
public class User extends AuditableModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;

    @Embedded
    private Name Name;

    private String PhoneNumber;

    private String Email;

    private String Address;

    private String Password;
}
