package com.furnigo.furniture.application.internal.queryservices;

import com.furnigo.furniture.domain.model.entities.User;
import com.furnigo.furniture.domain.model.queries.GetUserByEmailQuery;
import com.furnigo.furniture.domain.model.queries.GetUserByIdQuery;
import com.furnigo.furniture.infrastructure.persistance.jpa.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserQueryServiceImpl implements com.furnigo.furniture.domain.services.UserQueryService{

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
