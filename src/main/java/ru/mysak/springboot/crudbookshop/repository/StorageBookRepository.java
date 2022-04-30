package ru.mysak.springboot.crudbookshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.mysak.springboot.crudbookshop.entity.StorageBook;

import java.util.List;

@Repository
public interface StorageBookRepository extends JpaRepository<StorageBook, Integer> {

    @Query(value = "select * from book_shop.storage_book", nativeQuery = true)
    List<StorageBook> getAllStorage();

    @Query(value = "select * from book_shop.storage_book where book_id = ?1", nativeQuery = true)
    StorageBook getStorageById(Integer id);

    @Query(value = "update book_shop.storage_book set amount = amount + 1 where book_id = ?1", nativeQuery = true)
    StorageBook addBook(StorageBook book);

    @Query(value = "update book_shop.storage_book set amount = amount - 1 where book_id = ?1", nativeQuery = true)
    StorageBook deleteBook(StorageBook book);

}
