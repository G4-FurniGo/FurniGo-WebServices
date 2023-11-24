package com.furnigo.furniture.domain.model.entities;

import com.furnigo.furniture.domain.model.valueobjects.Resource;
import com.furnigo.furniture.domain.model.valueobjects.UserRole;
import com.furnigo.shared.domain.model.entities.AuditableModel;
import jakarta.persistence.*;
import com.furnigo.furniture.domain.model.valueobjects.Name;

@Entity
public class User extends AuditableModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private UserRole role;

    @Embedded
    private Name name;

    private String phone;

    private String email;

    private String pic;

    private String password;
}
