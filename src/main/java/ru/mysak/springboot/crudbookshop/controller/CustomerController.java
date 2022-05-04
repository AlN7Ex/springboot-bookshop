package ru.mysak.springboot.crudbookshop.controller;

import ru.mysak.springboot.crudbookshop.mapper.CustomerViewMapper;
import ru.mysak.springboot.crudbookshop.service.CustomerService;

public class CustomerController {

    private final CustomerService customerService;
    private final CustomerViewMapper customerViewMapper;

    public CustomerController(CustomerService customerService, CustomerViewMapper customerViewMapper) {
        this.customerService = customerService;
        this.customerViewMapper = customerViewMapper;
    }
}
