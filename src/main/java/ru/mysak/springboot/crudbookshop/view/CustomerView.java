package ru.mysak.springboot.crudbookshop.view;

import ru.mysak.springboot.crudbookshop.entity.Orders;

import java.util.List;

public class CustomerView {
    private Integer customer_id;

    private List<Orders> orders;

    private String name;

    private String surname;

    private String birth;
}
