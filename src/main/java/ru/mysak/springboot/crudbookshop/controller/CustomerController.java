package ru.mysak.springboot.crudbookshop.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;
import ru.mysak.springboot.crudbookshop.entity.Book;
import ru.mysak.springboot.crudbookshop.entity.Customer;
import ru.mysak.springboot.crudbookshop.entity.OrderDetails;
import ru.mysak.springboot.crudbookshop.entity.Orders;
import ru.mysak.springboot.crudbookshop.mapper.CustomerViewMapper;
import ru.mysak.springboot.crudbookshop.mq.MessageSender;
import ru.mysak.springboot.crudbookshop.service.BookService;
import ru.mysak.springboot.crudbookshop.service.CustomerService;
import ru.mysak.springboot.crudbookshop.view.CustomerView;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RestController
public class CustomerController {

    private final CustomerService customerService;
    private final CustomerViewMapper customerViewMapper;
    private final MessageSender messageSender;
    private final BookService bookService;

    public CustomerController(CustomerService customerService, CustomerViewMapper customerViewMapper, MessageSender messageSender, BookService bookService) {
        this.customerService = customerService;
        this.customerViewMapper = customerViewMapper;
        this.messageSender = messageSender;
        this.bookService = bookService;
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

    @Secured("ROLE_USER")
    @GetMapping("/customers/{id}")
    public CustomerView read(@PathVariable Integer id) {
        StringBuilder text = new StringBuilder("Отчёт о покупках пользователя id["+ id +"]: ");
        List<Orders> orders = customerService.getCustomer(id).getOrders();

        for (Orders ord : orders) {
            for (OrderDetails details : ord.getOrderDetails()) {
                Book book = bookService.getBook(details.getBook_id().getBook_id());
                text.append(book.getTitle()).append(" ");
            }
        }

        messageSender.sendMessage(new String(text));

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
