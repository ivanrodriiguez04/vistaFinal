package controladores;

import java.io.IOException;

import Dtos.RegistroUsuarioDto;
import Servicios.RegistroServicio;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/registroClub")
public class RegistroClubControlador extends HttpServlet{
	private RegistroServicio registroServicio;
	@Override
    public void init() throws ServletException {
        // Inicializar el servicio de registro de usuario
        this.registroServicio = new RegistroServicio();
    }
	@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Recoger los parámetros del formulario de registro
        String nombre = request.getParameter("nombreClub");
        String sede = request.getParameter("sedeClub");
        String correo = request.getParameter("emailClub");
        String password = request.getParameter("passwordClub");

        // Crear el objeto DTO con los datos del usuario
        RegistroUsuarioDto registroDto = new RegistroUsuarioDto();
        registroDto.setNombreUsuario(nombre);
        registroDto.setTelefonoUsuario(sede);
        registroDto.setEmailUsuario(correo);
        registroDto.setPasswordUsuario(password);

        // Llamar al servicio para registrar al usuario
        boolean registroExitoso = registroServicio.registrarClub(registroDto);

        if (registroExitoso) {
            // Registro exitoso, redirigir a la página de inicio o login
            response.sendRedirect("iniciarSesionClub.jsp");
        } else {
            // Si el registro falló (correo ya existente), mostrar un mensaje de error
            request.setAttribute("errorMessage", "El correo ya está registrado.");
            request.getRequestDispatcher("registrarseUsuario.jsp").forward(request, response);
        }
    }
}
