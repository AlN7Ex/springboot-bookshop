package ru.mysak.springboot.crudbookshop.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import ru.mysak.springboot.crudbookshop.entity.Book;
import ru.mysak.springboot.crudbookshop.mapper.BookViewMapper;
import ru.mysak.springboot.crudbookshop.service.BookService;
import ru.mysak.springboot.crudbookshop.view.BookView;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Slf4j
@RestController
public class BookController {

    private final BookService bookService;
    private final BookViewMapper bookViewMapper;

    public BookController(BookService bookService, BookViewMapper bookViewMapper) {
        this.bookService = bookService;
        this.bookViewMapper = bookViewMapper;
    }

    @GetMapping("/books")
    public List<BookView> readAll() {
        return bookService.getAllBooks()
                .stream()
                .map(bookViewMapper::mapToView)
                .collect(Collectors.toList());
    }

    @GetMapping("/books/{id}")
    public BookView read(@PathVariable Integer id) {

        return bookViewMapper.mapToView(bookService.getBook(id));
    }

    @PostMapping("/books")
    public BookView create(@RequestBody Book book) {

        return bookViewMapper.mapToView(bookService.addBook(book));
    }

//    @PutMapping("/books/{id}")
//    public BookView update(@PathVariable Integer id, @RequestBody Book book) {
//
//        try {
//            Book tempBook = bookService.getBook(id);
//            if (!Objects.equals(id, book.getBook_id())) {
//                throw new RuntimeException("Bad id");
//            }
//            else {
//                return bookViewMapper.mapToView(bookService.updateBook(book));
//            }
//        }
//        catch (EntityNotFoundException exc) {
//            log.warn("Entity not found");
//            throw exc;
//        }
//    }

    @DeleteMapping("/books/{id}")
    public Boolean delete(@PathVariable Integer id) {
        return bookService.deleteBook(id);
    }
}
