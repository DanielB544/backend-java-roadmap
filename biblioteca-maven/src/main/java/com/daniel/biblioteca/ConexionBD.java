package com.daniel.biblioteca;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {

    private static final String URL = System.getenv()
            .getOrDefault("DB_URL", "jdbc:mysql://localhost:3306/biblioteca_db");

    private static final String USUARIO = System.getenv()
            .getOrDefault("DB_USER", "root");

    public static Connection obtenerConexion() throws SQLException {
        String contrasena = System.getenv("DB_PASSWORD");

        if (contrasena == null || contrasena.isBlank()) {
            throw new IllegalStateException(
                    "Configura la variable de entorno DB_PASSWORD"
            );
        }

        return DriverManager.getConnection(URL, USUARIO, contrasena);
    }
}
