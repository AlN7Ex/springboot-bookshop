package ru.mysak.springboot.crudbookshop.controller;

import org.springframework.web.bind.annotation.*;
import ru.mysak.springboot.crudbookshop.entity.Customer;
import ru.mysak.springboot.crudbookshop.mapper.CustomerViewMapper;
import ru.mysak.springboot.crudbookshop.service.CustomerService;
import ru.mysak.springboot.crudbookshop.view.CustomerView;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class CustomerController {

    private final CustomerService customerService;
    private final CustomerViewMapper customerViewMapper;

    public CustomerController(CustomerService customerService, CustomerViewMapper customerViewMapper) {
        this.customerService = customerService;
        this.customerViewMapper = customerViewMapper;
    }

    @GetMapping("/customers")
    public List<CustomerView> readAll() {
        return customerService.getAllCustomers()
                .stream()
                .map(customerViewMapper::mapToView)
                .collect(Collectors.toList());
    }

    @PostMapping("/customers")
    public CustomerView create(@RequestBody Customer customer) {

        return customerViewMapper.mapToView(customerService.addCustomer(customer));
    }

    @GetMapping("/customers/{id}")
    public CustomerView read(@PathVariable Integer id) {
        return customerViewMapper.mapToView(customerService.getCustomer(id));
    }

    @DeleteMapping("/customers/{id}")
    public Boolean delete(@PathVariable Integer id) {
        return customerService.deleteCustomer(id);
    }

//    public CustomerView update(@RequestBody Customer newCustomer, @PathVariable Integer id) {
//        CustomerRepository customerRepository;
//        Customer updatedCustomer = customerRepository.findById(id)
//                .map(customer -> {
//                    customer.setName(newCustomer.getName()),
//                    customer.setSurname(newCustomer.getSurname()),
//                    customer.setBirth(newCustomer.getBirth())
//                });
//    }



}
