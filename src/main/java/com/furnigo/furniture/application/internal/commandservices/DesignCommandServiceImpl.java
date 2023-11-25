package com.furnigo.furniture.application.internal.commandservices;

import org.aspectj.internal.lang.annotation.ajcDeclareAnnotation;

import com.furnigo.furniture.domain.model.commands.CreateDesignCommand;
import com.furnigo.furniture.domain.model.entities.Design;
import com.furnigo.furniture.domain.services.DesignCommandService;
import com.furnigo.furniture.infrastructure.persistance.jpa.repositories.DesignRepository;

public class DesignCommandServiceImpl implements DesignCommandService{
    private final DesignRepository designRepository;

    public DesignCommandServiceImpl(DesignRepository designRepository) {
        this.designRepository = designRepository;
    }

    @Override
    public Long handle(CreateDesignCommand command) {
        var newDesign = new Design(command.orderId(), command.objName(), command.objFile());

        Design savedDesign = designRepository.save(newDesign);
        
        return savedDesign.getId();
    }
}
