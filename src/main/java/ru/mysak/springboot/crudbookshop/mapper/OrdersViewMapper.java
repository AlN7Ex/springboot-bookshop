package ru.mysak.springboot.crudbookshop.mapper;

import org.springframework.stereotype.Component;
import ru.mysak.springboot.crudbookshop.entity.Orders;
import ru.mysak.springboot.crudbookshop.view.CustomerInView;
import ru.mysak.springboot.crudbookshop.view.DetailsInView;
import ru.mysak.springboot.crudbookshop.view.OrdersView;

import java.util.stream.Collectors;

@Component
public class OrdersViewMapper {

    public OrdersView mapToView(Orders orders) {
        OrdersView view = new OrdersView();
        view.setOrders_id(orders.getOrders_id());
        view.setCustomer_id(new CustomerInView(
                orders.getCustomer_id().getCustomer_id(),
                orders.getCustomer_id().getName(),
                orders.getCustomer_id().getSurname(),
                orders.getCustomer_id().getBirth()
        ));
        view.setPurchase_amount(orders.getPurchase_amount());
        if (orders.getOrderDetails() != null) {
            view.setOrderDetails(orders.getOrderDetails()
                    .stream()
                    .map(orderDetails -> new DetailsInView(
                            orderDetails.getOrder_details_id(),
                            orderDetails.getOrders_id().getOrders_id(),
                            orderDetails.getBook_id().getBook_id(),
                            orderDetails.getAmount(),
                            orderDetails.getPrice()
                    ))
                    .collect(Collectors.toList()));
        }

        return view;
//        view.setOrderDetails(orders.getOrderDetails()
//                .stream()
//                .map(orderDetails -> new OrderDetails(
//                        orders.getOrders_id(),
//                        orders.
//                )));
    }
}
