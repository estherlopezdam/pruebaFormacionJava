package ejercicio1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ejercicio1 {
    public static void main(String[] args) {
        File file = new File("datos.txt");
        System.out.println("Buscando archivo en: " + file.getAbsolutePath());
        int[] estadisticas = valoresEstadisticas(file);
        if(estadisticas!=null){
            System.out.println("Numeros encontrados");
            System.out.println("MAX:"+estadisticas[0] + " MIN:" +estadisticas[1] + " MEDIA:" +estadisticas[2] + " Nº VECES MAX:" +estadisticas[3]);
        }
    }
    public static int [] valoresEstadisticas(File file){
        //int contador = 0;
        int suma = 0;
        int max = 0, min = 999999999;
        int repetidoMaxNum = 0;


        int[] numeros = leerNumerosDesdeArchivo(file);
        List<Integer> estadisticas = new ArrayList<>();
        // Si no se encontraron números, devolvemos null para evitar errores
        if (numeros == null || numeros.length == 0) {
            System.out.println("Error: No se encontraron números en el archivo.");
            return null;
        }
        for(int i = 0; i < numeros.length; i++){
           if (max < numeros[i]) { //si el numero es mayor que el max lo guardamos como nuevo max
               max = numeros[i];
               repetidoMaxNum = 1; // inicializo el primer numero max

            } else if(max == numeros[i]) {
               repetidoMaxNum++; // si son iguales sumo uno al repetido
           }
           if(min > numeros[i]){ //si el numero es mas pequeño que el min lo guardamos como nuevo min
               min = numeros[i];
           }
           suma += numeros[i]; //sumo todos los numeros para hacer la media
           //contador++;
        }
        //Añado las estadisticas
        estadisticas.add(max);
        estadisticas.add(min);
        estadisticas.add(suma / numeros.length);
        estadisticas.add(repetidoMaxNum);
      // estadisticas.add(suma / contador);
        //convierto las estadisticas en int[]
        return estadisticas.stream().mapToInt(i -> i).toArray();
    }

    //Metodo para leer los numeros desde el archivo
    public static int [] leerNumerosDesdeArchivo(File file) {
        List<Integer> listaNumeros = new ArrayList<>();

        try {
            Scanner scanner = new Scanner(file); //Aqui abrimos el archivo
            while (scanner.hasNextLine()) { //aqui hacemos un bucle para que lea el archivo linea por linea, si no hay mas lineas que leer sale del bucle
                String linea = scanner.nextLine();//leemos una linea completa
                String[] partes = linea.split(",");//Esto divide la linea que ha leido en bloques que esten separados por comas
                for (String num : partes) {
                    listaNumeros.add(Integer.parseInt(num.trim())); //Convierto a int los numeros del String[] y los añado a la lista
                }
            }
            scanner.close(); //cierro el lector del archivo
        } catch (FileNotFoundException e) {
            System.out.println("Error; archivo no encontrado");
            return null;
        } catch (NumberFormatException e) {
            System.out.println("Error:formato incorrecto en el archivo");
            return null;
        }
        //convierto y devuelvo la lista en int []
        int [] resultado = listaNumeros.stream().mapToInt(i -> i).toArray();
        System.out.println(resultado);
        return resultado;

    }
}
