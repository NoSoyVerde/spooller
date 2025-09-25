<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Error</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">

<div class="container mt-5">
    <div class="row justify-content-center">
        <div class="col-md-8">
            <div class="card border-danger shadow-sm">
                <div class="card-header bg-danger text-white">
                    <h3 class="mb-0"><i class="bi bi-exclamation-triangle-fill"></i> ¡Ha ocurrido un error!</h3>
                </div>
                <div class="card-body">
                    <p class="lead">Se ha producido un error en la aplicación:</p>
                    <p class="alert alert-warning">${errorMessage}</p>
                    <p>Por favor, inténtelo de nuevo más tarde o contacte con soporte si el problema persiste.</p>
                    <a href="index.jsp" class="btn btn-primary mt-3">Volver al inicio</a>
                </div>
            </div>
        </div>
    </div>
</div>

<!-- Bootstrap JS y dependencias -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
<!-- Bootstrap Icons (opcional) -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.1/font/bootstrap-icons.css">
</body>
</html>
