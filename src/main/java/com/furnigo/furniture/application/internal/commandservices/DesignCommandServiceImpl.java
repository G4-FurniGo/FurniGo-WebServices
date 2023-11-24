package com.furnigo.furniture.application.internal.commandservices;

import com.furnigo.furniture.domain.model.aggregates.Design;
import com.furnigo.furniture.domain.model.aggregates.Order;
import com.furnigo.furniture.domain.model.commands.AcceptDesignCommand;
import com.furnigo.furniture.domain.model.commands.CreateDesignCommand;
import com.furnigo.furniture.domain.model.commands.WithdrawDesignCommand;
import com.furnigo.furniture.infrastructure.persistance.jpa.repositories.DesignRepository;
import com.furnigo.furniture.infrastructure.persistance.jpa.repositories.OrderRepository;
import com.furnigo.furniture.infrastructure.persistance.jpa.repositories.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class DesignCommandServiceImpl implements com.furnigo.furniture.domain.services.DesignCommandService {

    private final DesignRepository designRepository;
    private final OrderRepository orderRepository;
    private final UserRepository userRepository;

    public DesignCommandServiceImpl(DesignRepository designRepository, OrderRepository orderRepository, UserRepository userRepository) {
        this.designRepository = designRepository;
        this.orderRepository = orderRepository;
        this.userRepository = userRepository;
    }

    // Creates a new design and saves it to the database.
    @Override
    public Long handle(CreateDesignCommand command) {
        throw new UnsupportedOperationException("Not supported yet.");
        /*var design = new Design();
        designRepository.save(design);
        return null;*/
    }

    // Receives the id of the design to be accepted. Therefore, the design is deleted from the database and a new order is created.
    @Override
    public Long handle(AcceptDesignCommand command) {
        throw new UnsupportedOperationException("Not supported yet.");
        /*var design = designRepository.getById(command.DesignId());
        designRepository.deleteById(command.DesignId());
        var order = new Order();
        orderRepository.save(order);
        return null;*/
    }

    // Deletes a design from the database as the user has withdrawn it.
    @Override
    public Long handle(WithdrawDesignCommand command) {
        throw new UnsupportedOperationException("Not supported yet.");

        /*var design = designRepository.getById(command.DesignId());
        designRepository.deleteById(command.DesignId());
        return null;*/
    }
}
