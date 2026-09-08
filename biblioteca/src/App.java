public class App {

    public static void main(String[] args) throws Exception {

        Libro libro = new Libro(1, "Hobbit", "J.R.R. Tolkien", 1937, true);

        Libro libro2 = new Libro(2, "Clean Code", "Robert C. Martin", 2008, true);

        Libro libro3 = new Libro(3, "1984", "George Orwell");

        libro.prestar();
        libro.devolver();

        System.out.println(
            "ID: " + libro.getId() + "\n" +
            "Título: " + libro.getTitulo() + "\n" +
            "Autor: " + libro.getAutor() + "\n" +
            "Año: " + libro.getAnio() + "\n" +
            "Disponible: " + (libro.isDisponible() ? "Sí" : "No")
        );
    }
}