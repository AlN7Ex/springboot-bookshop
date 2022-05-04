package ru.mysak.springboot.crudbookshop.view;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.mysak.springboot.crudbookshop.entity.Orders;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerView {
    private Integer customer_id;

//    private List<Orders> orders;

    private String name;

    private String surname;

    private String birth;
}
