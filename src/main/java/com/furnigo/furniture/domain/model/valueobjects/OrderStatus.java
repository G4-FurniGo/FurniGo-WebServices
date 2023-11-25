package com.furnigo.furniture.domain.model.valueobjects;

import lombok.Getter;

@Getter
public enum OrderStatus {
    INLINE(100),
    BUILDING(200),
    FINISHED(300),
    CANCELLED(400),
    DONE(500);

    private final int value;

    OrderStatus(int value) {
        this.value = value;
    }

}
