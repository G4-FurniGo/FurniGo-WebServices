package com.furnigo.iam.domain.services;

import com.furnigo.iam.domain.model.entities.User;
import com.furnigo.iam.domain.model.queries.*;
import com.furnigo.iam.domain.model.valueobjects.UserRole;

import java.util.List;

public interface UserQueryService {
    List<User> handle(GetAllClientsQuery query);

    List<User> handle(GetAllExpertsQuery query);

    UserRole handle(GetUserRoleByIdQuery query);
}
