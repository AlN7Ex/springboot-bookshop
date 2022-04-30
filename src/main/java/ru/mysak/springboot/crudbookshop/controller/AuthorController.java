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

    @PostMapping("/authors")
    public AuthorView create(@RequestBody Author newAuthor) {

        return authorViewMapper.mapToView(authorService.addAuthor(newAuthor));
    }

    @GetMapping("/authors/{id}")
    public AuthorView read(@PathVariable Integer id) {
        return authorViewMapper.mapToView(authorService.getAuthorById(id));
    }

    @DeleteMapping("/author/{id}")
    public Boolean delete(@PathVariable Integer id) {
        return authorService.deleteAuthor(id);
    }
}
