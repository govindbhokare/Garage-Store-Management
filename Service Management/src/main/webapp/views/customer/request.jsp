<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Create Service Request</title>
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
        .form-control {
            border-radius: 5px;
            margin-bottom: 20px;
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
            <h3>Create Service Request</h3>
        </div>
        <div class="card-body">
            <form action="<%=request.getContextPath() %>/customer" method="post">
                <input type="hidden" name="action" value="createRequest"> <!-- Hidden field to specify action -->
                <div class="mb-3">
                    <label for="vehicleNumber" class="form-label">Vehicle Number</label>
                    <input type="text" class="form-control" id="vehicleNumber" name="vehicleNumber" required>
                </div>
                <div class="mb-3">
                    <label for="model" class="form-label">Model</label>
                    <input type="text" class="form-control" id="model" name="model" required>
                </div>
                <div class="mb-3">
                    <label for="problemDescription" class="form-label">Problem Description</label>
                    <textarea class="form-control" id="problemDescription" name="problemDescription" rows="3" required></textarea>
                </div>
                <button type="submit" class="btn btn-primary w-100">Create Request</button>
            </form>
        </div>
    </div>
</div>

<!-- Bootstrap Bundle JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
