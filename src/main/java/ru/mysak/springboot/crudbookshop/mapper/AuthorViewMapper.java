package ru.mysak.springboot.crudbookshop.mapper;

import org.springframework.stereotype.Component;
import ru.mysak.springboot.crudbookshop.entity.Author;
import ru.mysak.springboot.crudbookshop.view.*;

import java.util.stream.Collectors;

@Component
public class AuthorViewMapper {

    public AuthorView mapToView(Author author) {
     AuthorView view = new AuthorView();
     view.setAuthor_id(author.getAuthor_id());
     view.setName(author.getName());
     view.setSurname(author.getSurname());
     if (author.getBooks() != null) {
         view.setBooks(author.getBooks()
                 .stream()
                 .map(book -> new BookInView(
                         book.getBook_id(),
                         book.getTitle(),
                         book.getPublish_year(),
                         book.getPages(),
                         book.getPrice()))
                 .collect(Collectors.toList()));
     }
//             (author.getBooks().stream()
//             .map(book -> new BookInAuthorView(
//                     book.getBook_id(),
//                     book.getTitle(),
//                     book.getPublish_year(),
//                     book.getPages(),
//                     book.getPrice()))
//             .collect(Collectors.toList()));

     return view;
    }
}
