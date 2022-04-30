package ru.mysak.springboot.crudbookshop.service;

import org.springframework.stereotype.Service;
import ru.mysak.springboot.crudbookshop.entity.Author;
import ru.mysak.springboot.crudbookshop.repository.AuthorRepository;

import java.util.List;

@Service
public class AuthorService {

    private final AuthorRepository repository;

    public AuthorService(AuthorRepository authorRepository) {
        this.repository = authorRepository;
    }

    public Author addAuthor(Author author) {
        return repository.save(author);
    }

    public List<Author> getAllAuthors() {
        return repository.findAll();
    }

    public Author getAuthorById(Integer id) {
        return repository.getById(id);
    }

    public Boolean deleteAuthor(Integer id) {
        repository.delete(repository.getById(id));

        return true;
    }
}
