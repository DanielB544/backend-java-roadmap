public class App {

    public static void main(String[] args) throws Exception {

        // Crear libros
        Libro libro1 = new Libro(1, "Hobbit", "J.R.R. Tolkien", 0, true);
        Libro libro2 = new Libro(2, "Clean Code", "Robert C. Martin", 2008, true);
        Libro libro3 = new Libro(3, "1984", "George Orwell");

        // Probar préstamo y devolución
        libro1.prestar();
        libro1.devolver();

        // Mostrar libro
        System.out.println(
            "ID: " + libro1.getId() + "\n" +
            "Título: " + libro1.getTitulo() + "\n" +
            "Autor: " + libro1.getAutor() + "\n" +
            "Año: " + libro1.getAnio() + "\n" +
            "Disponible: " + (libro1.isDisponible() ? "Sí" : "No") + "\n"
        );

        // Modificar datos mediante setters
        libro1.setTitulo("El Hobbit: Un viaje inesperado");
        libro1.setAutor("J.R.R. Tolkien");
        libro1.setAnio(1937);

        // Mostrar libro después de modificarlo
        System.out.println(
            "ID: " + libro1.getId() + "\n" +
            "Título: " + libro1.getTitulo() + "\n" +
            "Autor: " + libro1.getAutor() + "\n" +
            "Año: " + libro1.getAnio() + "\n" +
            "Disponible: " + (libro1.isDisponible() ? "Sí" : "No") + "\n"
        );

        // Usar toString()
        System.out.println(libro1);
        System.out.println(libro2);
        System.out.println(libro3);

        // Crear biblioteca
        Biblioteca biblioteca = new Biblioteca();

        // Agregar libros a la biblioteca
        biblioteca.agregarLibro(libro1);
        biblioteca.agregarLibro(libro2);
        biblioteca.agregarLibro(libro3);

        // Consultar cantidad de libros en la biblioteca
        System.out.println("Cantidad de libros en la biblioteca: " + biblioteca.consultarCantidadLibros());
    
            
        //Recorrer la lista de libros y mostrar sus detalles
        for (Libro libro : biblioteca.obtenerLibros()) {
            System.out.println(libro);
        }

        //Buscar libro 2
        System.out.println("Se esta buscando el libro 2");
        Libro libroEncontrado = biblioteca.buscarLibroPorId(2);

        if (libroEncontrado == null){
            System.out.println("El libro con el Id ingresado no existe");
        }else{
            System.out.println(libroEncontrado);
        }

        //Buscar libro 99
        System.out.println("Se esta buscando el libro 99");
        Libro libroEncontrado2 = biblioteca.buscarLibroPorId(99);

        if (libroEncontrado2 == null){
            System.out.println("El libro con el Id ingresado no existe\n");
        }else{
            System.out.println(libroEncontrado2);
        }

        //Eliminar libro
        Libro libroEliminar2 = biblioteca.buscarLibroPorId(99);
        
        if (libroEliminar2 == null){

            System.out.println("El libro no existe");

        }else{
            System.out.println("\nPrimer libro a eliminar \n\n" + libroEliminar2);
                
            if(biblioteca.eliminarLibroPorID(libroEliminar2.getId())){
                    
                System.out.println("Libro Eliminado");

            }else{
                System.out.println("No se pudo eliminar el libro");
            }
        }



        //Libro libroEliminar99 = biblioteca.buscarLibroPorId(99);
        //System.out.println("Segundo libro a eliminar " + libroEliminar99);
    }
}