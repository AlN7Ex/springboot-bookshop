package ru.mysak.springboot.crudbookshop.mapper;

import org.springframework.stereotype.Component;
import ru.mysak.springboot.crudbookshop.entity.Book;
import ru.mysak.springboot.crudbookshop.view.AuthorInView;
import ru.mysak.springboot.crudbookshop.view.BookView;

@Component
public class BookViewMapper {

    public BookView mapToView(Book book) {
        BookView view = new BookView();
        view.setBook_id(book.getBook_id());
        view.setTitle(book.getTitle());
        view.setPublish_year(book.getPublish_year());
        view.setPages(book.getPages());
        view.setPrice(book.getPrice());
        view.setAuthor(new AuthorInView(
                book.getAuthor_id().getAuthor_id(),
                book.getAuthor_id().getName(),
                book.getAuthor_id().getSurname()
                ));
//        view.setStorage(new StorageView(
//                book.getStorageBook().getBook().getBook_id(),
//                book.getStorageBook().getAmount()
//        ));
//        view.setOrderDetails(book.getOrderDetails());

        return view;
    }

//    public Book mapFromView(BookView bookView) {
//        Book book = new Book();
//        book.setBook_id(bookView.getBook_id());
//        book.setTitle(bookView.getTitle());
//        book.setPublish_year(bookView.getPublish_year());
//        book.setPages(bookView.getPages());
//        book.setPrice(bookView.getPrice());
//        book.setAuthor_id(new Author());
//
//        book.setAuthor_id(bookView.getAuthor_id());
//        book.setStorageBook(bookView.getStorageBook());
//        book.setOrderDetails(bookView.getOrderDetails());
//
//        return book;
}
