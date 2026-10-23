package com.daniel.biblioteca;

import java.sql.SQLException;
import java.util.List;

public class BibliotecaService {

    private final BibliotecaRepository repository;

    public BibliotecaService(BibliotecaRepository repository) {
        this.repository = repository;
    }

    
    public Libro agregarLibro(Libro libro) throws SQLException {
        if(repository.existeLibro(libro)){
            return null;
        }
            return repository.agregarLibro(libro);
    }

    public int consultarCantidadLibros() throws SQLException {
        return repository.consultarCantidadLibros();
    }

    public List<Libro> obtenerLibros() throws SQLException {
        return repository.obtenerLibros();
    }

    public Libro buscarLibroPorId(int id) throws SQLException{
        return repository.buscarLibroPorId(id);
    }

    public boolean eliminarLibroPorId(int id) throws SQLException{
        return repository.eliminarLibroPorId(id);
    }

    
    public boolean actualizarLibro(
            int id,
            String nuevoTitulo,
            String nuevoAutor,
            int nuevoAnio) throws SQLException {

        Libro libro = buscarLibroPorId(id);

        if (libro == null) {
            return false;
        }

        libro.setTitulo(nuevoTitulo);
        libro.setAutor(nuevoAutor);
        libro.setAnio(nuevoAnio);

        return repository.actualizarLibro(libro);
    }


    public boolean prestarLibro(int id) throws SQLException {
        Libro libro = buscarLibroPorId(id);

        if (libro == null) {
            return false;
        }

        if (!libro.prestar()) {
            return false;
        }

        return repository.actualizarLibro(libro);
    }

    public boolean devolverLibro(int id) throws SQLException {
        Libro libro = buscarLibroPorId(id);

        if (libro == null) {
            return false;
        }
            if (!libro.devolver()) {
        return false;
    }

    return repository.actualizarLibro(libro);

    }
    
    
    public boolean existeLibro(Libro libro) throws SQLException {
    return repository.existeLibro(libro);
    }   
}