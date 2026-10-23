package com.daniel.biblioteca;

import org.junit.Test;
import static org.junit.Assert.*;
import java.time.LocalDate;

public class LibroTest{
    
    @Test
    public void probarPrestarLibro(){
        Libro libroTest1 = new Libro(
            1,
            "El principito",
            "Un señor", 
            2026,
            true);

        boolean prestarLibroTest1 = libroTest1.prestar();

        assertTrue(prestarLibroTest1);
        assertFalse(libroTest1.isDisponible());
    }
    
    @Test
    public void probarPrestarLibroDosVeces(){
        Libro libroTest2 = new Libro (
            1,
            "El principito",
            "Un señor",
            2026,
            true);

        libroTest2.prestar();

        boolean prestarLibroDosVecesTest1 = libroTest2.prestar();
    
        assertFalse(prestarLibroDosVecesTest1);
        assertFalse(libroTest2.isDisponible());
    }

    @Test
    public void probarDevolverLibro(){
        Libro libroTest3 = new Libro(
            1,
            "El rey",
            "Otro señor",
            2025,
            false
        );

        boolean devolverLibroTest3 = libroTest3.devolver();

        assertTrue(devolverLibroTest3);
        assertTrue(libroTest3.isDisponible());
    }

    @Test
    public void probarDevolverLibroYaDisponible(){
        Libro libroTest4 = new Libro(
            1,
            "El rey",
            "Otro señor",
            2025,
            true
        );

        boolean devolverLibroTest4 = libroTest4.devolver();

        assertFalse(devolverLibroTest4);
        assertTrue(libroTest4.isDisponible());
    }

    @Test(expected = IllegalArgumentException.class)
    public void probarTituloVacio(){
        Libro libroTest5 = new Libro(
            1,
            "",
            "Otro señor",
            2025,
            true
        );

    }

    public static final int ANIO_ACTUAL = LocalDate.now().getYear();
    @Test(expected = IllegalArgumentException.class)
    public void probarAnioFuturo(){
        Libro libroTest6 = new Libro(
            1,
            "Libro 5",
            "Otro señor",
            2027,
            true
        );

        int anioLbro = libroTest6.getAnio();
        if (anioLbro < 0 || anioLbro > ANIO_ACTUAL) {
            throw new IllegalArgumentException(
                    "El año debe estar entre 0 y " + ANIO_ACTUAL
            );
        }
    }
}
