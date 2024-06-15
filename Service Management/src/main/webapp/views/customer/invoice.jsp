<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.servicemanagement.model.Invoice" %>
<%@ page import="java.util.List" %>
<%@ page import="com.servicemanagement.dao.InvoiceDao" %>
<%@ page import="com.servicemanagement.util.DBUtil" %>
<%
    // Fetch invoice data from the database
    InvoiceDao invoiceDao = new InvoiceDao();
    List<Invoice> invoices = invoiceDao.getAllInvoices();
%>
<%!
    // Function to calculate total amount
     double calculateTotal(List<Invoice> invoices) {
        double total = 0;
        for (Invoice invoice : invoices) {
            total += invoice.getAmount();
        }
        return total;
    }
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Invoice</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Custom styles -->
    <style>
        body {
            background-color: #f8f9fa;
            padding-top: 40px;
        }
        .container {
            max-width: 500px;
            margin: auto;
        }
        .card {
            border: none;
            border-radius: 10px;
            box-shadow: 0px 0px 15px 0px rgba(0,0,0,0.1);
        }
        .card-header {
            background-color: #007bff;
            color: #fff;
            border-radius: 10px 10px 0 0;
        }
        .table {
            margin-bottom: 0;
        }
        .btn-primary {
            border-radius: 5px;
            padding: 10px 20px;
            font-weight: bold;
        }
        .btn-primary:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>

<div class="container">
    <div class="card">
        <div class="card-header text-center">
            <h3>Invoice</h3>
        </div>
        <div class="card-body">
            <table class="table table-striped">
                <thead>
                    <tr>
                        <th>Item</th>
                        <th>Amount</th>
                    </tr>
                </thead>
                <tbody>
                    <% for (Invoice invoice : invoices) { %>
                        <tr>
                            <td><%= invoice.getCustomerId() %></td>
                            <td>$<%= invoice.getAmount() %></td>
                        </tr>
                    <% } %>
                </tbody>
            </table>
            <div class="text-end">
                <h5>Total: $<%= calculateTotal(invoices) %></h5>
            </div>
        </div>
    </div>
</div>

<!-- Bootstrap Bundle JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>

