package ru.mysak.springboot.crudbookshop.service;

import org.springframework.stereotype.Service;
import ru.mysak.springboot.crudbookshop.entity.Book;
import ru.mysak.springboot.crudbookshop.repository.BookRepository;

import java.util.List;


@Service
public class BookService {

    private final BookRepository repository;

    public BookService(BookRepository bookRepository) {
        this.repository = bookRepository;
    }

    public List<Book> getAllBooks() {
        return repository.getBooks();
    }

    public Book addBook(Book book) {
        return repository.save(book);
    }

    public Book getBookById(Integer id) {

        return repository.getById(id);
    }

    public Boolean delete(Integer id) {
        repository.delete(repository.getById(id));

        return true;
    }
}
