package ejercicio3;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class Ejercicio3Test {

    @Test
    void testIsVocal() {
        assertTrue(Ejercicio3.isVocal('a'), "'a' debe ser vocal");
        assertTrue(Ejercicio3.isVocal('e'), "'e' debe ser vocal");
        assertTrue(Ejercicio3.isVocal('i'), "'i' debe ser vocal");
        assertTrue(Ejercicio3.isVocal('o'), "'o' debe ser vocal");
        assertTrue(Ejercicio3.isVocal('u'), "'u' debe ser vocal");
        assertFalse(Ejercicio3.isVocal('b'), "'b' NO debe ser vocal");
        assertFalse(Ejercicio3.isVocal('z'), "'z' NO debe ser vocal");
    }

    @Test
    void testSubString() {
        assertEquals("hola", Ejercicio3.subString("holanda", 0, 4), "Debe devolver 'hola' de 'holanda'");
        assertEquals("java", Ejercicio3.subString("java", 0, 4), "Debe devolver 'java' de 'java'");
        assertEquals("mun", Ejercicio3.subString("mundo", 0, 3), "Debe devolver 'mun' de 'mundo'");
        assertEquals("do", Ejercicio3.subString("mundo", 3, 2), "Debe devolver 'do' de 'mundo'");
    }

    @Test
    void testTransformacionPorIdioma() {
        String palabra = "casa";
        char ultimaLetra = palabra.charAt(palabra.length() - 1);
        boolean esVocal = Ejercicio3.isVocal(ultimaLetra);

        // Caso: Idioma 1 (Alemán)
        int idioma = 1;
        String nuevaPalabra;
        if (esVocal) {
            nuevaPalabra = palabra.substring(0, palabra.length() - 1) + "ujem";
        } else {
            nuevaPalabra = palabra.substring(0, palabra.length() - 2) + "ujem";
        }
        assertEquals("casujem", nuevaPalabra);

        // Caso: Idioma 2 (Búlgaro)
        idioma = 2;
        if (esVocal) {
            nuevaPalabra = palabra + "kov";
        } else {
            nuevaPalabra = palabra.substring(0, palabra.length() - 1) + "kov";
        }
        assertEquals("casakov", nuevaPalabra);
    }
}