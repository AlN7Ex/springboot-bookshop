package ru.mysak.springboot.crudbookshop.view;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrdersView {

    private Integer orders_id;

    private CustomerInView customer_id;

    private Integer purchase_amount;

    private List<DetailsInView> orderDetails;
}
