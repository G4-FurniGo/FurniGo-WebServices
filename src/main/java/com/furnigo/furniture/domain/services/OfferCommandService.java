package com.furnigo.furniture.domain.services;


import com.furnigo.furniture.domain.model.commands.CreateOfferCommand;

public interface OfferCommandService {
    Long handle(CreateOfferCommand command);
}
