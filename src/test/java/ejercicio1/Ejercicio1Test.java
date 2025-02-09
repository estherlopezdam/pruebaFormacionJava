package ejercicio1;

import org.junit.jupiter.api.Test;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class Ejercicio1Test {


    @Test
    void testValoresEstadisticas() throws IOException {

        File tempFile = File.createTempFile("testDatos", ".txt");
        FileWriter writer = new FileWriter(tempFile);
        writer.write("3, 5, 7, 5, 7, 2"); // Datos de prueba
        writer.close();


        int[] resultado = Ejercicio1.valoresEstadisticas(tempFile);


        assertNotNull(resultado, "El resultado no debe ser null");
        assertEquals(7, resultado[0], "El máximo debe ser 7");
        assertEquals(2, resultado[1], "El mínimo debe ser 2");
        assertEquals(4, resultado[2], "La media debe ser 4 (promedio de 3,5,7,5,7,2)");
        assertEquals(2, resultado[3], "El número máximo (7) aparece 2 veces");
    }
}
