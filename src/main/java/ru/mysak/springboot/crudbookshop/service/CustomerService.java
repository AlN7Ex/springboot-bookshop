package ru.mysak.springboot.crudbookshop.service;

import ru.mysak.springboot.crudbookshop.entity.Customer;
import ru.mysak.springboot.crudbookshop.repository.CustomerRepository;

import java.util.List;

public class CustomerService {

    private final CustomerRepository repository;

    public CustomerService(CustomerRepository repository) {
        this.repository = repository;
    }

    public List<Customer> readAll() {

        return repository.getCustomers();
    }

    public Customer read(Integer id) {

    }
}
