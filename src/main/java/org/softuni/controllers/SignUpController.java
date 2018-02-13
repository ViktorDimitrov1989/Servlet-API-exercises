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

@WebServlet("/signup")
public class SignUpController extends HttpServlet{

    private UserService userService;

    public SignUpController(){
        this.userService = new UserServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //NotificationManager.clearNotifications(req);

        req.getRequestDispatcher("templates/signup.jsp")
            .forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        NotificationManager.clearNotifications(req);

        String username = req.getParameter("username");
        String password = req.getParameter("password");

        try{
            LoginModel signedUser = this.userService.createUser(new LoginModel(username, password));

            req.getSession().setAttribute("info", "You are successfully registered.");

            resp.sendRedirect("signin");
        }catch (RequestException e){
            req.getSession().setAttribute("error", e.getMessage());
            resp.sendRedirect("signup");
        }


    }
}
