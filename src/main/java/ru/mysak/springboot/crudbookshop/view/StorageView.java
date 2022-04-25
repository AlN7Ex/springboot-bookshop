package ru.mysak.springboot.crudbookshop.view;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.mysak.springboot.crudbookshop.entity.Book;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StorageView {

    private Integer book_id;

    private int amount;
}
