<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
  <div class="container">
    <a class="navbar-brand" href="#">Admin Panel - Mechanic Store Manager</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav"
      aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNav">
      <ul class="navbar-nav mr-auto">
        <li class="nav-item">
          <a class="nav-link" href="<%=request.getContextPath() %>/AdminServlet">Dashboard</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="<%=request.getContextPath() %>/AdminServlet?action=manageCustomers">Manage Customers</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="<%=request.getContextPath() %>/AdminServlet?action=manageInvoices">Manage Invoices</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="<%=request.getContextPath() %>/AdminServlet?action=manageRequests">Manage Service Requests</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="<%=request.getContextPath() %>/AdminServlet?action=viewFeedback">View Feedback</a>
        </li>
      </ul>
      <ul class="navbar-nav">
        <li class="nav-item">
          <a class="nav-link" href="#">Logout</a> <!-- Add logout functionality as needed -->
        </li>
      </ul>
    </div>
  </div>
</nav>
