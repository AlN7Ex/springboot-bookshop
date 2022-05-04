package ru.mysak.springboot.crudbookshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.mysak.springboot.crudbookshop.entity.Book;
import ru.mysak.springboot.crudbookshop.entity.Customer;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    @Query(value = "select * from book_shop.customer",nativeQuery = true)
    List<Customer> getCustomers();
}
