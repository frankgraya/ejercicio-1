import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;
public class Main {

    //Ejercicio 1. - Lógica
    //Dada una frase escrita por el usuario, En un nuevo proyecto de java realice lo siguiente:
    //1.	Ordene las palabras por el peso de sus letras de forma ascendente.
    //Por ejemplo, a la letra “a” se le asignará el valor 1, a la letra “b” el valor 2. etc.
    //Si el usuario ingresa la frase “Juan canta”, la salida esperada del ejercicio será
    //Canta = 40
    //Juan = 47
    //2.	Imprima la respuesta en consola.
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese una frase: ");
        String frase = scanner.nextLine();
        ordenarPalabras(frase);
        scanner.close();
    }

    public static void ordenarPalabras(String frase) {
        Map<String, Integer> pesosPalabras = new HashMap<>();
        String[] palabras = frase.split(" ");
        // Creamos un mapa que asocia cada palabra con su peso

        for (String palabra : palabras) {
            int peso = 0;
            for (char letra : palabra.toLowerCase().toCharArray()) {
                peso += letra - 'a' + 1;
            }
            pesosPalabras.put(palabra, peso);
            // Calculamos el peso de cada palabra sumando los pesos de sus letras
        }

        String[] palabrasOrdenadas = Arrays.stream(palabras)
                .sorted(Comparator.comparingInt(pesosPalabras::get))
                .toArray(String[]::new);
        // Ordenamos las palabras según su peso

        for (String palabra : palabrasOrdenadas) {
            System.out.println(palabra.substring(0, 1).toUpperCase() + palabra.substring(1) + " = " + pesosPalabras.get(palabra));
            // Imprimimos cada palabra con su peso en consola
        }
    }
}