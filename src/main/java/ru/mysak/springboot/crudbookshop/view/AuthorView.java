package ru.mysak.springboot.crudbookshop.view;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.mysak.springboot.crudbookshop.entity.Book;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthorView {

    private Integer author_id;

    private String name;

    private String surname;

    private List<BookInAuthorView> books;
}
