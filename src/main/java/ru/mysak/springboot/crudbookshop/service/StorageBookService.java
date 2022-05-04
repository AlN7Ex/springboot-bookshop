package ru.mysak.springboot.crudbookshop.service;

import org.springframework.stereotype.Service;
import ru.mysak.springboot.crudbookshop.entity.StorageBook;
import ru.mysak.springboot.crudbookshop.repository.StorageBookRepository;

import java.util.List;

@Service
public class StorageBookService {

    private final StorageBookRepository repository;

    public StorageBookService(StorageBookRepository storageBookRepository) {
        this.repository = storageBookRepository;
    }

    public List<StorageBook> getAllStorage() {
        return repository.getAllStorage();
    }

    public StorageBook getBookByIdInStorage(Integer id) {
        return repository.getById(id);
    }

    public Boolean addBookInStorage(StorageBook book) {
        repository.save(book);

        return true;
    }

    public Boolean deleteBookInStorage(Integer id) {
        repository.delete(repository.getById(id));

        return true;
    }
//    public Boolean deleteStorageBook(Integer id) {
//        return storageBookRepository.delete(storageBookRepository.);
//    }
}
