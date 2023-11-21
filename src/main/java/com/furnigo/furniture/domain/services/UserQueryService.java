package com.furnigo.furniture.domain.services;

import com.furnigo.furniture.domain.model.entities.User;
import com.furnigo.furniture.domain.model.queries.GetUserByEmailQuery;
import com.furnigo.furniture.domain.model.queries.GetUserByIdQuery;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface UserQueryService {
    Optional<User> handle(GetUserByIdQuery query);

    Optional<User> handle(GetUserByEmailQuery query);
}
