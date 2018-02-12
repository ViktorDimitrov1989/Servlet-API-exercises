package org.softuni.serviceImpl;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.softuni.entity.Book;
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

    private BookRepository bookRepository;
    private ModelMapper mapper;

    public BookServiceImpl(){
        this.bookRepository = BookRepositoryImpl.getInstance();
        this.mapper = new ModelMapper();
    }

    @Override
    public AddBookModel saveBook(AddBookModel addBookModel) {
        Book savedBook = this.bookRepository.saveBook(this.mapper.map(addBookModel, Book.class));

        if(this.bookRepository.findBookByTitle(addBookModel.getTitle()) != null){
            //handle error - book already exists
        }

        return this.mapper.map(savedBook, AddBookModel.class);
    }

    @Override
    public Set<ViewBookModel> getAllBooks() {
        Set<Book> resBooks = new HashSet<>();

        resBooks.addAll(this.bookRepository.getAllBooks().values());

        Type listType = new TypeToken<Set<ViewBookModel>>() {}.getType();

        return Collections.unmodifiableSet(this.mapper.map(resBooks, listType));
    }

    @Override
    public ViewBookModel findBookByTitle(String title) {

        if(this.bookRepository.findBookByTitle(title) == null){
            //handle error
        }

        return this.mapper.map(this.bookRepository.findBookByTitle(title), ViewBookModel.class);
    }

    @Override
    public ViewBookModel deleteBookByTitle(String title) {

        if(this.bookRepository.findBookByTitle(title) == null){
            //handle error
        }

        return this.mapper.map(this.bookRepository.deleteBookByTitle(title), ViewBookModel.class);
    }
}
