package com.furnigo.furniture.application.internal.queryservices;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.furnigo.furniture.domain.model.entities.Design;
import com.furnigo.furniture.domain.services.DesignQueryService;
import com.furnigo.furniture.infrastructure.persistance.jpa.repositories.DesignRepository;

@Service
public class DesignQueryServiceImpl implements DesignQueryService{
    private final DesignRepository designRepository;

    public DesignQueryServiceImpl(DesignRepository designRepository) {
        this.designRepository = designRepository;
    }

    @Override
    public Optional<Design> getDesignFromOrder(Long orderId){
        return designRepository.findByOrderId(orderId);
    }
}
