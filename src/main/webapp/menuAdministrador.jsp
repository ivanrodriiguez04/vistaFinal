<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Modificar</title>
<link rel="stylesheet" href="css/administrador.css">
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css"
	rel="stylesheet" />
<!-- Bootstrap CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body>
    <div class="container-fluid">
        <h1>Modificar</h1>
        <div class="row">
            <!-- Modificar Usuario -->
            <div class="col-md-6">
                <div class="container">
                    <h2>Modificar Usuario</h2>
                    <form action="modificarUsuario" method="post" enctype="multipart/form-data">
                        <label for="idUsuario">ID Usuario:</label>
                        <input type="number" id="idUsuario" name="idUsuario" required>
                        <label for="nuevoNombre">Nuevo Nombre:</label>
                        <input type="text" id="nuevoNombre" name="nuevoNombre">
                        <label for="nuevoTelefono">Nuevo Teléfono:</label>
                        <input type="text" id="nuevoTelefono" name="nuevoTelefono">
                        <label for="nuevaFoto">Nueva Foto:</label>
                        <input type="file" id="nuevaFoto" name="nuevaFoto" accept="image/*">
                        <button type="submit">Modificar Usuario</button>
                    </form>
                </div>
            </div>

            <!-- Modificar Club -->
            <div class="col-md-6">
                <div class="container">
                    <h2>Modificar Club</h2>
                    <form action="modificarClub" method="post" enctype="multipart/form-data">
                        <label for="idClub">ID Club:</label>
                        <input type="number" id="idClub" name="idClub" required>
                        <label for="nuevoNombre">Nuevo Nombre:</label>
                        <input type="text" id="nuevoNombre" name="nuevoNombre">
                        <label for="nuevaSede">Nueva Sede:</label>
                        <input type="text" id="nuevaSede" name="nuevaSede">
                        <label for="nuevaFoto">Nueva Foto:</label>
                        <input type="file" id="nuevaFoto" name="nuevaFoto" accept="image/*">
                        <button type="submit">Modificar Club</button>
                    </form>
                </div>
            </div>
        </div>

        <!-- Resultado -->
        <div>
            <h3>Resultado:</h3>
            <p>${resultado}</p>
        </div>
    </div>
</body>
</html>