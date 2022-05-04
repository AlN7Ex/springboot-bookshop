package ru.mysak.springboot.crudbookshop.view;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DetailsInView {

    private Integer order_details_id;

    private Integer orders_id;

    private Integer book_id;

    private Integer amount;

    private Integer price;
}
