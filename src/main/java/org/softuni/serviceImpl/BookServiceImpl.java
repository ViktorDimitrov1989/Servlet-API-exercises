package org.softuni.serviceImpl;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.softuni.entity.Book;
import org.softuni.exception.RequestException;
import org.softuni.model.bindingModel.AddBookModel;
import org.softuni.model.viewModel.ViewBookModel;
import org.softuni.repositories.BookRepository;
import org.softuni.repositories.BookRepositoryImpl;
import org.softuni.service.BookService;

import java.lang.reflect.Type;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class BookServiceImpl implements BookService{

    private ModelMapper mapper;

    public BookServiceImpl(){
        this.mapper = new ModelMapper();
    }

    @Override
    public AddBookModel saveBook(AddBookModel addBookModel) {
        BookRepository bookRepository = BookRepositoryImpl.getInstance();


        if(bookRepository.findBookByTitle(addBookModel.getTitle()) != null){
            throw new RequestException("This book already exists");
        }

        Book savedBook = bookRepository.saveBook(this.mapper.map(addBookModel, Book.class));

        return this.mapper.map(savedBook, AddBookModel.class);
    }

    @Override
    public Set<ViewBookModel> getAllBooks() {
        BookRepository bookRepository = BookRepositoryImpl.getInstance();
        Set<Book> resBooks = new HashSet<>();

        resBooks.addAll(bookRepository.getAllBooks().values());

        Type listType = new TypeToken<Set<ViewBookModel>>() {}.getType();

        return Collections.unmodifiableSet(this.mapper.map(resBooks, listType));
    }

    @Override
    public ViewBookModel findBookByTitle(String title) {
        BookRepository bookRepository = BookRepositoryImpl.getInstance();

        if(bookRepository.findBookByTitle(title) == null){
            //handle error
        }

        return this.mapper.map(bookRepository.findBookByTitle(title), ViewBookModel.class);
    }

    @Override
    public ViewBookModel deleteBookByTitle(String title) {
        BookRepository bookRepository = BookRepositoryImpl.getInstance();

        if(bookRepository.findBookByTitle(title) == null){
            //handle error
        }

        return this.mapper.map(bookRepository.deleteBookByTitle(title), ViewBookModel.class);
    }
}
