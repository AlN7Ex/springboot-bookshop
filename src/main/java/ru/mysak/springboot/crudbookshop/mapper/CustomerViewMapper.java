package ru.mysak.springboot.crudbookshop.mapper;

import org.springframework.stereotype.Component;
import ru.mysak.springboot.crudbookshop.entity.Customer;
import ru.mysak.springboot.crudbookshop.view.CustomerView;
import ru.mysak.springboot.crudbookshop.view.OrdersInView;

import java.util.stream.Collectors;

@Component
public class CustomerViewMapper {

    public CustomerView mapToView(Customer customer) {
        CustomerView view = new CustomerView();
        view.setCustomer_id(customer.getCustomer_id());
        view.setName(customer.getName());
        view.setSurname(customer.getSurname());
        view.setBirth(customer.getBirth());
        if (customer.getOrders() != null) {
            view.setOrders(customer.getOrders()
                    .stream()
                    .map(orders -> new OrdersInView(
                            orders.getOrders_id(),
                            orders.getPurchase_amount()
                    ))
                    .collect(Collectors.toList()));
        }

        return view;
    }
}
