<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Modificar</title>
<link rel="stylesheet" href="css/administrador.css">
<link rel="stylesheet" href="css/index.css">

<link
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css"
	rel="stylesheet" />
<!-- Bootstrap CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<div class="container-fluid">
			<a class="navbar-brand" href="#"> <img
				src="imagenes/logo moto.jpg" alt="Yamaha Logo" width="100"
				height="50">
			</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarNavDropdown"
				aria-controls="navbarNavDropdown" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarNavDropdown">
				<ul class="navbar-nav">
					<li class="nav-item"><a class="nav-link" href="index.jsp">Inicio</a></li>
					<li class="nav-item"><a class="nav-link" href="#">Nosotros</a></li>
					<li class="nav-item"><a class="nav-link" href="#">Eventos</a></li>
					<li class="nav-item"><a class="nav-link" href="#">Contacto</a></li>
					<li class="nav-item"><a class="nav-link" href="#">Rutas</a></li>
					<li class="nav-item"><a class="nav-link" href="#">Sedes</a></li>
					<!-- Dropdown 1 -->
					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle" href="#" id="dropdownMenu1"
						role="button" data-bs-toggle="dropdown" aria-expanded="false">
							Iniciar Sesion </a>
						<ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
							<li><a class="dropdown-item" href="iniciarSesionUsuario.jsp">Usuario</a></li>
							<li><a class="dropdown-item" href="iniciarSesionClub.jsp">Club</a></li>
						</ul></li>
					<!-- Dropdown 2 -->
					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle" href="#" id="dropdownMenu2"
						role="button" data-bs-toggle="dropdown" aria-expanded="false">
							Registrarse </a>
						<ul class="dropdown-menu" aria-labelledby="dropdownMenu2">
							<li><a class="dropdown-item" href="registrarseUsuario.jsp">Usuario</a></li>
							<li><a class="dropdown-item" href="registrarseUsuario.jsp">Club</a></li>
						</ul></li>
				</ul>
			</div>
		</div>
	</nav>
	<div class="container-fluid">
		<h1>Panel de Administrador</h1>
		<div class="row">
			<!-- Modificar Usuario -->
			<div class="col-md-6">
				<div class="container">
					<h2>Modificar Usuario</h2>
					<form action="modificarUsuario" method="post"
						enctype="multipart/form-data">
						<label for="idUsuario">ID Usuario:</label> <input type="number"
							id="idUsuario" name="idUsuario" required> <label
							for="nuevoNombre">Nuevo Nombre:</label> <input type="text"
							id="nuevoNombre" name="nuevoNombre"> <label
							for="nuevoDni">Nuevo DNI:</label> <input type="text"
							id="nuevoDni" name="nuevoDni"> <label for="nuevoTelefono">Nuevo
							Teléfono:</label> <input type="text" id="nuevoTelefono"
							name="nuevoTelefono"> <label for="nuevoRol">Nuevo
							Rol:</label> <input type="text" id="nuevoRol" name="nuevoRol"> <label
							for="nuevaFoto">Nueva Foto:</label> <input type="file"
							id="nuevaFoto" name="nuevaFoto" accept="image/*">
						<button type="submit">Modificar Usuario</button>
					</form>
				</div>
			</div>

			<!-- Modificar Club -->
			<div class="col-md-6">
				<div class="container">
					<h2>Modificar Club</h2>
					<form action="modificarClub" method="post"
						enctype="multipart/form-data">
						<label for="idClub">ID Club:</label> <input type="number"
							id="idClub" name="idClub" required> <label
							for="nuevoNombre">Nuevo Nombre:</label> <input type="text"
							id="nuevoNombre" name="nuevoNombre"> <label
							for="nuevaSede">Nueva Sede:</label> <input type="text"
							id="nuevaSede" name="nuevaSede"> <label for="nuevaFoto">Nueva
							Foto:</label> <input type="file" id="nuevaFoto" name="nuevaFoto"
							accept="image/*">
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