<%-- <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> --%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Garage Store Management</title>
  <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
  <link href="css/style.css" rel="stylesheet">
</head>
<body>
  
  <%@ include file="common/navbar.jsp" %>

  <div class="container mt-5">
    <div class="jumbotron">
      <h1 class="display-4">Welcome to Garage Store Management</h1>
      <p class="lead">Your all-in-one solution for managing your mechanic store efficiently.</p>
      <hr class="my-4">
      <p>Keep track of customer requests, manage invoices, and gather valuable feedback.</p>
      <a class="btn btn-primary btn-lg" href="customer/signup.jsp" role="button">Get Started</a>
    </div>
  </div>

  <%@ include file="common/footer.jsp" %>

  <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.3/dist/umd/popper.min.js"></script>
  <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
  <script src="js/script.js"></script>
</body>
</html>
