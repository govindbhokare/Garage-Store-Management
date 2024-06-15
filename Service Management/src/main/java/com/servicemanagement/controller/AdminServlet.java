package com.servicemanagement.controller;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import com.servicemanagement.dao.ServiceRequestDao;
import com.servicemanagement.dao.UserDao;
import com.servicemanagement.model.ServiceRequest;
import com.servicemanagement.model.User;


public class AdminServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private UserDao userDao;
    private ServiceRequestDao serviceRequestDao;

    @Override
    public void init() throws ServletException {
        super.init();
        userDao = new UserDao(); // Instantiate UserDao
        serviceRequestDao = new ServiceRequestDao(); // Instantiate ServiceRequestDao
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");

        switch (action) {
            case "login":
                login(request, response);
                break;
            case "manageCustomers":
                manageCustomers(request, response);
                break;
            case "manageInvoices":
                manageInvoices(request, response);
                break;
            case "manageRequests":
                manageRequests(request, response);
                break;
            case "viewFeedback":
                viewFeedback(request, response);
                break;
            default:
                response.sendRedirect("views/admin/login.jsp"); // Redirect to login page for invalid actions
        }
    }

    private void login(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        User user = userDao.getUserByUsername(username);

        if (user != null && user.getPassword().equals(password) && user.getRole().equals("admin")) {
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            response.sendRedirect("views/admin/dashboard.jsp"); // Redirect to admin dashboard
        } else {
            request.setAttribute("error", "Invalid username or password");
            request.getRequestDispatcher("views/admin/login.jsp").forward(request, response);
        }
    }

    private void manageCustomers(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        if (user == null || !user.getRole().equals("admin")) {
            response.sendRedirect("views/admin/login.jsp");
            return;
        }

        // Implement logic to manage customers (add/delete/update)
        // Example: request.getRequestDispatcher("manageCustomers.jsp").forward(request, response);
        // Here, you can add logic to interact with your UserDao to manage customers
        List<User> customers = userDao.getAllUsers(); // Fetch all users (assuming customers)

        request.setAttribute("customers", customers);
        
        request.getRequestDispatcher("views/admin/manageCustomers.jsp").forward(request, response);
    }

    private void manageInvoices(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        if (user == null || !user.getRole().equals("admin")) {
            response.sendRedirect("views/admin/login.jsp");
            return;
        }

        // Implement logic to manage invoices (view/create/delete)
        // Example: request.getRequestDispatcher("manageInvoices.jsp").forward(request, response);
        // Placeholder logic for managing invoices
        List<ServiceRequest> invoices = serviceRequestDao.getAllServiceRequests(); // Fetch all service requests (assuming invoices)

        request.setAttribute("invoices", invoices);
        request.getRequestDispatcher("views/admin/manageInvoices.jsp").forward(request, response);
    }

    private void manageRequests(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        if (user == null || !user.getRole().equals("admin")) {
            response.sendRedirect("views/admin/login.jsp");
            return;
        }

        // Retrieve the list of service requests from the database
        List<ServiceRequest> serviceRequests = serviceRequestDao.getAllServiceRequests();

        // Set the list of service requests as an attribute in the request object
        request.setAttribute("serviceRequests", serviceRequests);

        // Forward the request to the JSP page for displaying service requests
        request.getRequestDispatcher("views/admin/manageRequests.jsp").forward(request, response);
    }

    private void viewFeedback(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        if (user == null || !user.getRole().equals("admin")) {
            response.sendRedirect("views/admin/login.jsp");
            return;
        }	

        // Implement logic to view feedback provided by customers and mechanics
        // Example: request.getRequestDispatcher("viewFeedback.jsp").forward(request, response);
        // Placeholder logic for viewing feedback
        request.getRequestDispatcher("views/admin/viewFeedback.jsp").forward(request, response);
    }
}
