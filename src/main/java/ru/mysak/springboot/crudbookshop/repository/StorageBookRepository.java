package ru.mysak.springboot.crudbookshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.mysak.springboot.crudbookshop.entity.StorageBook;

@Repository
public interface StorageBookRepository extends JpaRepository<StorageBook, Integer> {
}
