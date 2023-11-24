package com.furnigo.furniture.application.internal.queryservices;

import com.furnigo.furniture.infrastructure.persistance.jpa.repositories.DesignRepository;
import org.springframework.stereotype.Service;

@Service
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
