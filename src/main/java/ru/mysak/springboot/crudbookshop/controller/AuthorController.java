package ru.mysak.springboot.crudbookshop.controller;

import org.springframework.web.bind.annotation.*;
import ru.mysak.springboot.crudbookshop.entity.Author;
import ru.mysak.springboot.crudbookshop.mapper.AuthorViewMapper;
import ru.mysak.springboot.crudbookshop.service.AuthorService;
import ru.mysak.springboot.crudbookshop.view.AuthorView;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class AuthorController {

    private final AuthorService service;
    private final AuthorViewMapper mapper;

    public AuthorController(AuthorService authorService, AuthorViewMapper authorViewMapper) {
        this.service = authorService;
        this.mapper = authorViewMapper;
    }

    @GetMapping("/authors")
    public List<AuthorView> readAll() {
        return service.getAllAuthors()
                .stream()
                .map(mapper::mapToView)
                .collect(Collectors.toList());
    }

    @PostMapping("/authors")
    public AuthorView create(@RequestBody Author author) {

        return mapper.mapToView(service.addAuthor(author));
    }

    @GetMapping("/authors/{id}")
    public AuthorView read(@PathVariable Integer id) {
        return mapper.mapToView(service.getAuthorById(id));
    }

    @DeleteMapping("/authors/{id}")
    public Boolean delete(@PathVariable Integer id) {
        return service.deleteAuthor(id);
    }
}
