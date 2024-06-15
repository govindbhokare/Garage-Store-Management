package com.servicemanagement.controller;

import java.io.IOException;
import java.util.List;

import com.servicemanagement.dao.InvoiceDao;
import com.servicemanagement.model.Invoice;
import com.servicemanagement.model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;




public class InvoiceServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private InvoiceDao invoiceDao;

    @Override
    public void init() throws ServletException {
        super.init();
        invoiceDao = new InvoiceDao(); // Instantiate InvoiceDao
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        String action = request.getParameter("action");

        switch (action) {
            case "view":
                viewInvoices(request, response);
                break;
            case "delete":
                deleteInvoice(request, response);
                break;
            default:
                response.sendRedirect("login.jsp"); // Redirect to login page for invalid actions
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        String action = request.getParameter("action");

        switch (action) {
            case "create":
                createInvoice(request, response);
                break;
            case "update":
                updateInvoice(request, response);
                break;
            default:
                response.sendRedirect("login.jsp"); // Redirect to login page for invalid actions
        }
    }

    private void createInvoice(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        if (user == null || !user.getRole().equals("admin")) {
            response.sendRedirect("login.jsp");
            return;
        }

        // Retrieve invoice details from request parameters
        int  customerId =Integer.parseInt( request.getParameter("customerId"));
        double amount = Double.parseDouble(request.getParameter("amount"));
        
        // Create Invoice object
        Invoice invoice = new Invoice();
        invoice.setCustomerId(customerId);
        invoice.setAmount(amount);
        
        // Save invoice to database
        invoiceDao.addInvoice(invoice);
        
        // Redirect to a confirmation page or invoice management page
        response.sendRedirect("invoice?action=view");
    }

    private void viewInvoices(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        if (user == null || !user.getRole().equals("admin")) {
            response.sendRedirect("login.jsp");
            return;
        }

        // Retrieve invoices from database
        List<Invoice> invoices = invoiceDao.getAllInvoices();
        request.setAttribute("invoices", invoices);
        
        // Forward to view page
        request.getRequestDispatcher("viewInvoices.jsp").forward(request, response);
    }

    private void updateInvoice(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        if (user == null || !user.getRole().equals("admin")) {
            response.sendRedirect("login.jsp");
            return;
        }

        // Retrieve invoice details from request parameters
        int invoiceId = Integer.parseInt(request.getParameter("invoiceId"));
        int customerId = Integer.parseInt(request.getParameter("customerId"));
        double amount = Double.parseDouble(request.getParameter("amount"));
        
        // Create Invoice object
        Invoice invoice = new Invoice();
        invoice.setId(invoiceId);
        invoice.setCustomerId(customerId);
        invoice.setAmount(amount);
        
        // Update invoice in database
        invoiceDao.updateInvoice(invoice);
        
        // Redirect to a confirmation page or invoice management page
        response.sendRedirect("invoice?action=view");
    }

    private void deleteInvoice(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        if (user == null || !user.getRole().equals("admin")) {
            response.sendRedirect("login.jsp");
            return;
        }

        // Retrieve invoice ID from request parameters
        int invoiceId = Integer.parseInt(request.getParameter("invoiceId"));
        
        // Delete invoice from database
        invoiceDao.deleteInvoice(invoiceId);
        
        // Redirect to a confirmation page or invoice management page
        response.sendRedirect("invoice?action=view");
    }
}
