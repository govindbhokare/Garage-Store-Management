package com.servicemanagement.controller;

import java.io.IOException;
import java.util.List;

import com.servicemanagement.dao.ServiceRequestDao;
import com.servicemanagement.dao.UserDao;
import com.servicemanagement.model.ServiceRequest;
import com.servicemanagement.model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;




public class MechanicServlet extends HttpServlet {
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
        String action = request.getParameter("action");

        switch (action) {
            case "login":
                login(request, response);
                break;
            case "viewAssignedVehicles":
                viewAssignedVehicles(request, response);
                break;
            case "generateInvoice":
                generateInvoice(request, response);
                break;
            default:
                response.sendRedirect("login.jsp"); // Redirect to login page for invalid actions
        }
    }

    private void login(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        User user = userDao.getUserByUsername(username);

        if (user != null && user.getPassword().equals(password) && user.getRole().equals("mechanic")) {
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            response.sendRedirect("assignedVehicles.jsp"); // Redirect to mechanic dashboard
        } else {
            request.setAttribute("error", "Invalid username or password");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }

    private void viewAssignedVehicles(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        if (user == null || !user.getRole().equals("mechanic")) {
            response.sendRedirect("login.jsp");
            return;
        }

        List<ServiceRequest> assignedVehicles = serviceRequestDao.getAssignedVehiclesForMechanic(user.getId());
        request.setAttribute("assignedVehicles", assignedVehicles);
        request.getRequestDispatcher("assignedVehicles.jsp").forward(request, response);
    }

    private void generateInvoice(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        if (user == null || !user.getRole().equals("mechanic")) {
            response.sendRedirect("login.jsp");
            return;
        }

        String[] selectedRequests = request.getParameterValues("selectedRequests");

        if (selectedRequests == null || selectedRequests.length == 0) {
            request.setAttribute("error", "No service requests selected for invoice generation");
            request.getRequestDispatcher("assignedVehicles.jsp").forward(request, response);
            return;
        }

        // Generate invoice based on the selected service requests
        // Example: serviceRequestDao.generateInvoice(selectedRequests);
        response.sendRedirect("invoiceConfirmation.jsp");
    }
}
