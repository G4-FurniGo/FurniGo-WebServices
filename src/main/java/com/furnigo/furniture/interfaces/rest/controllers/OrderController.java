package com.furnigo.furniture.interfaces.rest.controllers;
import com.furnigo.furniture.domain.model.commands.AddDesignToOrderCommand;
import com.furnigo.furniture.domain.model.commands.CreateOrderCommand;
import com.furnigo.furniture.domain.model.commands.UpdateOrderCommand;
import com.furnigo.furniture.domain.model.entities.Design;
import com.furnigo.furniture.domain.model.entities.Offer;
import com.furnigo.furniture.domain.model.entities.Order;
import com.furnigo.furniture.domain.model.queries.GetOrderByIdQuery;
import com.furnigo.furniture.domain.model.queries.GetOrdersByClientIdQuery;
import com.furnigo.furniture.domain.model.queries.GetOrdersByStatusQuery;
import com.furnigo.furniture.domain.model.valueobjects.OrderStatus;
import com.furnigo.furniture.domain.services.OfferQueryService;
import com.furnigo.furniture.interfaces.rest.resources.CreateOrderResource;
import com.furnigo.furniture.interfaces.rest.resources.OrderResource;
import com.furnigo.furniture.interfaces.rest.resources.UpdateOrderResource;
import com.furnigo.furniture.interfaces.rest.transform.OrderResourceFromEntity;
import com.furnigo.iam.domain.model.queries.GetUserRoleByIdQuery;
import com.furnigo.iam.domain.model.valueobjects.UserRole;
import com.furnigo.iam.domain.services.UserQueryService;
import jakarta.transaction.Transactional;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.furnigo.furniture.domain.services.OrderCommandService;
import com.furnigo.furniture.domain.services.OrderQueryService;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import javax.print.attribute.standard.Media;

@RestController
@RequestMapping(value="/api/v1/order", produces = MediaType.APPLICATION_JSON_VALUE)
public class OrderController {
    private final OrderCommandService orderCommandService;
    private final OrderQueryService orderQueryService;
    private final OfferQueryService offerQueryService;
    private final UserQueryService userQueryService;

    public OrderController(OrderCommandService orderCommandService, OrderQueryService orderQueryService, OfferQueryService offerQueryService, UserQueryService userQueryService) {
        this.orderCommandService = orderCommandService;
        this.orderQueryService = orderQueryService;
        this.offerQueryService = offerQueryService;
        this.userQueryService = userQueryService;
    }

    @GetMapping("/all/{userId}")
    @Transactional
    public ResponseEntity<List<OrderResource>> getAllOrders(@PathVariable Long userId)
    {
        var userRole = userQueryService.handle(new GetUserRoleByIdQuery(userId));

        if(userRole == UserRole.CLIENT)
        {
            List<Order> orders = orderQueryService.handle(new GetOrdersByClientIdQuery(userId));
            List<OrderResource> orderResources = orders.stream()
                .map(OrderResourceFromEntity::fromEntity)
                .collect(Collectors.toList());
            return ResponseEntity.ok(orderResources);
        }
        else if(userRole == UserRole.EXPERT)
        {
            // Get all offers by expert id and get the order ids
            List<Offer> offers = offerQueryService.getAllOffersByExpertId(userId);

            List<Long> orderIds = offers.stream()
                .map(Offer::getOrderId)
                .toList();

            List<Order> orders = new ArrayList<>();

            // Get all orders by order ids
            for (Long orderId : orderIds) {
                orders.add(orderQueryService.handle(new GetOrderByIdQuery(orderId)));
            }

            // Transform each order into an OrderResource
            List<OrderResource> orderResources = orders.stream()
                .map(OrderResourceFromEntity::fromEntity)
                .collect(Collectors.toList());

            return ResponseEntity.ok(orderResources);
        }
        else
        {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/{orderId}")
    @Transactional
    public ResponseEntity<OrderResource> getOrder(@PathVariable Long orderId)
    {
        var order = orderQueryService.handle(new GetOrderByIdQuery(orderId));
        return  ResponseEntity.ok(OrderResourceFromEntity.fromEntity(order));
    }

    @PutMapping("/{orderId}")
    @Transactional
    public ResponseEntity<OrderResource> updateOrder(@PathVariable Long orderId, @RequestBody UpdateOrderResource resource) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        Date limitDate;
        try {
            limitDate = formatter.parse(resource.limitDate());
        } catch (ParseException e) {
            throw new RuntimeException("Invalid date format", e);
        }

        var modifiedOrder = new UpdateOrderCommand(
            orderId,
            resource.estimatedPrice(),
            resource.title(),
            limitDate,
            resource.details()
        );

        var order = orderCommandService.handle(modifiedOrder);

        return ResponseEntity.ok(OrderResourceFromEntity.fromEntity(order));
    }

    @PutMapping("/cancel/{orderId}")
    @Transactional
    public void cancelOrder(@PathVariable Long orderId)
    {
        var orderToCancel = orderQueryService.handle(new GetOrderByIdQuery(orderId));
        orderToCancel.updateStatus(OrderStatus.CANCELLED);
        orderCommandService.handle(orderToCancel);
    }

    @PutMapping("/built/{orderId}")
    @Transactional
    public void builtOrder(@PathVariable Long orderId)
    {
        var orderToBuilt = orderQueryService.handle(new GetOrderByIdQuery(orderId));
        orderToBuilt.updateStatus(OrderStatus.BUILDING);
        orderCommandService.handle(orderToBuilt);
    }

    @PutMapping("/finish/{orderId}")
    @Transactional
    public void finishOrder(@PathVariable Long orderId)
    {
        var orderToBuilt = orderQueryService.handle(new GetOrderByIdQuery(orderId));
        orderToBuilt.updateStatus(OrderStatus.FINISHED);
        orderCommandService.handle(orderToBuilt);
    }

    @PutMapping("/done/{orderId}")
    @Transactional
    public void doneOrder(@PathVariable Long orderId)
    {
        var orderToDone = orderQueryService.handle(new GetOrderByIdQuery(orderId));
        orderToDone.updateStatus(OrderStatus.DONE);
        orderCommandService.handle(orderToDone);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<OrderResource> createOrder(@RequestBody CreateOrderResource createOrderResource) throws IOException
    {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        Date limitDate;
        try {
            limitDate = formatter.parse(createOrderResource.limit());
        } catch (ParseException e) {
            throw new RuntimeException("Invalid date format", e);
        }

        var createOrderCommand = new CreateOrderCommand(
            createOrderResource.clientId(),
            createOrderResource.estimate(),
            createOrderResource.title(), limitDate,
            createOrderResource.details()
        );

        var order = orderCommandService.handle(createOrderCommand);

        return ResponseEntity.ok(OrderResourceFromEntity.fromEntity(order));
    }

    @GetMapping("/all/inline/{expertId}")
    @Transactional
    public ResponseEntity<List<OrderResource>> getAllOrdersInline(@PathVariable Long expertId)
    {
        List<Order> ordersInline = orderQueryService.handle(new GetOrdersByStatusQuery(OrderStatus.INLINE));

        // Fetch all offers once
        List<Offer> allOffers = offerQueryService.getAllOffers();

        // Filter offers that are made by the expert
        List<Offer> expertOffers = allOffers.stream()
            .filter(offer -> Objects.equals(offer.getExpertId(), expertId))
            .toList();

        // Get orderIds from expertOffers
        List<Long> expertOfferOrderIds = expertOffers.stream()
            .map(Offer::getOrderId)
            .toList();

        // Remove orders that have an offer from the expert
        ordersInline.removeIf(order -> expertOfferOrderIds.contains(order.getId()));

        return ResponseEntity.ok(ordersInline.stream()
            .map(OrderResourceFromEntity::fromEntity)
            .collect(Collectors.toList()));

    }

    @PostMapping(value = "/appendDesign/{orderId}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Design> appendDesign(@PathVariable("orderId") Long orderId, @RequestParam("file") MultipartFile file) throws IOException{
        var design = orderCommandService.handle(new AddDesignToOrderCommand(
            orderId,
            file.getOriginalFilename(),
            file.getBytes()
        ));

        return ResponseEntity.ok(design);
    } 

}
