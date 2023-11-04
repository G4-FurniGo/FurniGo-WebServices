package com.furnigo.furniture.domain.services;

import com.furnigo.furniture.domain.model.entities.User;
import com.furnigo.furniture.domain.model.queries.GetUserByIdQuery;

public interface UserQueryService {
    User handle(GetUserByIdQuery query);
}
