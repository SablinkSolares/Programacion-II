package estadistica;
import java.util.Scanner;
public class DesviacionEstandaryPromedio {

    public static float promedio(float[] numeros) {
        float suma = 0;
        for (float numero : numeros) {
            suma += numero;
        }
        return suma / numeros.length;
    }

    public static double desviacion(float[] numeros, float promedio) {
        float sumaCuadrados = 0;
        for (float numero : numeros) {
            sumaCuadrados += Math.pow(numero - promedio, 2);
        }
        return Math.sqrt(sumaCuadrados / (numeros.length - 1));
    }

    public static void calcularEstadisticas(Scanner scanner) {
        System.out.println("Laboratorio 1");
        System.out.println("Ejercicio 2: ");
        System.out.println("Programación Modular: ");
        System.out.println("Este Programa resuelve y calcula el Promedio y la Desviación Estándar:");
        System.out.print("Ingrese la cantidad de números (n): ");
        int n = scanner.nextInt();
        scanner.nextLine();
        if (n < 2) {
            System.out.println("Debe ingresar al menos 2 números para calcular la desviación estándar.");
            return;
        }
        System.out.print("Ingrese los " + n + " números: ");
        String entrada = scanner.nextLine();
        String[] partes = entrada.split(" ");
        if (partes.length != n) {
            System.out.println("Debe ingresar exactamente " + n + " números.");
            return;
        }
        float[] numeros = new float[n];
        for (int i = 0; i < n; i++) {
            try {
                numeros[i] = Float.parseFloat(partes[i]);
            } catch (NumberFormatException e) {
                System.out.println("¡Error! '" + partes[i] + "' no es un número válido.");
                return;
            }
        }
        float promedio = promedio(numeros);
        double desviacion = desviacion(numeros, promedio);
        System.out.printf("El Promedio es: %.2f%n", promedio);
        System.out.printf("La Desviación Estándar es: %.5f%n", desviacion);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        calcularEstadisticas(scanner);
        scanner.close();
    }
}