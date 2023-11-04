package com.furnigo.furniture.domain.model.commands;

import com.furnigo.furniture.domain.model.aggregates.Design;

public record CreateDesignCommand(Long UserId, String DesignUrl) {
}
