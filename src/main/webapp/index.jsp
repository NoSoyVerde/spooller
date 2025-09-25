<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Inicio</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Bootstrap Icons -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.1/font/bootstrap-icons.css">
</head>
<body class="bg-light d-flex justify-content-center align-items-center vh-100">

<div class="text-center">
    <h1 class="display-3 text-primary"><i class="bi bi-emoji-smile-fill"></i> Hello Friend!</h1>
    <p class="lead text-secondary">Bienvenido a nuestra aplicación web.</p>
    
    <div class="mt-4">
        <a href="usuario.jsp" class="btn btn-primary btn-lg me-2">
            <i class="bi bi-person-circle"></i> Ver Usuario
        </a>
        <a href="error.jsp" class="btn btn-danger btn-lg">
            <i class="bi bi-exclamation-triangle-fill"></i> Simular Error
        </a>
    </div>
</div>

<!-- Bootstrap JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
