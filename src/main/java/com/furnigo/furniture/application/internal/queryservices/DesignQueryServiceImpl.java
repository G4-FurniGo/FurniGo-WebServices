package com.furnigo.furniture.application.internal.queryservices;

import com.furnigo.furniture.domain.model.aggregates.Design;
import com.furnigo.furniture.domain.model.queries.GetDesignByIdQuery;
import com.furnigo.shared.infrastructure.persistence.jpa.strategy.DesignRepository;

public class DesignQueryServiceImpl implements com.furnigo.furniture.domain.services.DesignQueryService {
    private final DesignRepository designRepository;

    public DesignQueryServiceImpl(DesignRepository designRepository) {
        this.designRepository = designRepository;
    }

    @Override
    public Design handle(GetDesignByIdQuery query) {
        return designRepository.findById(query.designId()).orElse(null);
    }
}
