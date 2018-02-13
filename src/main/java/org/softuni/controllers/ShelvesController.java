package org.softuni.controllers;

import org.softuni.model.viewModel.ViewBookModel;
import org.softuni.service.BookService;
import org.softuni.serviceImpl.BookServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Set;

@WebServlet("/shelves")
public class ShelvesController extends HttpServlet{

    private BookService bookService;

    public ShelvesController(){
        this.bookService = new BookServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Set<ViewBookModel> books = this.bookService.getAllBooks();

        req.setAttribute("books", books);

        req.getRequestDispatcher("templates/shelves.jsp")
        .forward(req,resp);
    }
}
