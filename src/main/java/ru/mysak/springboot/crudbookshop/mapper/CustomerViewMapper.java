package ru.mysak.springboot.crudbookshop.mapper;

import ru.mysak.springboot.crudbookshop.entity.Customer;
import ru.mysak.springboot.crudbookshop.view.CustomerView;

public class CustomerViewMapper {

    public CustomerView mapToView(Customer customer) {
        CustomerView view = new CustomerView();
        view.setCustomer_id(customer.getCustomer_id());
        view.setName(customer.getName());
        view.setSurname(customer.getSurname());
        view.setBirth(customer.getBirth());

        return view;
    }
}
