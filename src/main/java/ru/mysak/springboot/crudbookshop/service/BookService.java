package ru.mysak.springboot.crudbookshop.service;

import org.springframework.stereotype.Service;
import ru.mysak.springboot.crudbookshop.entity.Book;
import ru.mysak.springboot.crudbookshop.repository.BookRepository;

import java.util.List;


@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> customFindAllBookByAuthorId(Integer id) {
        return bookRepository.customFindAllBookByAuthorId(id);
    }

    public List<Book> getAllBooks() {
        return bookRepository.getBooks();
    }

    public Book addBook(Book book) {
        return bookRepository.save(book);
    }

    public Book getBookById(Integer id) {

        return bookRepository.getById(id);
    }

//    public void delete(Integer id) {
//        bookRepository.deleteById(id);
//    }
}
