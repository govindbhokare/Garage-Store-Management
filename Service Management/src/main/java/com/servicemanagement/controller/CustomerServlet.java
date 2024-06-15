package com.servicemanagement.controller;

import java.io.IOException;

import com.servicemanagement.dao.ServiceRequestDao;
import com.servicemanagement.dao.UserDao;
import com.servicemanagement.model.ServiceRequest;
import com.servicemanagement.model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@WebServlet("/customer")
public class CustomerServlet extends HttpServlet {
    private UserDao userDao;
    private ServiceRequestDao serviceRequestDao;

    @Override
    public void init() throws ServletException {
        super.init();
        userDao = new UserDao(); // Instantiate UserDao
        serviceRequestDao=new ServiceRequestDao();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        String action = request.getParameter("action");

        switch (action) {
            case "signup":
                signup(request, response);
                break;
            case "login":
                login(request, response);
                break;
            case "createRequest":
                createRequest(request, response);
                break;
            // Handle other actions like deleteRequest, viewProfile, etc.
        }
    }

    private void signup(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        // Extract user data from request parameters
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String role = request.getParameter("role");
        // Other user details...

        // Create a new User object
        User user = new User(username, password, email,role);
        // Save user to database
        userDao.addUser(user);
        // Redirect to login page
        response.sendRedirect("views/customer/login.jsp");
    }

    private void login(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Extract login credentials from request parameters
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Validate login credentials
        User user = userDao.getUserByUsername(username);

        if (user != null && user.getPassword().equals(password)) {
            // Login successful, store user object in session
            HttpSession session = request.getSession();
            session.setAttribute("user", user);

            // Redirect to appropriate dashboard or profile page based on user role
            if (user.getRole().equals("admin")) {
                response.sendRedirect("views/admin/dashboard.jsp");
            } else if (user.getRole().equals("customer")) {
                response.sendRedirect("views/customer/profile.jsp");
            } else if (user.getRole().equals("mechanic")) {
                response.sendRedirect("views/mechanic/dashboard.jsp");
            } else {
                // Handle other roles or redirect to a default page
                response.sendRedirect("index.jsp"); // Example default redirect
            }
        } else {
            // Login failed, redirect back to login page with error message
            request.setAttribute("error", "Invalid username or password");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }


    private void createRequest(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        // Extract service request details from request parameters
        String vehicleNumber = request.getParameter("vehicleNumber");
        String model = request.getParameter("model");
        String problemDescription = request.getParameter("problemDescription");
        // Other request details...

        // Create a new ServiceRequest object
        ServiceRequest serviceRequest = new ServiceRequest(vehicleNumber, model, problemDescription);
        String status = "Pending";
        serviceRequest.setStatus(status);
        // Save service request to database
        serviceRequestDao.addServiceRequest(serviceRequest);
        // Redirect to a confirmation page or dashboard
        response.sendRedirect("requestConfirmation.jsp");
    }

}
