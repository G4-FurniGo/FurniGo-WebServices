package com.furnigo.iam.application.internal.queryservices;

import com.furnigo.iam.domain.model.entities.User;
import com.furnigo.iam.domain.model.queries.GetAllClientsQuery;
import com.furnigo.iam.domain.model.queries.GetAllExpertsQuery;
import com.furnigo.iam.domain.model.queries.GetUserRoleByIdQuery;
import com.furnigo.iam.domain.model.valueobjects.UserRole;
import com.furnigo.iam.domain.services.UserQueryService;
import com.furnigo.iam.infrastructure.persistence.jpa.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserQueryServiceImpl implements UserQueryService{

    private final UserRepository userRepository;

    public UserQueryServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> handle(GetAllClientsQuery query) {
        return userRepository.findAllByRole(UserRole.CLIENT);
    }

    @Override
    public List<User> handle(GetAllExpertsQuery query) {
        return userRepository.findAllByRole(UserRole.EXPERT);
    }

    @Override
    public UserRole handle(GetUserRoleByIdQuery query) {
        return userRepository.findById(query.userId()).map(User::getRole).orElse(null);
    }
}
