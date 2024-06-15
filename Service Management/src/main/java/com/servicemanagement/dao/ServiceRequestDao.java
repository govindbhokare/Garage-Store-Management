package com.servicemanagement.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.servicemanagement.model.ServiceRequest;
import com.servicemanagement.util.DBUtil;

public class ServiceRequestDao {
    private Connection connection;

    // Constructor to initialize connection
    public ServiceRequestDao() {
        connection = DBUtil.getConnection();
    }

    // Method to add a new service request to the database
    public void addServiceRequest(ServiceRequest request) {
        try {
            String query = "INSERT INTO service_requests (vehicle_number, model, problem_description, status) VALUES (?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, request.getVehicleNumber());
            preparedStatement.setString(2, request.getModel());
            preparedStatement.setString(3, request.getProblemDescription());
            preparedStatement.setString(4, request.getStatus());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to retrieve all service requests from the database
    public List<ServiceRequest> getAllServiceRequests() {
        List<ServiceRequest> requests = new ArrayList<>();
        try {
            String query = "SELECT * FROM service_requests";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                ServiceRequest request = new ServiceRequest();
                request.setId(resultSet.getInt("id"));
                request.setVehicleNumber(resultSet.getString("vehicle_number"));
                request.setModel(resultSet.getString("model"));
                request.setProblemDescription(resultSet.getString("problem_description"));
                request.setStatus(resultSet.getString("status"));
                requests.add(request);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return requests;
    }

    // Method to retrieve a service request by ID
    public ServiceRequest getServiceRequestById(int requestId) {
        ServiceRequest request = null;
        try {
            String query = "SELECT * FROM service_requests WHERE id=?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, requestId);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                request = new ServiceRequest();
                request.setId(resultSet.getInt("id"));
                request.setVehicleNumber(resultSet.getString("vehicle_number"));
                request.setModel(resultSet.getString("model"));
                request.setProblemDescription(resultSet.getString("problem_description"));
                request.setStatus(resultSet.getString("status"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return request;
    }

    // Method to update an existing service request in the database
    public void updateServiceRequest(ServiceRequest request) {
        try {
            String query = "UPDATE service_requests SET vehicle_number=?, model=?, problem_description=?, status=? WHERE id=?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, request.getVehicleNumber());
            preparedStatement.setString(2, request.getModel());
            preparedStatement.setString(3, request.getProblemDescription());
            preparedStatement.setString(4, request.getStatus());
            preparedStatement.setInt(5, request.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to delete a service request from the database
    public void deleteServiceRequest(int requestId) {
        try {
            String query = "DELETE FROM service_requests WHERE id=?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, requestId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
 // Method to retrieve assigned vehicles for a mechanic
    public List<ServiceRequest> getAssignedVehiclesForMechanic(int mechanicId) {
        List<ServiceRequest> assignedVehicles = new ArrayList<>();
        try {
            String query = "SELECT * FROM service_requests WHERE mechanic_id=?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, mechanicId);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                ServiceRequest request = new ServiceRequest();
                request.setId(resultSet.getInt("id"));
                request.setVehicleNumber(resultSet.getString("vehicle_number"));
                request.setModel(resultSet.getString("model"));
                request.setProblemDescription(resultSet.getString("problem_description"));
                request.setStatus(resultSet.getString("status"));
                assignedVehicles.add(request);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return assignedVehicles;
    }

}
