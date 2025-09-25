<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Usuario</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">

<div class="container mt-5">
    <div class="row justify-content-center">
        <div class="col-md-8">
            <div class="card shadow-sm">
                <div class="card-header bg-primary text-white">
                    <h3 class="mb-0"><i class="bi bi-person-circle"></i> Información del Usuario</h3>
                </div>
                <div class="card-body">
                    <table class="table table-striped table-bordered">
                        <tbody>
                            <tr>
                                <th>ID</th>
                                <td>${usuario.id}</td>
                            </tr>
                            <tr>
                                <th>Username</th>
                                <td>${usuario.username}</td>
                            </tr>
                            <tr>
                                <th>Nombre</th>
                                <td>${usuario.nombre}</td>
                            </tr>
                            <tr>
                                <th>Primer Apellido</th>
                                <td>${usuario.apellido1}</td>
                            </tr>
                            <tr>
                                <th>Segundo Apellido</th>
                                <td>${usuario.apellido2}</td>
                            </tr>
                        </tbody>
                    </table>
                    <a href="index.jsp" class="btn btn-secondary mt-3">Volver al inicio</a>
                </div>
            </div>
        </div>
    </div>
</div>

<!-- Bootstrap JS y dependencias -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
<!-- Bootstrap Icons -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.1/font/bootstrap-icons.css">
</body>
</html>
