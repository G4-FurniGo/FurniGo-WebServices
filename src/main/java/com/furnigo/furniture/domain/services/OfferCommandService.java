package com.furnigo.furniture.domain.services;

import com.furnigo.furniture.domain.model.commands.AcceptOfferCommand;
import org.springframework.stereotype.Service;


public interface OfferCommandService {
    void handle (AcceptOfferCommand command);
}
