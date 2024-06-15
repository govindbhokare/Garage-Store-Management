<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="com.servicemanagement.model.ServiceRequest"%>
<%@page import="java.util.*"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Manage Invoices</title>
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
    <h2 class="text-center mb-4">Manage Invoices</h2>

    <!-- Display list of invoices -->
    <div class="row">
        <div class="col-md-8 offset-md-2">
            <table class="table table-striped">
                <thead>
                    <tr>
                        <th>Invoice ID</th>
                        <th>Customer Name</th>
                        <th>Total Amount</th>
                        <th>Actions</th>
                    </tr>
                </thead>
                <tbody>
                    <!-- Iterate over invoices using scriptlet -->
                    <% 
                    List<ServiceRequest> invoices = (List<ServiceRequest>) request.getAttribute("invoices");
                    for (ServiceRequest invoice : invoices) { 
                    %>
                        <tr>
                            <td><%= invoice.getId() %></td>
                            <td><%= invoice.getModel() %></td>
                            <td><%= invoice.getVehicleNumber() %></td>
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

    <!-- Add new invoice form -->
    <div class="row mt-4">
        <div class="col-md-6 offset-md-3">
            <div class="card">
                <div class="card-header">
                    Add New Invoice
                </div>
                <div class="card-body">
                    <form action="admin?action=addInvoice" method="POST">
                        <div class="mb-3">
                            <label for="invoiceId" class="form-label">Invoice ID</label>
                            <input type="text" class="form-control" id="invoiceId" name="invoiceId" required>
                        </div>
                        <div class="mb-3">
                            <label for="customerName" class="form-label">Customer Name</label>
                            <input type="text" class="form-control" id="customerName" name="customerName" required>
                        </div>
                        <div class="mb-3">
                            <label for="totalAmount" class="form-label">Total Amount</label>
                            <input type="text" class="form-control" id="totalAmount" name="totalAmount" required>
                        </div>
                        <button type="submit" class="btn btn-success">Add Invoice</button>
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
