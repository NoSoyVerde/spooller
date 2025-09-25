<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Crear Usuario</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">
<div class="container mt-5">
    <h2>Crear Nuevo Usuario</h2>
    <form action="UsuarioController" method="post">
        <div class="mb-3">
            <label class="form-label">Username</label>
            <input type="text" class="form-control" name="username" required>
        </div>
        <div class="mb-3">
            <label class="form-label">Nombre</label>
            <input type="text" class="form-control" name="nombre" required>
        </div>
        <div class="mb-3">
            <label class="form-label">Apellido1</label>
            <input type="text" class="form-control" name="apellido1">
        </div>
        <div class="mb-3">
            <label class="form-label">Apellido2</label>
            <input type="text" class="form-control" name="apellido2">
        </div>
        <button type="submit" class="btn btn-success">Crear</button>
        <a href="UsuarioController" class="btn btn-secondary">Volver</a>
    </form>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
