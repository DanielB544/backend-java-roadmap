import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    private List<Libro> libros = new ArrayList<>();

    public void agregarLibro(Libro libro) {
        libros.add(libro);
   }

    public int consultarCantidadLibros() {
        return libros.size();
    }

    public List<Libro> obtenerLibros(){
        return new ArrayList<>(libros);
    }

}
