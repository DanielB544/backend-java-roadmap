import java.util.List;

public class BibliotecaService {

    private final BibliotecaRepository repository;

    public BibliotecaService(BibliotecaRepository repository) {
        this.repository = repository;
    }

    
    public boolean agregarLibro(Libro libro) {
        if(repository.existeLibro(libro)==true){
            return false;
        }else{
            repository.agregarLibro(libro);
        }
        return true;
    }

    public int consultarCantidadLibros() {
        return repository.consultarCantidadLibros();
    }

    public List<Libro> obtenerLibros() {
        return repository.obtenerLibros();
    }

    public Libro buscarLibroPorId(int id) {
        return repository.buscarLibroPorId(id);
    }

    public boolean eliminarLibroPorId(int id) {
        return repository.eliminarLibroPorId(id);
    }

    public boolean actualizarLibro(
            int id,
            String nuevoTitulo,
            String nuevoAutor,
            int nuevoAnio) {

        Libro libro = buscarLibroPorId(id);

        if (libro == null) {
            return false;
        }

        libro.setTitulo(nuevoTitulo);
        libro.setAutor(nuevoAutor);
        libro.setAnio(nuevoAnio);

        return true;
    }

    public boolean prestarLibro(int id) {

        Libro libro = buscarLibroPorId(id);

        if (libro == null) {
            return false;
        }

        return libro.prestar();
    }

    public boolean devolverLibro(int id) {
        Libro libro = buscarLibroPorId(id);

        if (libro == null) {
            return false;
        }

        return libro.devolver();
    }

    public boolean existeLibro(Libro libro) {
    return repository.existeLibro(libro);
    }   
}