package ru.mysak.springboot.crudbookshop.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;
import ru.mysak.springboot.crudbookshop.entity.Orders;
import ru.mysak.springboot.crudbookshop.mapper.OrdersViewMapper;
import ru.mysak.springboot.crudbookshop.service.OrdersService;
import ru.mysak.springboot.crudbookshop.view.OrdersView;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RestController
public class OrdersController {

    private final OrdersService orderService;
    private final OrdersViewMapper ordersViewMapper;

    public OrdersController(OrdersService service, OrdersViewMapper mapper) {
        this.orderService = service;
        this.ordersViewMapper = mapper;
    }

    @Secured({"ROLE_ADMIN","ROLE_USER"})
    @GetMapping("/orders")
    public List<OrdersView> readAll() {
        return orderService.getAllOrders()
                .stream()
                .map(ordersViewMapper::mapToView)
                .collect(Collectors.toList());
    }

    @PostMapping("/orders")
    public OrdersView create(@RequestBody Orders orders) {

        return ordersViewMapper.mapToView(orderService.addOrders(orders));
    }

    @Secured({"ROLE_ADMIN", "ROLE_USER"})
    @GetMapping("/orders/{id}")
    public OrdersView read(@PathVariable Integer id) {
        return ordersViewMapper.mapToView(orderService.getOrders(id));
    }

    @Secured("ROLE_USER")
    @PutMapping("/orders/{id}")
    public OrdersView update(@PathVariable Integer id, @RequestBody OrdersView body) {
        if (body.getOrders_id() == null) {
            throw new EntityNotFoundException("Try to found null entity");
        }
        if (!Objects.equals(id, body.getOrders_id())) {
            throw new RuntimeException("Bad id");
        }

        Orders orders = orderService.getOrders(id);

        if (!orders.getPurchase_amount().equals(body.getPurchase_amount())) {
            orders.setPurchase_amount(body.getPurchase_amount());
        }

        orderService.update(orders);

        return ordersViewMapper.mapToView(orders);

    }

    @Secured("ROLE_ADMIN")
    @DeleteMapping("/orders/{id}")
    public Boolean delete(@PathVariable Integer id) {
        return orderService.deleteOrders(id);
    }
}
