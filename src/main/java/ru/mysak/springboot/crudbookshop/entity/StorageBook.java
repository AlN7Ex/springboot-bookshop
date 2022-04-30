package ru.mysak.springboot.crudbookshop.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * Книжный склад хранит информацию об остатках книг
 * по идентификатору книги (ИД у книг должны быть уникальными)
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(schema = "book_shop")
public class StorageBook {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer storage_book_id;

    @OneToOne
    @JoinColumn(name = "book_id", nullable = false)
    private Book book;

    @Column
    private int amount = 0;
}
