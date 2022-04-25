package ru.mysak.springboot.crudbookshop.mapper;

import org.springframework.stereotype.Component;
import ru.mysak.springboot.crudbookshop.entity.Author;
import ru.mysak.springboot.crudbookshop.entity.Book;
import ru.mysak.springboot.crudbookshop.view.AuthorView;
import ru.mysak.springboot.crudbookshop.view.BookView;

@Component
public class BookViewMapper {

    public BookView mapToView(Book book) {
        BookView bookView = new BookView();
        bookView.setBook_id(book.getBook_id());
        bookView.setTitle(book.getTitle());
        bookView.setPublish_year(book.getPublish_year());
        bookView.setPages(book.getPages());
        bookView.setPrice(book.getPrice());
        bookView.setAuthor(new AuthorView(
                book.getAuthor_id().getAuthor_id(),
                book.getAuthor_id().getName(),
                book.getAuthor_id().getSurname()));
//        bookView.setStorageBook(book.getStorageBook());
//        bookView.setOrderDetails(book.getOrderDetails());

        return bookView;
    }

//    public Book mapFromView(BookView bookView) {
//        Book book = new Book();
//        book.setBook_id(bookView.getBook_id());
//        book.setTitle(bookView.getTitle());
//        book.setPublish_year(bookView.getPublish_year());
//        book.setPages(bookView.getPages());
//        book.setPrice(bookView.getPrice());
//        book.setAuthor_id(new Author());

//        book.setAuthor_id(bookView.getAuthor_id());
//        book.setStorageBook(bookView.getStorageBook());
//        book.setOrderDetails(bookView.getOrderDetails());

//        return book;
}
