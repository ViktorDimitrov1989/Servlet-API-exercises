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
import java.net.URLDecoder;

@WebServlet("/shelves/edit/*")
public class EditBookController extends HttpServlet{

    //private BookService bookService;

    public EditBookController(){
        //this.bookService = new BookServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.getRequestDispatcher("templates/edit-book.jsp")
                .forward(req,resp);

        /*String tokens[] = req.getRequestURI().split("/");
        String title = URLDecoder.decode(tokens[4], "UTF8");

        try{
            ViewBookModel viewBookModel = this.bookService.findBookByTitle(title);

            req.getSession().setAttribute("book", viewBookModel);

            req.getRequestDispatcher("templates/edit-book.jsp")
                    .forward(req,resp);
        }catch (RuntimeException e){
            resp.sendRedirect("shelves");
            e.printStackTrace();
        }*/

    }




}
