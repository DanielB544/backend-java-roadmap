package com.daniel.biblioteca;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BibliotecaRepository {

    public Libro agregarLibro(Libro libro) throws SQLException {
        String sql = """
                INSERT INTO libros (titulo, autor, anio, disponible)
                VALUES (?, ?, ?, ?)
                """;

        try (Connection conexion = ConexionBD.obtenerConexion();
             PreparedStatement statement = conexion.prepareStatement(
                     sql, Statement.RETURN_GENERATED_KEYS)) {

            statement.setString(1, libro.getTitulo());
            statement.setString(2, libro.getAutor());
            statement.setInt(3, libro.getAnio());
            statement.setBoolean(4, libro.isDisponible());

            int filas = statement.executeUpdate();

            if (filas == 0) {
                return null;
            }

            try (ResultSet claves = statement.getGeneratedKeys()) {
                if (claves.next()) {
                    int idGenerado = claves.getInt(1);
                    libro.asignarId(idGenerado);
                    return libro;
                }
            }

            return null;
        }
    }

    public int consultarCantidadLibros() throws SQLException {
        String sql = "SELECT COUNT(*) FROM libros";

        try (Connection conexion = ConexionBD.obtenerConexion();
             PreparedStatement statement = conexion.prepareStatement(sql);
             ResultSet resultado = statement.executeQuery()) {

            resultado.next();
            return resultado.getInt(1);
        }
    }

    public List<Libro> obtenerLibros() throws SQLException {
        String sql = """
                SELECT id, titulo, autor, anio, disponible
                FROM libros
                ORDER BY id
                """;

        List<Libro> libros = new ArrayList<>();

        try (Connection conexion = ConexionBD.obtenerConexion();
             PreparedStatement statement = conexion.prepareStatement(sql);
             ResultSet resultado = statement.executeQuery()) {

            while (resultado.next()) {
                libros.add(mapearLibro(resultado));
            }
        }

        return libros;
    }

    public Libro buscarLibroPorId(int id) throws SQLException {
        String sql = """
                SELECT id, titulo, autor, anio, disponible
                FROM libros
                WHERE id = ?
                """;

        try (Connection conexion = ConexionBD.obtenerConexion();
             PreparedStatement statement = conexion.prepareStatement(sql)) {

            statement.setInt(1, id);

            try (ResultSet resultado = statement.executeQuery()) {
                if (resultado.next()) {
                    return mapearLibro(resultado);
                }
            }
        }

        return null;
    }

    public boolean actualizarLibro(Libro libro) throws SQLException {
        String sql = """
                UPDATE libros
                SET titulo = ?, autor = ?, anio = ?, disponible = ?
                WHERE id = ?
                """;

        try (Connection conexion = ConexionBD.obtenerConexion();
            PreparedStatement statement = conexion.prepareStatement(sql)) {

            statement.setString(1, libro.getTitulo());
            statement.setString(2, libro.getAutor());
            statement.setInt(3, libro.getAnio());
            statement.setBoolean(4, libro.isDisponible());
            statement.setInt(5, libro.getId());

            return statement.executeUpdate() > 0;
        }
    }

    public boolean eliminarLibroPorId(int id) throws SQLException {
        String sql = "DELETE FROM libros WHERE id = ?";

        try (Connection conexion = ConexionBD.obtenerConexion();
             PreparedStatement statement = conexion.prepareStatement(sql)) {

            statement.setInt(1, id);
            return statement.executeUpdate() > 0;
        }
    }

    public boolean existeLibro(Libro libro) throws SQLException {
        String sql = """
                SELECT 1
                FROM libros
                WHERE titulo = ? AND autor = ?
                LIMIT 1
                """;

        try (Connection conexion = ConexionBD.obtenerConexion();
             PreparedStatement statement = conexion.prepareStatement(sql)) {

            statement.setString(1, libro.getTitulo());
            statement.setString(2, libro.getAutor());

            try (ResultSet resultado = statement.executeQuery()) {
                return resultado.next();
            }
        }
    }

    private Libro mapearLibro(ResultSet resultado) throws SQLException {
        return new Libro(
                resultado.getInt("id"),
                resultado.getString("titulo"),
                resultado.getString("autor"),
                resultado.getInt("anio"),
                resultado.getBoolean("disponible")
        );
    }

}
