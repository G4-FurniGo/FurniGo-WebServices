package com.furnigo.furniture.domain.services;

import com.furnigo.furniture.domain.model.commands.CreateDesignCommand;

public interface DesignCommandService {
    Long handle(CreateDesignCommand command);
}
