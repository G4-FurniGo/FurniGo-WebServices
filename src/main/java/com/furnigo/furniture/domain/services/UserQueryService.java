package com.furnigo.furniture.domain.services;

import com.furnigo.furniture.domain.model.queries.GetUserByIdQuery;

public interface UserQueryService {
    Long handle(GetUserByIdQuery query);
}
