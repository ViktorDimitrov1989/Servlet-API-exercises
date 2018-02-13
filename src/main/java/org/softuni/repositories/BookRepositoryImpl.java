package org.softuni.repositories;

import org.softuni.entity.Book;

import java.util.*;

public class BookRepositoryImpl implements BookRepository {

    private static BookRepository bookRepository;

    private Map<String, Book> books = new TreeMap<>();

    private BookRepositoryImpl(){
    }

    public static BookRepository getInstance(){
        if(bookRepository == null){
            bookRepository = new BookRepositoryImpl();
        }

        return bookRepository;
    }

    @Override
    public Book saveBook(Book book) {
        this.books.put(book.getTitle(), book);

        return book;
    }

    @Override
    public Map<String, Book> getAllBooks() {
        return Collections.unmodifiableMap(this.books);
    }

    @Override
    public Book deleteBookByTitle(String title) {
       return this.books.remove(title);
    }

    @Override
    public Book findBookByTitle(String title) {
        return this.books.get(title);
    }
}
