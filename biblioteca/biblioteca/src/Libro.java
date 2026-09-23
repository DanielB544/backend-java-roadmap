import java.time.LocalDate;
import java.util.Objects;
public class Libro {
    private int id;
    private String titulo;
    private String autor;
    private int anio;
    private boolean disponible;

    int anioActual = LocalDate.now().getYear();
    
    public Libro(){
    }

    public Libro(int id, String titulo, String autor, int anio, boolean disponible){
        this.id = id;
        setTitulo(titulo);
        setAutor(autor);
        setAnio(anio);
        this.disponible = disponible;
    }

    public Libro(int id, String titulo, String autor){
        this(id,titulo,autor,0 , true);
    }

    @Override
    public String toString(){
        return  "ID: " + this.id + "\n" + 
                "Título : " + this.titulo + "\n" + 
                "Autor: " + this.autor + "\n" +
                "Año: " + this.anio + "\n" +
                "Disponible: " + (this.disponible ? "Sí" : "No") + "\n";

    }

    public int getId(){
        return this.id;    
    }

    public String getTitulo(){
        return this.titulo;    
    }

    public void setTitulo(String titulo){
        if(titulo == null || titulo.isBlank() || titulo.length()<=0 || titulo.length()>100){
            throw new IllegalArgumentException("El título no puede ser nulo o vacío");
        }
        this.titulo = titulo;    
    }

    public String getAutor(){
        return this.autor;    
    }
    
    public void setAutor(String autor){
        if(autor == null || autor.isBlank()|| autor.length()<=0 || autor.length()>100){
            throw new IllegalArgumentException("El autor no puede ser nulo o vacío");
        }
        this.autor = autor;    
    }

    public int getAnio(){
        return this.anio;    
    }

    public void setAnio(int anio){
        if(anio<0 || anio>anioActual){
            throw new IllegalArgumentException("El año debe ser un número positivo y no mayor al año actual");
        }
        this.anio = anio;    
    }

    public boolean isDisponible(){
        return this.disponible;
    }

    public boolean prestar() {

        if (this.disponible == true) {
            this.disponible = false;
            return true;
        }

        return false;
    }

    public boolean devolver(){
        if (this.disponible == false) {
            this.disponible = true;
            return this.disponible;
        }

        return true;
    }

    @Override 
    public boolean equals(Object o){
        if (this == o) return true;

        if (o == null) return false;

        if (getClass() != o.getClass()) return false;

        Libro libro = (Libro) o;

        if (this.titulo.equals(libro.titulo) && this.autor.equals(libro.autor)) return true;
        
        return false;
    }

    @Override 
    public int hashCode(){
        return Objects.hash(titulo,autor);
    }


}
