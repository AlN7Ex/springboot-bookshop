package ru.mysak.springboot.crudbookshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.mysak.springboot.crudbookshop.entity.Orders;

@Repository
public interface OrdersRepository extends JpaRepository<Orders, Integer> {
}
