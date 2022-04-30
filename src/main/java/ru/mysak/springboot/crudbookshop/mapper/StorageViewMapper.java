package ru.mysak.springboot.crudbookshop.mapper;

import org.springframework.stereotype.Component;
import ru.mysak.springboot.crudbookshop.entity.StorageBook;
import ru.mysak.springboot.crudbookshop.view.BookInView;
import ru.mysak.springboot.crudbookshop.view.StorageView;

@Component
public class StorageViewMapper {

    public StorageView mapToView(StorageBook storage) {
        StorageView view = new StorageView();
        view.setAmount(storage.getAmount());
        view.setBook(new BookInView(
                storage.getBook().getBook_id(),
                storage.getBook().getTitle(),
                storage.getBook().getPublish_year(),
                storage.getBook().getPages(),
                storage.getBook().getPrice()
        ));

        return view;
    }
}
