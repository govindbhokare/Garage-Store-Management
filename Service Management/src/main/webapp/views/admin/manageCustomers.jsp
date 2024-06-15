<!DOCTYPE html>
<%@page import="com.servicemanagement.model.User"%>
<%@page import="java.util.*"%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Manage Customers</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        .action-btn {
            margin-right: 5px;
        }
    </style>
</head>
<body>

<div class="container mt-5">
    <h2 class="text-center mb-4">Manage Customers</h2>

    <!-- Display list of customers -->
    <div class="row">
        <div class="col-md-8 offset-md-2">
            <table class="table table-striped">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Username</th>
                        <th>Email</th>
                        <th>Actions</th>
                    </tr>
                </thead>
                <tbody>
                    <!-- Use JSTL forEach loop -->
                    <%
                        List<User> customers = (List<User>) request.getAttribute("customers");
                        for (User customer : customers) {
                    %>
                        <tr>
                            <td><%= customer.getId() %></td>
                            <td><%= customer.getUsername() %></td>
                            <td><%= customer.getEmail() %></td>
                            <td>
                                <button class="btn btn-primary btn-sm action-btn">Edit</button>
                                <button class="btn btn-danger btn-sm action-btn">Delete</button>
                            </td>
                        </tr>
                    <% } %>
                </tbody>
            </table>
        </div>
    </div>

    <!-- Add new customer form -->
    <div class="row mt-4">
        <div class="col-md-6 offset-md-3">
            <div class="card">
                <div class="card-header">
                    Add New Customer
                </div>
                <div class="card-body">
                    <form action="admin?action=addCustomer" method="POST">
                        <div class="mb-3">
                            <label for="username" class="form-label">Username</label>
                            <input type="text" class="form-control" id="username" name="username" required>
                        </div>
                        <div class="mb-3">
                            <label for="email" class="form-label">Email</label>
                            <input type="email" class="form-control" id="email" name="email" required>
                        </div>
                        <div class="mb-3">
                            <label for="password" class="form-label">Password</label>
                            <input type="password" class="form-control" id="password" name="password" required>
                        </div>
                        <button type="submit" class="btn btn-success">Add Customer</button>
                    </form>
                </div>
            </div>
        </div>
    </div>

</div>

<!-- Bootstrap Bundle JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
