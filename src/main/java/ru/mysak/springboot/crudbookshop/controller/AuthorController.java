package ru.mysak.springboot.crudbookshop.controller;

import org.springframework.web.bind.annotation.*;
import ru.mysak.springboot.crudbookshop.mapper.AuthorViewMapper;
import ru.mysak.springboot.crudbookshop.service.AuthorService;
import ru.mysak.springboot.crudbookshop.view.AuthorView;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class AuthorController {

    private final AuthorService authorService;
    private final AuthorViewMapper authorViewMapper;

    public AuthorController(AuthorService authorService, AuthorViewMapper authorViewMapper) {
        this.authorService = authorService;
        this.authorViewMapper = authorViewMapper;
    }

    @GetMapping("/authors")
    public List<AuthorView> readAll() {
        return authorService.getAllAuthors()
                .stream()
                .map(authorViewMapper::mapToView)
                .collect(Collectors.toList());
    }
//    @GetMapping("/books")
//    public List<BookView> readAll() {
//        return bookService.getAllBooks()
//                .stream()
//                .map(bookViewMapper::mapToView)
//                .collect(Collectors.toList());
//    }
//
//    @PostMapping("/books")
//    public Book create(@RequestBody Book newBook) {
//
//        return bookService.addBook(newBook);
//    }

    @GetMapping("/authors/{id}")
    public AuthorView read(@PathVariable Integer id) {
        return authorViewMapper.mapToView(authorService.getAuthorById(id));
    }
//    @GetMapping("/books/{id}")
//    public BookView read(@PathVariable Integer id) {
//
//        return bookViewMapper.mapToView(bookService.getBookById(id));
//    }
}
