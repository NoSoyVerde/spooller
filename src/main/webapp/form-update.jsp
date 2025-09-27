<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Actualizar Usuario</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">
<div class="container mt-5">
    <h2>Actualizar Usuario</h2>

    <c:if test="${not empty usuario}">
        <form action="UsuarioController" method="post">
            <input type="hidden" name="_method" value="PUT">
            <input type="hidden" name="id" value="${usuario.id}">

            <div class="mb-3">
                <label class="form-label">Username</label>
                <input type="text" class="form-control" name="username" value="${usuario.username}" required>
            </div>
            <div class="mb-3">
                <label class="form-label">Nombre</label>
                <input type="text" class="form-control" name="nombre" value="${usuario.nombre}" required>
            </div>
            <div class="mb-3">
                <label class="form-label">Apellido1</label>
                <input type="text" class="form-control" name="apellido1" value="${usuario.apellido1}">
            </div>
            <div class="mb-3">
                <label class="form-label">Apellido2</label>
                <input type="text" class="form-control" name="apellido2" value="${usuario.apellido2}">
            </div>

            <button type="submit" class="btn btn-primary">Actualizar</button>
            <a href="UsuarioController" class="btn btn-secondary">Volver</a>
        </form>
    </c:if>

    <c:if test="${empty usuario}">
        <div class="alert alert-danger">
            <strong>Error:</strong> Usuario no encontrado.
        </div>
        <a href="UsuarioController" class="btn btn-secondary">Volver</a>
    </c:if>

</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
