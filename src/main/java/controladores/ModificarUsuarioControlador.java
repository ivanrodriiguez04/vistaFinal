package controladores;

import java.io.IOException;

import Servicios.ModificarServicio;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

@WebServlet("/modificarUsuario")
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024 * 2, // 2MB
        maxFileSize = 1024 * 1024 * 10,      // 10MB
        maxRequestSize = 1024 * 1024 * 50   // 50MB
)
public class ModificarUsuarioControlador extends HttpServlet{
	private ModificarServicio modificarServicio;

	@Override
	public void init() throws ServletException {
	    this.modificarServicio = new ModificarServicio(); // Inicializa el servicio aquí
	}
	@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            // Recuperar parámetros del formulario
            long idUsuario = Long.parseLong(request.getParameter("idUsuario"));
            String nuevoNombre = request.getParameter("nuevoNombre");
            String nuevoTelefono = request.getParameter("nuevoTelefono");

            // Procesar el archivo de la foto
            Part fotoPart = request.getPart("nuevaFoto");
            byte[] nuevaFoto = null;

            if (fotoPart != null && fotoPart.getSize() > 0) {
                nuevaFoto = fotoPart.getInputStream().readAllBytes();
            }

            // Llamar al servicio API
            String resultado = modificarServicio.modificarUsuario(idUsuario, nuevoNombre, nuevoTelefono, nuevaFoto);

            // Redirigir con el resultado
            request.setAttribute("resultado", resultado);
            request.getRequestDispatcher("menuAdministrador.jsp").forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error al procesar la solicitud: " + e.getMessage());
        }
    }
}
