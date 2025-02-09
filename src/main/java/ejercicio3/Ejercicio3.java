package ejercicio3;


import java.util.Scanner;

public class Ejercicio3 {
    public static void main(String[] args) {
        boolean validate = false;
        int idioma = 0;
        String nuevaPalabra = "";
        //Habilitamos la opcion de leer la palabra que introduzca
        Scanner scanner = new Scanner(System.in);

        System.out.println("Introduce una palabra");

        String palabra = scanner.nextLine().toLowerCase().trim();
        char ultimaLetra = palabra.charAt(palabra.length() - 1);


        while (!validate) {
            System.out.println("Selecione un idioma:");
            System.out.println("1. Aleman");
            System.out.println("2. Bulgaro");
            System.out.println("Solo son validos 1 o 2 como opcion");
            int opcion = scanner.nextInt();
            idioma = switch (opcion) {
                case 1 -> 1;
                case 2 -> 2;
                default -> idioma;
            };
            if(idioma != 0){
                validate = true;
            }

        }

        if (isVocal(ultimaLetra)) {
            if(idioma == 1) {
                nuevaPalabra = subString(palabra,0 ,palabra.length() - 1);
                nuevaPalabra += "ujem";
            } else nuevaPalabra = palabra + "kov";

        } else {
            if(idioma == 2) {
                nuevaPalabra = subString(palabra,0 ,palabra.length() - 1);
                nuevaPalabra += "kov";
            } else {
                nuevaPalabra = subString(palabra,0 ,palabra.length() - 2);
                nuevaPalabra += "ujem";
            }
        }

        System.out.println("La palabra traducida es " + nuevaPalabra);
    }
    public static boolean isVocal(char letra) {
        switch (letra) {
            case 'a', 'e', 'i', 'o', 'u': return true;
            default: return false;
        }

    }
    public static String subString(String palabra, int posicionInicial, int numeroLetra) {

        return palabra.substring(posicionInicial, posicionInicial + numeroLetra);
    }
}
