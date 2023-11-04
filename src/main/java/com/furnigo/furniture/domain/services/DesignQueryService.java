package com.furnigo.furniture.domain.services;

import com.furnigo.furniture.domain.model.queries.GetDesignByIdQuery;

public interface DesignQueryService {
    Long handle(GetDesignByIdQuery query);
}
