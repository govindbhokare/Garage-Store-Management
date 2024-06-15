<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Assigned Vehicles</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

<div class="container mt-5">
    <h2 class="text-center mb-4">Assigned Vehicles</h2>
    <div class="row justify-content-center">
        <div class="col-md-8">
            <!-- Display assigned vehicles here -->
            <table class="table">
                <thead>
                    <tr>
                        <th>Vehicle Number</th>
                        <th>Model</th>
                        <th>Problem Description</th>
                        <!-- Add more columns as needed -->
                    </tr>
                </thead>
                <tbody>
                    <!-- Iterate over assigned vehicles and display them -->
                    <c:forEach var="vehicle" items="${assignedVehicles}">
                        <tr>
                            <td>${vehicle.vehicleNumber}</td>
                            <td>${vehicle.model}</td>
                            <td>${vehicle.problemDescription}</td>
                            <!-- Add more columns as needed -->
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>

<!-- Bootstrap Bundle JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
