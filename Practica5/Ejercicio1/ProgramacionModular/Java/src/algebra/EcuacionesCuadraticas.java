package algebra;
import java.util.Scanner;
public class EcuacionesCuadraticas {

    public static void main(String[] args) {
        System.out.println("Laboratorio 1");
        System.out.println("Práctica 5: ");
        System.out.println("Programación Modular: ");
        System.out.println("Ejercicio 1");
        System.out.println("Este Programa resuelve la Ecuación Cuadrática de la Forma...");
        System.out.println("...ax²+bx+c=0 usando la Fórmula General.");
        double a = leerCoeficiente("a");
        if (a == 0) {
            System.out.println("Como a = 0, la División entre Cero NO existe en los Números Reales.");
        } else {
            double b = leerCoeficiente("b");
            double c = leerCoeficiente("c");
            resolverEcuacionCuadratica(a, b, c);
        }
    }
    public static double leerCoeficiente(String coeficiente) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Coeficiente " + coeficiente + " = ");
        return scanner.nextDouble();
    }

    public static void resolverEcuacionCuadratica(double a, double b, double c) {
        double discriminante = getDiscriminante(a, b, c);
        if (discriminante > 0) {
            System.out.println("El Discriminante es Positivo (d>0), la Ecuación tiene 2 Soluciones o Raíces en los Números Reales.");
            double r1 = getRaiz1(a, b, discriminante);
            double r2 = getRaiz2(a, b, discriminante);
            System.out.println("r1 = " + r1);
            System.out.println("r2 = " + r2);
        } else if (discriminante == 0) {
            System.out.println("El Discriminante es 0 (d=0), la Ecuación tiene 1 Solución o Raíz en los Números Reales.");
            double x = getRaizUnica(a, b);
            System.out.println("x = " + x);
        } else {
            System.out.println("El Discriminante es Negativo (d<0), la Ecuación NO tiene Solución(es) o Raíces en los Números Reales.");
        }
    }

    public static double getDiscriminante(double a, double b, double c) {
        return Math.pow(b, 2) - 4 * a * c;
    }

    public static double getRaiz1(double a, double b, double discriminante) {
        return (-b + Math.sqrt(discriminante)) / (2 * a);
    }

    public static double getRaiz2(double a, double b, double discriminante) {
        return (-b - Math.sqrt(discriminante)) / (2 * a);
    }

    public static double getRaizUnica(double a, double b) {
        return (-b) / (2 * a);
    }
}