package ru.mysak.springboot.crudbookshop.view;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.mysak.springboot.crudbookshop.entity.Author;
import ru.mysak.springboot.crudbookshop.entity.OrderDetails;
import ru.mysak.springboot.crudbookshop.entity.StorageBook;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookView {
    private Integer book_id;

    private String title;

    private AuthorView author;

    private StorageBook storageBook;

    private List<OrderDetails> orderDetails;

    private String publish_year;

    private Integer pages;

    private Integer price;
}
