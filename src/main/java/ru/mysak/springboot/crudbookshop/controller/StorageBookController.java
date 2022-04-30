package ru.mysak.springboot.crudbookshop.controller;

import org.springframework.web.bind.annotation.*;
import ru.mysak.springboot.crudbookshop.entity.StorageBook;
import ru.mysak.springboot.crudbookshop.mapper.StorageViewMapper;
import ru.mysak.springboot.crudbookshop.service.StorageBookService;
import ru.mysak.springboot.crudbookshop.view.StorageView;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class StorageBookController {

    private final StorageBookService storageBookService;
    private final StorageViewMapper storageViewMapper;

    public StorageBookController(StorageBookService storageBookService, StorageViewMapper storageViewMapper) {
        this.storageBookService = storageBookService;
        this.storageViewMapper = storageViewMapper;
    }

    @GetMapping("/storage")
    public List<StorageView> readAll() {

        return storageBookService.getAllStorage()
                .stream()
                .map(storageViewMapper::mapToView)
                .collect(Collectors.toList());
    }

    @GetMapping("/storage/{id}")
    public StorageView read(@PathVariable Integer id) {
        return storageViewMapper.mapToView(storageBookService.getStorageById(id));
    }

//    @PatchMapping("/storage/{id}")
//    public StorageView update(@PathVariable Integer id) {
//        storageBookService.addBook(id);
//    }

    @PostMapping("/storage")
    public StorageView add(@RequestBody StorageBook storageBook) {
        Integer book_id = storageBook.getBook().getBook_id();
        if (storageBookService.getStorageById(book_id) != null) {
//            storageBookService.addBook
        }
    }
}
