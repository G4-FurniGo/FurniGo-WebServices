package com.furnigo.furniture.domain.model.entities;

import com.furnigo.furniture.domain.model.valueobjects.OrderStatus;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import lombok.Getter;

@Entity
@Getter
public class Design {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "objName")
    private String objName;

    @Lob
    @Column(name = "objFile")
    private byte[] objFile;

    private Long orderId;

    public Design() {
    }

    public Design(Long  orderId, String objName, byte[] objFile) {
        this.objFile = objFile;
        this.objName = objName;
        this.orderId = orderId;
    }
}