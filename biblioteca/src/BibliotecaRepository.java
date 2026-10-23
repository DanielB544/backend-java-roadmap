import java.util.List;
import java.util.ArrayList;


public class BibliotecaRepository {
    private final List<Libro> libros = new ArrayList<>();

    public void agregarLibro(Libro libro){
        this.libros.add(libro);
    }

    public int consultarCantidadLibros() {
        return libros.size();
    }

    public List<Libro> obtenerLibros() {
        return new ArrayList<>(libros);
    }

    public Libro buscarLibroPorId(int id) {

        for (Libro libro : libros) {
            if (libro.getId() == id) {
                return libro;
            }
        }

        return null;
    }
    
    public boolean eliminarLibroPorId(int id) {

        for (int i = 0; i < libros.size(); i++) {

            if (libros.get(i).getId() == id) {
                libros.remove(i);
                return true;
            }
        }

        return false;
    }

    public boolean existeLibro(Libro libro){
        for(Libro libroExiste : libros){
            if (libro.equals(libroExiste)){
                return true;
            }
        }
        return false;
    }
}
