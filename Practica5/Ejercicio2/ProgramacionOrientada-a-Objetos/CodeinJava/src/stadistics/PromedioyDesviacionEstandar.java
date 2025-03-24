package stadistics;
import java.util.Scanner;
public class PromedioyDesviacionEstandar {
	private double[] numeros;

	public PromedioyDesviacionEstandar(double[] numeros) {
        this.numeros = numeros;
    }

    public double promedio() {
        double suma = 0;
        for (double numero : numeros) {
            suma += numero;
        }
        return suma / numeros.length;
    }

    public double desviacion() {
        double promedio = promedio();
        double sumaCuadrados = 0;
        for (double numero : numeros) {
            sumaCuadrados += Math.pow(numero - promedio, 2);
        }
        return Math.sqrt(sumaCuadrados / (numeros.length - 1));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Laboratorio 1");
        System.out.println("Ejercicio 2: ");
        System.out.println("Programación Orientada a Objetos: ");
        System.out.println("Este Programa resuelve y calcula el Promedio y la Desviación Estándar:");
        System.out.print("Ingrese la cantidad de números (n): ");
        int n = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer
        if (n < 2) {
            System.out.println("Debe ingresar al menos 2 números para calcular la desviación estándar.");
            scanner.close();
            return;
        }
        System.out.print("Ingrese los " + n + " números: ");
        String entrada = scanner.nextLine();
        String[] partes = entrada.split(" ");
        if (partes.length != n) {
            System.out.println("Debe ingresar exactamente " + n + " números.");
            scanner.close();
            return;
        }
        double[] numeros = new double[n];
        for (int i = 0; i < n; i++) {
            try {
                numeros[i] = Double.parseDouble(partes[i]);
            } catch (NumberFormatException e) {
                System.out.println("¡Error! '" + partes[i] + "' no es un número válido.");
                scanner.close();
                return;
            }
        }
        PromedioyDesviacionEstandar pyde = new PromedioyDesviacionEstandar(numeros);
        System.out.printf("El Promedio es: %.2f%n", pyde.promedio());
        System.out.printf("La Desviación Estándar es: %.5f%n", pyde.desviacion());
        scanner.close();
    }
}
