package org.softuni.controllers;

import org.softuni.exception.RequestException;
import org.softuni.model.bindingModel.LoginModel;
import org.softuni.service.UserService;
import org.softuni.serviceImpl.UserServiceImpl;
import org.softuni.utils.NotificationManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/signin")
public class SignInController extends HttpServlet{

    private UserService userService;

    public SignInController(){
        this.userService = new UserServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //NotificationManager.clearNotifications(req);

        req.getRequestDispatcher("templates/signin.jsp")
                .forward(req,resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        NotificationManager.clearNotifications(req);

        String username = req.getParameter("username");
        String password = req.getParameter("password");

        try{
            LoginModel loggedUser = this.userService.findByUsernameAndPassword(username, password);

            req.getSession().setAttribute("info", "Login success!");

            req.getSession().setAttribute("username", username);

            req.getRequestDispatcher("templates/home.jsp")
                    .forward(req,resp);
        }catch (RequestException e){
            req.getSession().setAttribute("error", e.getMessage());
            resp.sendRedirect("signin");
        }

    }
}
