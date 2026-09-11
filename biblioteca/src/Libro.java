public class Libro {

    private int id;
    private String titulo;
    private String autor;
    private int anio;
    private boolean disponible;

    public Libro() {
    }

    public Libro(int id, String titulo, String autor, int anio, boolean disponible) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.anio = anio;
        this.disponible = disponible;
    }

    public Libro(int id, String titulo, String autor) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.anio = 0;
        this.disponible = true;
    }

    public int getId() {
        return this.id;
    }

    public String getTitulo() {
        return this.titulo;
    }

    public String getAutor() {
        return this.autor;
    }

    public int getAnio() {
        return this.anio;
    }

    public boolean isDisponible() {
        return this.disponible;
    }

    public void prestar() {
        this.disponible = false;
    }

    public void devolver() {
        this.disponible = true;
    }
}