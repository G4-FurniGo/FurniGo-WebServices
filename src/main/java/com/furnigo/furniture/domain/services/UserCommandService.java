package com.furnigo.furniture.domain.services;

import com.furnigo.furniture.domain.model.commands.CreateUserCommand;
import org.springframework.stereotype.Service;


public interface UserCommandService {
    Long handle(CreateUserCommand command);
}
