package org.softuni.service;

import org.softuni.model.bindingModel.AddBookModel;
import org.softuni.model.viewModel.ViewBookModel;

import java.util.Set;

public interface BookService {

    AddBookModel saveBook(AddBookModel addBookModel);

    Set<ViewBookModel> getAllBooks();

    ViewBookModel findBookByTitle(String title);

    ViewBookModel deleteBookByTitle(String title);

}
