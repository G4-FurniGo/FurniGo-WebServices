package com.furnigo.furniture.domain.model.valueobjects;

import lombok.Getter;

@Getter
public enum OrderStatus {
    INLINE("inline"),
    BUILDING("building"),
    FINISHED("waiting"),
    CANCELLED("cancelled"),
    DONE("done");

    private final String value;

    OrderStatus(String value) {
        this.value = value;
    }

}
