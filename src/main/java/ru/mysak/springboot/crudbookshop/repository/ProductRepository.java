package ru.mysak.springboot.crudbookshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.mysak.springboot.crudbookshop.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    Product getProductById(Integer id);
}
