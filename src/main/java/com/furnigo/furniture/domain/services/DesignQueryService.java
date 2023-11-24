package com.furnigo.furniture.domain.services;

import com.furnigo.furniture.domain.model.aggregates.Design;
import com.furnigo.furniture.domain.model.queries.GetDesignByIdQuery;
import org.springframework.stereotype.Service;


public interface DesignQueryService {
    Design handle(GetDesignByIdQuery query);
}
