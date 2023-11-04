package com.furnigo.furniture.application.internal.queryservices;

import com.furnigo.furniture.domain.model.entities.User;
import com.furnigo.furniture.domain.model.queries.GetUserByIdQuery;
import com.furnigo.shared.infrastructure.persistence.jpa.strategy.UserRepository;

public class UserQueryServiceImpl implements com.furnigo.furniture.domain.services.UserQueryService{

    private final UserRepository userRepository;

    public UserQueryServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User handle(GetUserByIdQuery query) {
        return userRepository.findById(query.UserId()).orElse(null);
    }
}
