package com.servicemanagement.controller;


import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import com.servicemanagement.dao.UserDao;
import com.servicemanagement.model.User;


@WebServlet("/profile")
public class ProfileServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String username =  (String) session.getAttribute("username"); // Assuming userId is stored in session after login

        UserDao userDao = new UserDao();
        User user = userDao.getUserByUsername(username); // Assuming getUserById method fetches user details from the database
        System.out.println(user);
        System.out.println("hello");
        request.setAttribute("user", user); // Set user object as attribute in request
        request.getRequestDispatcher("views/customer/profile.jsp").forward(request, response);
    }
}
