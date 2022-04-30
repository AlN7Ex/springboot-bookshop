package ru.mysak.springboot.crudbookshop.service;

import org.springframework.stereotype.Service;
import ru.mysak.springboot.crudbookshop.entity.StorageBook;
import ru.mysak.springboot.crudbookshop.repository.StorageBookRepository;

import java.util.List;

@Service
public class StorageBookService {

    private final StorageBookRepository storageBookRepository;

    public StorageBookService(StorageBookRepository storageBookRepository) {
        this.storageBookRepository = storageBookRepository;
    }

    public List<StorageBook> getAllStorage() {
        return storageBookRepository.getAllStorage();
    }

    public StorageBook getStorageById(Integer id) {
        return storageBookRepository.getStorageById(id);
    }

    public Boolean addStorageBook(StorageBook book) {
        storageBookRepository.save(book);

        return true;
    }
//    public Boolean deleteStorageBook(Integer id) {
//        return storageBookRepository.delete(storageBookRepository.);
//    }
}
