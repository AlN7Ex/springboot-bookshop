package ru.mysak.springboot.crudbookshop.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

/**
 * Книга содержит информацию:
 * о названии
 * идентификаторе автора
 * годе издания
 * количестве страниц
 * цене
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(schema = "book_shop")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer book_id;

    @Version
    public Long version;

    @Column(nullable = false)
    private String title;

    @ManyToOne
    @JoinColumn(name = "author_id")
    @ToString.Exclude
    private Author author_id;

    @OneToOne(mappedBy = "book", cascade = CascadeType.ALL)
    @ToString.Exclude
    private StorageBook storageBook;

    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<OrderDetails> orderDetails;

    @Column(nullable = false)
    private String publish_year;

    @Column(nullable = false)
    private Integer pages;

    @Column(nullable = false)
    private Integer price;
}
