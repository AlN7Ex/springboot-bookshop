package ru.mysak.springboot.crudbookshop.controller;

import org.springframework.web.bind.annotation.*;
import ru.mysak.springboot.crudbookshop.entity.Book;
import ru.mysak.springboot.crudbookshop.mapper.BookViewMapper;
import ru.mysak.springboot.crudbookshop.service.BookService;
import ru.mysak.springboot.crudbookshop.view.BookView;

import java.util.List;
import java.util.stream.Collectors;

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

    @PostMapping("/books")
    public BookView create(@RequestBody Book newBook) {

        return bookViewMapper.mapToView(bookService.addBook(newBook));
    }

    @GetMapping("/books/{id}")
    public BookView read(@PathVariable Integer id) {

        return bookViewMapper.mapToView(bookService.getBookById(id));
    }

//    public Book update(@RequestBody Book book, @PathVariable Integer id) {
//
//    }

    @DeleteMapping("/books/{id}")
    public Boolean delete(@PathVariable Integer id) {
        return bookService.delete(id);
    }
}
