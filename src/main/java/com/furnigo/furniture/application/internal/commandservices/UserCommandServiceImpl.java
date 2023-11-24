package com.furnigo.furniture.application.internal.commandservices;

import com.furnigo.furniture.domain.model.commands.CreateUserCommand;
import com.furnigo.furniture.domain.model.entities.User;
import com.furnigo.furniture.infrastructure.persistance.jpa.repositories.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserCommandServiceImpl implements com.furnigo.furniture.domain.services.UserCommandService {
    private final UserRepository userRepository;

    public UserCommandServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Long handle(CreateUserCommand command) {
        var newUser = new User();
        userRepository.save(newUser);
        return null;
    }
}
