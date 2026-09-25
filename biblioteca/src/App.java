public class App {

    public static void main(String[] args) throws Exception {

        // Crear libros
        Libro libro1 = new Libro(1, "Hobbit", "J.R.R. Tolkien", 0, true);
        Libro libro2 = new Libro(2, "Clean Code", "Robert C. Martin", 2008, true);
        Libro libro3 = new Libro(3, "1984", "George Orwell");

        // Probar préstamo y devolución
        libro1.prestar();
        libro1.devolver();

        // Mostrar libro
        System.out.println(
            "ID: " + libro1.getId() + "\n" +
            "Título: " + libro1.getTitulo() + "\n" +
            "Autor: " + libro1.getAutor() + "\n" +
            "Año: " + libro1.getAnio() + "\n" +
            "Disponible: " + (libro1.isDisponible() ? "Sí" : "No") + "\n"
        );

        // Modificar datos mediante setters
        libro1.setTitulo("El Hobbit: Un viaje inesperado");
        libro1.setAutor("J.R.R. Tolkien");
        libro1.setAnio(1937);

        // Mostrar libro después de modificarlo
        System.out.println(
            "ID: " + libro1.getId() + "\n" +
            "Título: " + libro1.getTitulo() + "\n" +
            "Autor: " + libro1.getAutor() + "\n" +
            "Año: " + libro1.getAnio() + "\n" +
            "Disponible: " + (libro1.isDisponible() ? "Sí" : "No") + "\n"
        );

        // Usar toString()
        System.out.println(libro1);
        System.out.println(libro2);
        System.out.println(libro3);

        // Crear biblioteca
        Biblioteca biblioteca = new Biblioteca();

        // Agregar libros a la biblioteca
        biblioteca.agregarLibro(libro1);
        biblioteca.agregarLibro(libro2);
        biblioteca.agregarLibro(libro3);

        // Consultar cantidad de libros en la biblioteca
        System.out.println("Cantidad de libros en la biblioteca: " + biblioteca.consultarCantidadLibros());
    
            
        //Recorrer la lista de libros y mostrar sus detalles
        for (Libro libro : biblioteca.obtenerLibros()) {
            System.out.println(libro);
        }
    }
}