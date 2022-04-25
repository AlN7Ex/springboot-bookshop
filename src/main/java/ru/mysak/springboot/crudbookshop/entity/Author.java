package ru.mysak.springboot.crudbookshop.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

/**
 * Автор - ФИО, ид
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(schema = "book_shop")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer author_id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String surname;

    @OneToMany(mappedBy = "author_id", cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<Book> books;
}
