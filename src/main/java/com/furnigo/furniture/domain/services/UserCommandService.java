package com.furnigo.furniture.domain.services;

import com.furnigo.furniture.domain.model.commands.CreateUserCommand;

public interface UserCommandService {
    Long handle(CreateUserCommand command);
}
