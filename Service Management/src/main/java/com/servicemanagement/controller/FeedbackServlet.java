package com.servicemanagement.controller;

import java.io.IOException;

import com.servicemanagement.dao.FeedbackDao;
import com.servicemanagement.model.Feedback;
import com.servicemanagement.model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;




public class FeedbackServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private FeedbackDao feedbackDao;

    @Override
    public void init() throws ServletException {
        super.init();
        feedbackDao = new FeedbackDao(); // Instantiate FeedbackDao
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        String action = request.getParameter("action");

        switch (action) {
            case "submit":
                submitFeedback(request, response);
                break;
            default:
                response.sendRedirect("login.jsp"); // Redirect to login page for invalid actions
        }
    }

    private void submitFeedback(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        if (user == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        String feedbackMessage = request.getParameter("message");
        // You may want to add more fields like feedback category, date, etc.

        // Create Feedback object
        Feedback feedback = new Feedback();
        feedback.setUserId(user.getId());
        feedback.setMessage(feedbackMessage);
        
        // Save feedback to database
        feedbackDao.addFeedback(feedback);
        
        // Redirect to a confirmation page or home page
        response.sendRedirect("confirmation.jsp");
    }
}
