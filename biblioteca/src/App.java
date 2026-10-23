public class App {

    public static void main(String[] args) {

        // Crear libros
        Libro libro1 = new Libro(
                1,
                "Hobbit",
                "J.R.R. Tolkien",
                1937,
                true
        );

        Libro libro2 = new Libro(
                2,
                "Clean Code",
                "Robert C. Martin",
                2008,
                true
        );

        Libro libro3 = new Libro(
                3,
                "1984",
                "George Orwell"
        );

        // Crear biblioteca

        BibliotecaRepository bibliotecaRepository = new BibliotecaRepository();
        BibliotecaService bibliotecaService = new BibliotecaService(bibliotecaRepository);

        // Agregar libros
        bibliotecaService.agregarLibro(libro1);
        bibliotecaService.agregarLibro(libro2);
        bibliotecaService.agregarLibro(libro3);

        // Mostrar cantidad de libros
        System.out.println(
                "Cantidad de libros en la biblioteca: "
                        + bibliotecaService.consultarCantidadLibros()
        );

        // Mostrar libros
        System.out.println("\n--- LIBROS ---");

        for (Libro libro : bibliotecaService.obtenerLibros()) {
            System.out.println(libro);
        }

        // Buscar libro
        System.out.println("\n--- BUSCAR LIBRO ---");

        int idBuscado = 2;
        Libro libroEncontrado = bibliotecaService.buscarLibroPorId(idBuscado);

        if (libroEncontrado == null) {
            System.out.println(
                    "El libro con el ID " + idBuscado + " no existe"
            );
        } else {
            System.out.println("Libro encontrado:");
            System.out.println(libroEncontrado);
        }

        // Actualizar libro
        System.out.println("\n--- ACTUALIZAR LIBRO ---");

        boolean actualizado = bibliotecaService.actualizarLibro(
                1,
                "El Hobbit: Un viaje inesperado",
                "J.R.R. Tolkien",
                1937
        );

        if (actualizado) {
            System.out.println("Libro actualizado correctamente");
            System.out.println(bibliotecaService.buscarLibroPorId(1));
        } else {
            System.out.println("No se pudo actualizar el libro");
        }

        // Prestar libro 
        System.out.println("\n--- PRESTAR LIBRO ---");
        boolean prestarLibro1 = bibliotecaService.prestarLibro(1);
        if (prestarLibro1) {
            System.out.println("Libro prestado correctamente");
        } else {
            System.out.println("No se pudo prestar el libro");
        }

        // Devolver libro 
        System.out.println("\n--- DEVOLVER LIBRO ---");
        boolean devolverLibro1 = bibliotecaService.devolverLibro(1);
        if (devolverLibro1) {
            System.out.println("Libro devuelto correctamente");
        } else {
            System.out.println("No se pudo devolver el libro");
        }

        // Eliminar libro
        System.out.println("\n--- ELIMINAR LIBRO ---");

        int idEliminar = 2;
        boolean libroEliminar = bibliotecaService.eliminarLibroPorId(idEliminar);

            if (libroEliminar) {
                System.out.println("Libro eliminado correctamente");
            } else {
                System.out.println("No se pudo eliminar el libro");
            }

        // Mostrar estado final de la biblioteca
        System.out.println("\n--- BIBLIOTECA FINAL ---");

        for (Libro libro : bibliotecaService.obtenerLibros()) {
            System.out.println(libro);
        }

        
    }
}