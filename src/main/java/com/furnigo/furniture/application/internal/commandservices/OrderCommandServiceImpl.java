package com.furnigo.furniture.application.internal.commandservices;

import com.furnigo.furniture.domain.model.commands.AcceptOfferCommand;
import com.furnigo.furniture.domain.model.commands.AddDesignToOrderCommand;
import com.furnigo.furniture.domain.model.commands.CreateOrderCommand;
import com.furnigo.furniture.domain.model.commands.UpdateOrderCommand;
import com.furnigo.furniture.domain.model.entities.Design;
import com.furnigo.furniture.domain.model.entities.Offer;
import com.furnigo.furniture.domain.model.entities.Order;
import com.furnigo.furniture.domain.model.valueobjects.OrderStatus;
import com.furnigo.furniture.domain.services.OrderCommandService;
import com.furnigo.furniture.infrastructure.persistance.jpa.repositories.DesignRepository;
import com.furnigo.furniture.infrastructure.persistance.jpa.repositories.OfferRepository;
import com.furnigo.furniture.infrastructure.persistance.jpa.repositories.OrderRepository;
import org.springframework.stereotype.Service;

@Service
public class OrderCommandServiceImpl implements OrderCommandService {
    private final OrderRepository orderRepository;
    private final OfferRepository offerRepository;
    private final DesignRepository designRepository;

    public OrderCommandServiceImpl(OrderRepository orderRepository, OfferRepository offerRepository, DesignRepository designRepository) {
        this.orderRepository = orderRepository;
        this.offerRepository = offerRepository;
        this.designRepository = designRepository;
    }

    @Override
    public Order handle(AcceptOfferCommand command) {
        var existingOrder = orderRepository.findById(command.orderId());
        var existingOffer = offerRepository.findById(command.offerId());

        if(existingOffer.isEmpty())
            throw new IllegalArgumentException("Offer does not exist");

        if(existingOrder.isEmpty())
            throw new IllegalArgumentException("Order does not exist");

        var orderToUpdate = existingOrder.get();
        Offer offerToUpdate = existingOffer.get();

        offerToUpdate.setAccepted(true);

        orderToUpdate.setEstimatedPrice(offerToUpdate.getPrice());
        orderToUpdate.setLimitDate(offerToUpdate.getLimitDate());
        orderToUpdate.updateStatus(OrderStatus.BUILDING);

        offerRepository.save(offerToUpdate);
        return orderRepository.save(orderToUpdate);
    }

    @Override
    public Order handle(UpdateOrderCommand command) {
        var existingOrder = orderRepository.findById(command.targetOrderId());

        if (existingOrder.isEmpty()) {
            throw new IllegalArgumentException("Order does not exist");
        }

        var orderToUpdate = existingOrder.get();

        orderToUpdate.setDetails(command.details());
        orderToUpdate.setTitle(command.title());
        orderToUpdate.setLimitDate(command.limitDate());
        orderToUpdate.setEstimatedPrice(command.estimatedPrice());

        return orderRepository.save(orderToUpdate);
    }

    @Override
    public void handle(Order updatedStatusOrder) {
        orderRepository.save(updatedStatusOrder);
    }

    @Override
    public Order handle(CreateOrderCommand command) {
        var order = new Order(
            command.clientId(),
            command.estimatedPrice(),
            OrderStatus.INLINE,
            command.title(),
            command.limitDate(),
            command.details()
        );

        return orderRepository.save(order);
    }

    @Override
    public Design handle(AddDesignToOrderCommand command) {
        var design = new Design(
            command.orderId(),
            command.objName(),
            command.objFile()
        );

        return designRepository.save(design);
    }
}
