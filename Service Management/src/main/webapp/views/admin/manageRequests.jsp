<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.servicemanagement.model.ServiceRequest" %>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Manage Service Requests</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Custom styles -->
    <style>
        /* Add custom CSS styles here */
    </style>
</head>
<body>

<div class="container">
    <h2 class="my-4">Manage Service Requests</h2>
    <%-- Check if there are any service requests available --%>
    <% if (request.getAttribute("serviceRequests") != null) { %>
        <table class="table table-striped">
            <thead>
                <tr>
                    <th>Request ID</th>
                    <th>Vehicle Number</th>
                    <th>Model</th>
                    <th>Problem Description</th>
                    <th>Status</th>
                    <th>Action</th>
                </tr>
            </thead>
            <tbody>
                <%-- Iterate over each service request and display its details --%>
                <% for (ServiceRequest request1 : (List<ServiceRequest>) request.getAttribute("serviceRequests")) { %>
                    <tr>
                        <td><%= request1.getId() %></td>
                        <td><%= request1.getVehicleNumber() %></td>
                        <td><%= request1.getModel() %></td>
                        <td><%= request1.getProblemDescription() %></td>
                        <td><%= request1.getStatus() %></td>
                        <td>
                            <%-- Add action buttons here, e.g., view, approve, delete --%>
                            <a href="viewRequest.jsp?id=<%= request1.getId() %>" class="btn btn-primary btn-sm">View</a>
                            <a href="approveRequest?id=<%= request1.getId() %>" class="btn btn-success btn-sm">Approve</a>
                            <a href="deleteRequest?id=<%= request1.getId() %>" class="btn btn-danger btn-sm">Delete</a>
                        </td>
                    </tr>
                <% } %>
            </tbody>
        </table>
    <% } else { %>
        <p>No service requests found.</p>
    <% } %>
</div>

<!-- Bootstrap Bundle JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
