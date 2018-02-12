package org.softuni.repositories;
import org.softuni.entity.Book;
import java.util.Map;

public interface BookRepository {

    Book saveBook(Book book);

    Map<String, Book> getAllBooks();

    Book deleteBookByTitle(String title);

    Book findBookByTitle(String title);
}
