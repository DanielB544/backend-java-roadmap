
package com.daniel.biblioteca;

import java.sql.SQLException;

public class App {

    public static void main(String[] args) throws SQLException {

        BibliotecaRepository repository = new BibliotecaRepository();
        BibliotecaService service = new BibliotecaService(repository);

        // Crear libros sin asignar IDs manualmente
        Libro libro1 = new Libro(
                "Hobbit",
                "J.R.R. Tolkien",
                1937
        );

        Libro libro2 = new Libro(
                "Clean Code",
                "Robert C. Martin",
                2008
        );

        Libro libro3 = new Libro(
        "1984",
        "George Orwell",
        1949
        );

        // Registrar libros y obtener los IDs generados por MySQL
        System.out.println("--- AGREGAR LIBROS ---");

        Libro libroGuardado1 = service.agregarLibro(libro1);
        Libro libroGuardado2 = service.agregarLibro(libro2);
        Libro libroGuardado3 = service.agregarLibro(libro3);
        

        mostrarResultadoRegistro("Hobbit", libroGuardado1);
        mostrarResultadoRegistro("Clean Code", libroGuardado2);
        mostrarResultadoRegistro("1984",libroGuardado3);
        

        // Agregar un libro de prueba nuevo
        Libro libroNuevo = new Libro(
                "Clean Architecture",
                "Robert C. Martin",
                2017
        );
        Libro libroGuardadoNuevo = service.agregarLibro(libroNuevo);
        mostrarResultadoRegistro("Clean Architecture", libroGuardadoNuevo);


        Libro libroGuardado = service.agregarLibro(libroNuevo);
        if (libroGuardado != null) {
            System.out.println(libroGuardado.getId());
        }


        // Mostrar cantidad y libros
        System.out.println("\n--- CANTIDAD DE LIBROS ---");
        System.out.println(service.consultarCantidadLibros());

        mostrarLibros(service);

        // Buscar un libro existente usando su ID real
        System.out.println("\n--- BUSCAR LIBRO ---");

        if (libroGuardado != null) {
            mostrarLibro(service.buscarLibroPorId(libroGuardado.getId()));
        } else {
            System.out.println(
                    "Clean Architecture ya existía; se buscará por título y autor."
            );

            for (Libro libro : service.obtenerLibros()) {
                if (libro.getTitulo().equals("Clean Architecture")
                        && libro.getAutor().equals("Robert C. Martin")) {
                    mostrarLibro(libro);
                    break;
                }
            }
        }

        // Actualizar el primer libro que se registró en esta ejecución
        System.out.println("\n--- ACTUALIZAR LIBRO ---");

        if (libroGuardado1 != null) {
            boolean actualizado = service.actualizarLibro(
                    libroGuardado1.getId(),
                    "El Hobbit: Un viaje inesperado",
                    "J.R.R. Tolkien",
                    1937
            );

            System.out.println(
                    actualizado
                            ? "Libro actualizado correctamente"
                            : "No se pudo actualizar el libro"
            );
        } else {
            System.out.println(
                    "Hobbit ya existía; se omite la actualización de este registro."
            );
        }

        
        // Buscar libro para las pruebas
        Libro libroPrueba = buscarPorTitulo(
                service,
                "Clean Architecture"
        );

        if (libroPrueba != null) {
            int idPrueba = libroPrueba.getId();

            // Prestar
            System.out.println("\n--- PRESTAR LIBRO ---");
            boolean prestado = service.prestarLibro(idPrueba);
            System.out.println(
                    prestado
                            ? "Libro prestado correctamente"
                            : "No se pudo prestar el libro"
            );

            // Devolver
            System.out.println("\n--- DEVOLVER LIBRO ---");
            boolean devuelto = service.devolverLibro(idPrueba);
            System.out.println(
                    devuelto
                            ? "Libro devuelto correctamente"
                            : "No se pudo devolver el libro"
            );

            // Eliminar
            System.out.println("\n--- ELIMINAR LIBRO ---");
            boolean eliminado = service.eliminarLibroPorId(idPrueba);
            System.out.println(
                    eliminado
                            ? "Libro eliminado correctamente"
                            : "No se pudo eliminar el libro"
            );
        } else {
            System.out.println(
                    "No se encontró Clean Architecture para las pruebas."
            );
        }

        // Mostrar estado final
        System.out.println("\n--- BIBLIOTECA FINAL ---");
        mostrarLibros(service);
    }

    private static void mostrarResultadoRegistro(String titulo, Libro libro) {
        if (libro != null) {
            System.out.println(titulo + " guardado con ID: " + libro.getId());
        } else {
            System.out.println(
                    titulo + " no se agregó porque ya existe o no se obtuvo un ID."
            );
        }
    }

    private static void mostrarLibros(BibliotecaService service)
            throws SQLException {
        for (Libro libro : service.obtenerLibros()) {
            System.out.println(libro);
        }
    }

    private static void mostrarLibro(Libro libro) {
        if (libro == null) {
            System.out.println("Libro no encontrado");
        } else {
            System.out.println(libro);
        }
    }

    private static Libro buscarPorTitulo(
            BibliotecaService service,
            String titulo) throws SQLException {

        for (Libro libro : service.obtenerLibros()) {
            if (libro.getTitulo().equals(titulo)) {
                return libro;
            }
        }

        return null;
    }
}
