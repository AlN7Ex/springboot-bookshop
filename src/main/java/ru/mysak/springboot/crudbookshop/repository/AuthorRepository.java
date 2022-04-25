package ru.mysak.springboot.crudbookshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.mysak.springboot.crudbookshop.entity.Author;

import java.util.List;

public interface AuthorRepository extends JpaRepository<Author, Integer> {
    @Query(value = "select * from book_shop.author",nativeQuery = true)
    List<Author> getAuthors();


}
