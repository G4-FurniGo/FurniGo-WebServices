package com.furnigo.furniture.domain.model.entities;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
public class Model {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Lob
    @Getter
    private byte[] data;

}
