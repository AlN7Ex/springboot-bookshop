package ru.mysak.springboot.crudbookshop.view;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookInAuthorView {

    private Integer book_id;

    private String title;

    private String publish_year;

    private Integer pages;

    private Integer price;
}
