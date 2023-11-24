package com.furnigo.furniture.application.internal.queryservices;

import com.furnigo.furniture.domain.model.entities.User;
import com.furnigo.furniture.infrastructure.persistance.jpa.repositories.UserRepository;
import com.furnigo.iam.domain.services.UserQueryService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserQueryServiceImpl implements UserQueryService {

    private final UserRepository userRepository;

    public UserQueryServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Optional<User> handle(GetUserByIdQuery query) {
        return Optional.ofNullable(userRepository.findById(query.UserId()).orElse(null));
    }

    @Override
    public Optional<User> handle(GetUserByEmailQuery query) {
        return userRepository.findByEmail(query.email());
    }
}
