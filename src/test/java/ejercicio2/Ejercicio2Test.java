package ejercicio2;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

class Ejercicio2Test {

    @Test
    void testComprobarPalindromo() {
        // Pruebas con palabras conocidas
        assertEquals("5", Ejercicio2.comprobarPalindromo("radar"), "La palabra 'radar' es un palíndromo de 5 letras");
        assertEquals("7", Ejercicio2.comprobarPalindromo("anilina"), "La palabra 'anilina' es un palíndromo de 7 letras");
        assertEquals("0", Ejercicio2.comprobarPalindromo("java"), "La palabra 'java' NO es un palíndromo");
    }

    @Test
    void testLeerPalabra() throws IOException {
        // Crear un archivo temporal con una palabra de prueba
        File tempFile = File.createTempFile("testPalindromo", ".txt");
        FileWriter writer = new FileWriter(tempFile);
        writer.write("Anilina "); // Palíndromo
        writer.close();

        // Leer la palabra desde el archivo
        String palabra = Ejercicio2.leerPalabra(tempFile);

        // Verificar que se leyó correctamente y está en minúsculas
        assertEquals("anilina", palabra, "Debe leer 'Anilina ' quitarle el espacio y convertirla en minúsculas");
    }
}