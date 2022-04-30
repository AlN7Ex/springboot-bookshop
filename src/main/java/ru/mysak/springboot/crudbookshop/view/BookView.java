package ru.mysak.springboot.crudbookshop.view;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookView {
    private Integer book_id;

    private String title;

    private AuthorInView author;

//    public StorageView storage;

//    private List<OrderDetails> orderDetails;

    private String publish_year;

    private Integer pages;

    private Integer price;
}
