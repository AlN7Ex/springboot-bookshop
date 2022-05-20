package ru.mysak.springboot.crudbookshop.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.annotation.Secured;
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

    @Secured({"ROLE_ADMIN", "ROLE_USER"})
    @GetMapping("/books")
    public List<BookView> readAll() {
        return bookService.getAllBooks()
                .stream()
                .map(bookViewMapper::mapToView)
                .collect(Collectors.toList());
    }

    @Secured({"ROLE_ADMIN", "ROLE_USER"})
    @GetMapping("/books/{id}")
    public BookView read(@PathVariable Integer id) {

        return bookViewMapper.mapToView(bookService.getBook(id));
    }

    @Secured("ROLE_ADMIN")
    @PostMapping("/books")
    public BookView create(@RequestBody Book book) {

        return bookViewMapper.mapToView(bookService.addBook(book));
    }

    @Secured("ROLE_ADMIN")
    @PutMapping("/books/{id}")
    public BookView update(@PathVariable Integer id, @RequestBody BookView body) {

        if (body.getBook_id() == null) {
            throw new EntityNotFoundException("Try to found null entity");
        }
        if (!Objects.equals(id, body.getBook_id())) {
            throw new RuntimeException("Bad id");
        }

        Book book = bookService.getBook(id);
        if (!book.getPages().equals(body.getPages())) {
            book.setPages(body.getPages());
        }
        if (!book.getPublish_year().equals(body.getPublish_year())) {
            book.setPublish_year(body.getPublish_year());
        }

        return bookViewMapper.mapToView(bookService.updateBook(book));

//        try {
//            Book tempBook = bookService.getBook(id);
//            if (tempBook == null) {
//                throw new RuntimeException("Book doesn't exist");
//            }

//
////            tempBook.setTitle(book.getTitle());
//            tempBook.setPublish_year(book.getPublish_year());
//            tempBook.setPages(book.getPages());
//            tempBook.setPrice(book.getPrice());
//
//            return bookViewMapper.mapToView(bookService.updateBook(tempBook));
//        }
//        catch (EntityNotFoundException exc) {
//            log.warn("Entity not found");
//            throw exc;
//        }
    }

    @Secured("ROLE_ADMIN")
    @DeleteMapping("/books/{id}")
    public Boolean delete(@PathVariable Integer id) {
        return bookService.deleteBook(id);
    }
}
