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

    public Libro buscarLibroPorId(int id){
        for (Libro libro : libros) {
            if(id == libro.getId()){
                return libro;
            }
        }
        return null;

    }

    public boolean eliminarLibroPorID(int id){
        for ( int i = 0 ; i < libros.size() ;i++) {
            
            if(id == libros.get(i).getId()){
                libros.remove(i);
                return true;
            }    
            
        }
        return false;
    }
}
