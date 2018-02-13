package org.softuni.controllers;

import org.softuni.exception.RequestException;
import org.softuni.model.bindingModel.AddBookModel;
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

@WebServlet("/add")
public class AddBookController extends HttpServlet{

    private BookService bookService;

    public AddBookController(){
        this.bookService = new BookServiceImpl();
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("templates/add-book.jsp")
                .forward(req,resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String title = req.getParameter("title");
        String author = req.getParameter("author");
        int pagesCnt = Integer.parseInt(req.getParameter("pagescnt"));

        try{
            this.bookService.saveBook(new AddBookModel(title, author, pagesCnt));

            resp.sendRedirect("shelves");
        }catch (RequestException e){
            req.getSession().setAttribute("error", e.getMessage());
            resp.sendRedirect("add");
        }


    }
}
