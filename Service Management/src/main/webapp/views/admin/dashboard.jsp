<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> --%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title><%=request.getContextPath() %>/AdminServlet Dashboard - Mechanic Store Manager</title>
  <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
  <link href="css/style.css" rel="stylesheet">
</head>
<body>
  
  <%@ include file="common/navbar.jsp" %>

  <div class="container mt-5">
    <div class="jumbotron">
      <h1 class="display-4">Admin Dashboard</h1>
      <p class="lead">Welcome, ${user.username}!</p>
      <hr class="my-4">
      <p>Here you can manage customers, invoices, service requests, and view feedback.</p>
      <a class="btn btn-primary btn-lg" href="<%=request.getContextPath() %>/AdminServlet?action=manageCustomers" role="button">Manage Customers</a>
      <a class="btn btn-success btn-lg" href="<%=request.getContextPath() %>/AdminServlet?action=manageInvoices" role="button">Manage Invoices</a>
      <a class="btn btn-info btn-lg" href="<%=request.getContextPath() %>/AdminServlet?action=manageRequests" role="button">Manage Service Requests</a>
      <a class="btn btn-warning btn-lg" href="<%=request.getContextPath() %>/AdminServlet?action=viewFeedback" role="button">View Feedback</a>
    </div>
  </div>

  <%@ include file="common/footer.jsp" %>

  <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.3/dist/umd/popper.min.js"></script>
  <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
  <script src="js/script.js"></script>
</body>
</html>
