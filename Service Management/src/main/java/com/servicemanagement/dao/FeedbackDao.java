package com.servicemanagement.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.servicemanagement.model.Feedback;
import com.servicemanagement.util.DBUtil;


public class FeedbackDao {
    private Connection connection;

    // Constructor to initialize connection
    public FeedbackDao() {
        connection = DBUtil.getConnection();
    }

    // Method to add a new feedback to the database
    public void addFeedback(Feedback feedback) {
        try {
            String query = "INSERT INTO feedbacks (user_id, message) VALUES (?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, feedback.getUserId());
            preparedStatement.setString(2, feedback.getMessage());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to retrieve all feedbacks from the database
    public List<Feedback> getAllFeedbacks() {
        List<Feedback> feedbacks = new ArrayList<>();
        try {
            String query = "SELECT * FROM feedbacks";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Feedback feedback = new Feedback();
                feedback.setId(resultSet.getInt("id"));
                feedback.setUserId(resultSet.getInt("user_id"));
                feedback.setMessage(resultSet.getString("message"));
                // Add more fields if needed
                feedbacks.add(feedback);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return feedbacks;
    }

    // Method to retrieve a feedback by ID
    public Feedback getFeedbackById(int feedbackId) {
        Feedback feedback = null;
        try {
            String query = "SELECT * FROM feedbacks WHERE id=?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, feedbackId);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                feedback = new Feedback();
                feedback.setId(resultSet.getInt("id"));
                feedback.setUserId(resultSet.getInt("user_id"));
                feedback.setMessage(resultSet.getString("message"));
                // Add more fields if needed
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return feedback;
    }

    // Method to update an existing feedback in the database
    public void updateFeedback(Feedback feedback) {
        try {
            String query = "UPDATE feedbacks SET user_id=?, message=? WHERE id=?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, feedback.getUserId());
            preparedStatement.setString(2, feedback.getMessage());
            preparedStatement.setInt(3, feedback.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to delete a feedback from the database
    public void deleteFeedback(int feedbackId) {
        try {
            String query = "DELETE FROM feedbacks WHERE id=?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, feedbackId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
