package controladores;

import java.io.IOException;

import Servicios.AutentificacionServicio;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/loginClub")
public class LoginClubControlador extends HttpServlet {

    AutentificacionServicio servicio;

    @Override
    public void init() throws ServletException {
        this.servicio = new AutentificacionServicio();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Recoger los parámetros del formulario
        String correo = request.getParameter("emailClub");
        String password = request.getParameter("passwordClub");

        // Imprimir los valores para depuración
        System.out.println("Correo recibido: " + correo);
        System.out.println("Contraseña recibida: " + password);

        // Llamar al servicio para verificar el club
        boolean isValidClub = servicio.verificarClub(correo, password);

        System.out.println("isValidClub: " + isValidClub);

        if (isValidClub) {
            // Lógica para manejar el rol y redirigir
            String rol = servicio.getRol();  // Obtener el rol si está definido
            System.out.println("Rol del club: " + rol);
            if ("club".equals(rol)) {
                // Redirigir al panel principal del club
                response.sendRedirect("index.jsp");
            } else {
                // Rol desconocido
                request.setAttribute("errorMessage", "Rol desconocido.");
                request.getRequestDispatcher("iniciarSesionClub.jsp").forward(request, response);
            }
        } else {
            // Enviar un mensaje de error
            request.setAttribute("errorMessage", "Usuario o contraseña incorrectos.");
            request.getRequestDispatcher("iniciarSesionClub.jsp").forward(request, response); // Redirigir de vuelta al formulario
        }
    }
}