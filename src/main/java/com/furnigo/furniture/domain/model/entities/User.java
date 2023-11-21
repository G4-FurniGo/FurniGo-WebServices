package com.furnigo.furniture.domain.model.entities;

import com.furnigo.furniture.domain.model.valueobjects.Resource;
import com.furnigo.furniture.domain.model.valueobjects.UserRole;
import com.furnigo.shared.domain.model.entities.AuditableModel;
import jakarta.persistence.*;
import com.furnigo.furniture.domain.model.valueobjects.Name;

@Entity
public class User extends AuditableModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;

    private UserRole Role;

    @Embedded
    private Name Name;

    private String PhoneNumber;

    private String Email;

    @Embedded
    private Resource ProfilePicture;

    private String Password;
}
