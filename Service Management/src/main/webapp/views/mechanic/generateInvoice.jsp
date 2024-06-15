<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Generate Invoice</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

<div class="container mt-5">
    <div class="row justify-content-center">
        <div class="col-md-6">
            <div class="card">
                <div class="card-header bg-primary text-white">
                    <h3 class="text-center">Generate Invoice</h3>
                </div>
                <div class="card-body">
                    <form action="<%=request.getContextPath() %>/MechanicServlet" method="post">
                        <input type="hidden" name="action" value="generateInvoice"> <!-- Hidden field to specify action -->
                        <div class="mb-3">
                            <label for="vehicleNumber" class="form-label">Vehicle Number</label>
                            <input type="text" class="form-control" id="vehicleNumber" name="vehicleNumber" required>
                        </div>
                        <div class="mb-3">
                            <label for="totalAmount" class="form-label">Total Amount</label>
                            <input type="number" class="form-control" id="totalAmount" name="totalAmount" required>
                        </div>
                        <button type="submit" class="btn btn-primary w-100">Generate Invoice</button>
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
