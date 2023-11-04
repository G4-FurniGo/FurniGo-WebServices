package com.furnigo.furniture.application.internal.commandservices;

import com.furnigo.furniture.domain.model.commands.AcceptDesignCommand;
import com.furnigo.furniture.domain.model.commands.CreateDesignCommand;
import com.furnigo.furniture.domain.model.commands.WithdrawDesignCommand;
import com.furnigo.shared.infrastructure.persistence.jpa.strategy.DesignRepository;
import com.furnigo.shared.infrastructure.persistence.jpa.strategy.OrderRepository;
import com.furnigo.shared.infrastructure.persistence.jpa.strategy.UserRepository;

public class DesignCommandServiceImpl implements com.furnigo.furniture.domain.services.DesignCommandService {

    private final DesignRepository designRepository;
    private final OrderRepository orderRepository;
    private final UserRepository userRepository;

    public DesignCommandServiceImpl(DesignRepository designRepository, OrderRepository orderRepository, UserRepository userRepository) {
        this.designRepository = designRepository;
        this.orderRepository = orderRepository;
        this.userRepository = userRepository;
    }

    @Override
    public Long handle(CreateDesignCommand command) {
        return null;
    }

    @Override
    public Long handle(AcceptDesignCommand command) {
        return null;
    }

    @Override
    public Long handle(WithdrawDesignCommand command) {
        return null;
    }
}
