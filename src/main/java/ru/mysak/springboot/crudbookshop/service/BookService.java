package ru.mysak.springboot.crudbookshop.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.mysak.springboot.crudbookshop.entity.Book;
import ru.mysak.springboot.crudbookshop.repository.BookRepository;
import ru.mysak.springboot.crudbookshop.view.BookView;

import javax.persistence.LockModeType;
import javax.persistence.OptimisticLockException;
import java.util.List;

@Slf4j
@Service
public class BookService {

    private final BookRepository repository;

    public BookService(BookRepository bookRepository) {
        this.repository = bookRepository;
    }

    @Transactional
    public List<Book> getAllBooks() {
        return repository.getAllBooks();
    }

    @Transactional
    public Book addBook(Book book) {
        return repository.save(book);
    }

    @Transactional
    public Book getBook(Integer id) {

        return repository.getById(id);
    }

    @Transactional
    public Boolean deleteBook(Integer id) {
        repository.delete(repository.getById(id));

        return true;
    }

    @Transactional
    @Lock(value = LockModeType.READ)
    public Book updateBook(Book book) {
        try {
            return repository.save(book);
        }
        catch (OptimisticLockException exc) {
            log.warn("Optimistic lock exception for book {}", book.getBook_id());
            throw exc;
        }
    }
}
