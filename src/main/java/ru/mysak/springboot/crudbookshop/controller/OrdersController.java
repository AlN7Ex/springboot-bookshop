package ru.mysak.springboot.crudbookshop.controller;

import org.springframework.web.bind.annotation.*;
import ru.mysak.springboot.crudbookshop.entity.Orders;
import ru.mysak.springboot.crudbookshop.mapper.OrdersViewMapper;
import ru.mysak.springboot.crudbookshop.service.OrdersService;
import ru.mysak.springboot.crudbookshop.view.OrdersView;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class OrdersController {

    private final OrdersService service;
    private final OrdersViewMapper mapper;

    public OrdersController(OrdersService service, OrdersViewMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @GetMapping("/orders")
    public List<OrdersView> readAll() {
        return service.getAllOrders()
                .stream()
                .map(mapper::mapToView)
                .collect(Collectors.toList());
    }

    @PostMapping("/orders")
    public OrdersView create(@RequestBody Orders orders) {

        return mapper.mapToView(service.addOrders(orders));
    }

    @GetMapping("/orders/{id}")
    public OrdersView read(@PathVariable Integer id) {
        return mapper.mapToView(service.getOrders(id));
    }

    @DeleteMapping("/orders/{id}")
    public Boolean delete(@PathVariable Integer id) {
        return service.deleteOrders(id);
    }
}
