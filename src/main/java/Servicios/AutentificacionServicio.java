package Servicios;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;

import Dtos.LoginClubDto;
import Dtos.LoginUsuarioDto;

public class AutentificacionServicio {

    private String rol = ""; // Variable para almacenar el rol del usuario o club

    public boolean verificarUsuario(String correo, String password) {
        boolean todoOk = false;

        try {
            // Crear la URL de la API para la verificación del usuario
            URL url = new URL("http://localhost:8081/api/login/validarUsuario");
            HttpURLConnection conexion = (HttpURLConnection) url.openConnection();
            conexion.setRequestMethod("POST");
            conexion.setRequestProperty("Content-Type", "application/json");
            conexion.setDoOutput(true);

            // Crear el objeto que contiene la información para el login
            LoginUsuarioDto loginRequest = new LoginUsuarioDto();
            loginRequest.setEmail(correo);
            loginRequest.setPassword(password);

            // Convertir el objeto loginRequest a JSON utilizando ObjectMapper
            ObjectMapper mapper = new ObjectMapper();
            String jsonInput = mapper.writeValueAsString(loginRequest);  // Convertir a JSON

            // Enviar la solicitud al servidor
            try (OutputStream ot = conexion.getOutputStream()) {
                ot.write(jsonInput.getBytes());
                ot.flush();
            }

            // Obtener el código de respuesta
            int responseCode = conexion.getResponseCode();

            if (responseCode == HttpURLConnection.HTTP_OK) { // 200 OK
                // Leer la respuesta del servidor
                try (BufferedReader in = new BufferedReader(new InputStreamReader(conexion.getInputStream()))) {
                    StringBuilder response = new StringBuilder();
                    String inputLine;
                    while ((inputLine = in.readLine()) != null) {
                        response.append(inputLine);
                    }

                    String respuesta = response.toString();
                    System.out.println("Respuesta del servidor: " + respuesta);  // Ver lo que estás recibiendo

                    // Validar respuesta y asignar rol
                    if ("admin".equals(respuesta) || "usuario".equals(respuesta)) {
                        this.rol = respuesta;  // Guardamos el rol recibido
                        todoOk = true;  // Usuario validado correctamente
                    } else {
                        System.out.println("Rol desconocido o error en la respuesta.");
                    }
                }
            } else {
                System.out.println("Error: Código de respuesta no OK. Código: " + responseCode);
            }

        } catch (Exception e) {
            System.out.println("ERROR: " + e);
            e.printStackTrace();
        }

        return todoOk;
    }

    public boolean verificarClub(String correo, String password) {
        boolean todoOk = false;

        try {
            // Crear la URL de la API para la verificación del club
            URL url = new URL("http://localhost:8081/api/login/validarClub");
            HttpURLConnection conexion = (HttpURLConnection) url.openConnection();
            conexion.setRequestMethod("POST");
            conexion.setRequestProperty("Content-Type", "application/json");
            conexion.setDoOutput(true);

            // Crear el objeto que contiene la información para el login
            LoginClubDto loginRequest = new LoginClubDto();
            loginRequest.setEmailClub(correo);
            loginRequest.setPasswordClub(password);

            // Convertir el objeto loginRequest a JSON utilizando ObjectMapper
            ObjectMapper mapper = new ObjectMapper();
            String jsonInput = mapper.writeValueAsString(loginRequest);  // Convertir a JSON

            // Enviar la solicitud al servidor
            try (OutputStream ot = conexion.getOutputStream()) {
                ot.write(jsonInput.getBytes());
                ot.flush();
            }

            // Obtener el código de respuesta
            int responseCode = conexion.getResponseCode();

            if (responseCode == HttpURLConnection.HTTP_OK) { // 200 OK
                // Leer la respuesta del servidor
                try (BufferedReader in = new BufferedReader(new InputStreamReader(conexion.getInputStream()))) {
                    StringBuilder response = new StringBuilder();
                    String inputLine;
                    while ((inputLine = in.readLine()) != null) {
                        response.append(inputLine);
                    }

                    String respuesta = response.toString();
                    System.out.println("Respuesta del servidor: " + respuesta);  // Ver lo que estás recibiendo

                    // Validar respuesta y asignar rol
                    if ("club".equals(respuesta)) {
                        this.rol = respuesta;  // Guardamos el rol recibido
                        todoOk = true;  // Club validado correctamente
                    } else {
                        System.out.println("Respuesta inesperada o error en la respuesta.");
                    }
                }
            } else {
                System.out.println("Error: Código de respuesta no OK. Código: " + responseCode);
            }

        } catch (Exception e) {
            System.out.println("ERROR: " + e);
            e.printStackTrace();
        }

        return todoOk;
    }

    public String getRol() {
        return rol;
    }
}
