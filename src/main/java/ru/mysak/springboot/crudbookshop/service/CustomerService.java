package ru.mysak.springboot.crudbookshop.service;

import org.springframework.stereotype.Service;
import ru.mysak.springboot.crudbookshop.entity.Customer;
import ru.mysak.springboot.crudbookshop.repository.CustomerRepository;

import java.util.List;

@Service
public class CustomerService {

    private final CustomerRepository repository;

    public CustomerService(CustomerRepository repository) {
        this.repository = repository;
    }

    public List<Customer> getAllCustomers() {

        return repository.getCustomers();
    }

    public Customer getCustomer(Integer id) {
        return repository.getById(id);
    }

    public Customer addCustomer(Customer customer) {
        return repository.save(customer);
    }

    public Boolean deleteCustomer(Integer id) {
        repository.delete(repository.getById(id));

        return true;
    }
}
