package ru.mysak.springboot.crudbookshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.mysak.springboot.crudbookshop.entity.Author;

public interface AuthorRepository extends JpaRepository<Author, Integer> {


}
