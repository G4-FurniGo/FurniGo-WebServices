package com.furnigo.iam.domain.model.entities;

import com.furnigo.iam.domain.model.valueobjects.UserRole;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;

@Entity
@Getter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private String name;
    @NotNull
    private String lastName;

    private String profilePicture;

    private UserRole role;
    @NotNull
    private String email;
    private String phone;
    @NotNull
    private String password;

    public User() {

    }

    public User(String name, String lastName, String profilePicture, UserRole role, String email, String phone, String password) {
        this.name = name;
        this.lastName = lastName;
        this.profilePicture = profilePicture;
        this.role = role;
        this.email = email;
        this.phone = phone;
        this.password = password;
    }
}
