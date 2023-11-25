package com.furnigo.furniture.domain.model.entities;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
public class Model {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Lob
    private byte[] data;

    public Model() {
    }

    public Model(byte[] data) {
        this.data = data;
    }

}
