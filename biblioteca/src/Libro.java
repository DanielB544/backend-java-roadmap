import java.time.LocalDate;
import java.util.Objects;

public class Libro {

    private int id;
    private String titulo;
    private String autor;
    private int anio;
    private boolean disponible;

    private static final int ANIO_ACTUAL = LocalDate.now().getYear();

    // Constructor vacío
    public Libro() {
    }

    // Constructor completo
    public Libro(int id, String titulo, String autor, int anio, boolean disponible) {
        this.id = id;
        setTitulo(titulo);
        setAutor(autor);
        setAnio(anio);
        this.disponible = disponible;
    }

    // Constructor básico
    public Libro(int id, String titulo, String autor) {
        this(id, titulo, autor, 0, true);
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public int getAnio() {
        return anio;
    }

    public boolean isDisponible() {
        return disponible;
    }

    // Setters
    public void setTitulo(String titulo) {

        if (titulo == null || titulo.isBlank() || titulo.length() > 100) {
            throw new IllegalArgumentException(
                    "El título no puede ser nulo, vacío ni tener más de 100 caracteres"
            );
        }

        this.titulo = titulo;
    }

    public void setAutor(String autor) {

        if (autor == null || autor.isBlank() || autor.length() > 100) {
            throw new IllegalArgumentException(
                    "El autor no puede ser nulo, vacío ni tener más de 100 caracteres"
            );
        }

        this.autor = autor;
    }

    public void setAnio(int anio) {

        if (anio < 0 || anio > ANIO_ACTUAL) {
            throw new IllegalArgumentException(
                    "El año debe estar entre 0 y " + ANIO_ACTUAL
            );
        }

        this.anio = anio;
    }

    // Prestar libro
    public boolean prestar() {

        if (!disponible) {
            return false;
        }

        disponible = false;
        return true;
    }

    // Devolver libro
    public boolean devolver() {

        if (disponible) {
            return false;
        }

        disponible = true;
        return true;
    }

    // Representación del libro
    @Override
    public String toString() {
        return "ID: " + id + "\n"
                + "Título: " + titulo + "\n"
                + "Autor: " + autor + "\n"
                + "Año: " + anio + "\n"
                + "Disponible: " + (disponible ? "Sí" : "No") + "\n";
    }

    // Igualdad lógica
    @Override
    public boolean equals(Object o) {

        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Libro libro = (Libro) o;

        return Objects.equals(titulo, libro.titulo)
                && Objects.equals(autor, libro.autor);
    }

    // Hash compatible con equals()
    @Override
    public int hashCode() {
        return Objects.hash(titulo, autor);
    }
}