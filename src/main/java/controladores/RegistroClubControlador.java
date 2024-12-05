package controladores;

import java.io.IOException;

import Dtos.RegistroClubDto;
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
	        throws ServletException, IOException {
	    String nombre = request.getParameter("nombreClub");
	    String sede = request.getParameter("sedeClub");
	    String correo = request.getParameter("emailClub");
	    String password = request.getParameter("passwordClub");

	    // Ajustar el DTO para que coincida con el backend
	    RegistroClubDto registroDto = new RegistroClubDto();
	    registroDto.setNombreClub(nombre);
	    registroDto.setSedeClub(sede);
	    registroDto.setEmailClub(correo);
	    registroDto.setPasswordClub(password);

	    // Llamar al servicio para registrar el club
	    boolean registroExitoso = registroServicio.registrarClub(registroDto);

	    if (registroExitoso) {
	        response.sendRedirect("iniciarSesionClub.jsp");
	    } else {
	        request.setAttribute("errorMessage", "El correo ya está registrado.");
	        request.getRequestDispatcher("registrarseUsuario.jsp").forward(request, response);
	    }
	}

}
