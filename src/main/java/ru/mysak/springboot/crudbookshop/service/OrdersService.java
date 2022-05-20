package ru.mysak.springboot.crudbookshop.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.mysak.springboot.crudbookshop.entity.Book;
import ru.mysak.springboot.crudbookshop.entity.Orders;
import ru.mysak.springboot.crudbookshop.repository.OrdersRepository;

import java.util.List;

@Service
public class OrdersService {

    private final OrdersRepository repository;

    public OrdersService(OrdersRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public List<Orders> getAllOrders() {
        return repository.getAllOrders();
    }

    @Transactional
    public Orders addOrders(Orders orders) {
        return repository.save(orders);
    }

    @Transactional
    public Orders getOrders(Integer id) {

        return repository.getById(id);
    }

    @Transactional
    public Orders update(Orders orders) {
        return repository.save(orders);
    }

    @Transactional
    public Boolean deleteOrders(Integer id) {
        repository.delete(repository.getById(id));

        return true;
    }
}
