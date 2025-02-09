package ejercicio2;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Ejercicio2 {
    public static void main(String[] args) {
        File file = new File("datosPalindromo.txt");
        System.out.println("Buscando archivo en: " + file.getAbsolutePath());
        if (leerPalabra(file).isEmpty()) {
            System.out.println("No se encontro archivo o esta vacio");
        } else {
            String palabra = leerPalabra(file);
            if (!comprobarPalindromo(palabra).equals("0")) {
                System.out.println("La palabra es un palindromo y tiene "  + comprobarPalindromo(palabra) + " letras");
            } else System.out.println("La palabra no es un Palindromo");
        }
    }

//aunque se podria hacer con stringbuilder y un reverse entiendo que como en el ejer anterior no quereis que usemos esas clases
    public static String comprobarPalindromo (String palabra) {
        int numeroLetras = palabra.length();
        boolean mach = true;
        for (int i = 0; i < numeroLetras/2 ; i++) {
            if (palabra.charAt(i) != palabra.charAt(numeroLetras-i-1)) {
                mach = false;
                break;
            }
        }
        if (mach) {
            return String.valueOf(numeroLetras);
        } else return "0";
    }
    public static String leerPalabra(File file){
        String palabra = "";
        try (FileReader reader = new FileReader(file)) {
            int codigoCaracter;
            while ((codigoCaracter = reader.read()) != -1) {
                char caracter = (char) codigoCaracter;
                if (!Character.isWhitespace(caracter)) { // Evita espacios, tabulaciones y saltos de línea
                    palabra += caracter;
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return palabra.toLowerCase();
    }

}
