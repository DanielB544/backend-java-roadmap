import java.util.HashSet;

public class App {
    public static void main(String[] args) throws Exception {
        /*Libro libro = new Libro(1, "Hobbit", "J.R.R. Tolkien", 0, true);
        Libro libro2 = new Libro(2, "Clean Code", "Robert C. Martin", 2008, true);
        Libro libro3 = new Libro(3, "1984", "George Orwell");
        
        libro.prestar();
        libro.devolver();

        System.out.println( "ID: " + libro.getId() + "\n" +
                            "Título: " + libro.getTitulo() + "\n" +
                            "Autor: " + libro.getAutor() + "\n" +
                            "Año: " + libro.getAnio() + "\n" +
                            "Disponible: " + (libro.isDisponible() ? "Sí" : "No") + "\n"
                            );

        libro.setTitulo("El Hobbit: Un viaje inesperado");
        libro.setAutor("J.R.R. Tolkien");
        libro.setAnio(1937);

        System.out.println( "ID: " + libro.getId() + "\n" +
                            "Título: " + libro.getTitulo() + "\n" +
                            "Autor: " + libro.getAutor() + "\n" +
                            "Año: " + libro.getAnio() + "\n" +
                            "Disponible: " + (libro.isDisponible() ? "Sí" : "No") + "\n"
                            );
        
        System.out.println(libro);
        System.out.println(libro2.toString());*/

        /*try{
            libro.setAnio(-1);
        }catch(IllegalArgumentException e){
            System.out.println("Error: " + e.getMessage());
        }finally{
            System.out.println("El programa continua");
        }*/

        HashSet<Libro> libros = new HashSet<>();

        Libro libroA = new Libro (1,"Hobbit", "J.R.R. TOLKIEN");
        Libro libroB = new Libro (2,"Hobbit", "J.R.R. TOLKIEN");
        Libro libroC = new Libro (3,"Hobbit", "George Orwell");

        libros.add(libroA);
        libros.add(libroB);
        libros.add(libroC);

        System.out.println(libroA.equals(libroB));
        System.out.println(libroA.equals(libroC));
        System.out.println(libroA.hashCode());
        System.out.println(libroB.hashCode());
        System.out.println(libroC.hashCode());

        System.out.println("Libros en la colección: " + libros.size());
    }
}
