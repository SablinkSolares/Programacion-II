package Algebra;
import java.util.Scanner;
public class EcuacionCuadratica {
	public double a;
    public double b;
    public double c;

    public EcuacionCuadratica(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    
    public double getDiscriminante() {
        return Math.pow(b, 2) - 4 * a * c;
    }

    public double getRaiz1() {
        double d = getDiscriminante();
        if (d < 0) {
            System.out.println("El discriminante es negativo, no hay raíces reales.");
        }
        return (-b + Math.sqrt(d)) / (2 * a);
    }

    public double getRaiz2() {
        double d = getDiscriminante();
        if (d < 0) {
            System.out.println("El discriminante es negativo, no hay raíces reales.");
        }
        return (-b - Math.sqrt(d)) / (2 * a);
    }

    public void resolver() {
        double d = getDiscriminante();
        if (d > 0) {
            System.out.println("El Discriminante es Positivo (d>0), la Ecuación tiene 2 Soluciones o Raíces en los Números Reales.");
            double r1 = getRaiz1();
            double r2 = getRaiz2();
            System.out.println("r1 = " + r1);
            System.out.println("r2 = " + r2);
        } 
        else if (d == 0) {
            System.out.println("El Discriminante es 0 (d=0), la Ecuación tiene 1 Solución o Raíz en los Números Reales.");
            double x = getRaiz1();
            System.out.println("x = " + x);
        } 
        else {
            System.out.println("El Discriminante es Negativo (d<0), la Ecuación NO tiene Solución(es) o Raíces en los Números Reales.");
        }
    }

    public static void main(String[] args) {
        System.out.println("Laboratorio 1");
        System.out.println("Práctica 5: ");
        System.out.println("Programación Orientada a Objetos: ");
        System.out.println("Ejercicio 1");
        System.out.println("Este Programa resuelve la Ecuación Cuadrática de la Forma...");
        System.out.println("...ax²+bx+c=0 usando la Fórmula General.");
        double a = leerCoeficiente("a");
        if (a == 0) {
            System.out.println("Como a = 0, la División entre Cero NO existe en los Números Reales.");
        } 
        else {
            double b = leerCoeficiente("b");
            double c = leerCoeficiente("c");
            EcuacionCuadratica equation = new EcuacionCuadratica(a, b, c);
            equation.resolver();
        }
    }

    public static double leerCoeficiente(String coeficiente) {
        Scanner uma = new Scanner(System.in);
        System.out.print("Coeficiente " + coeficiente + " = ");
        return uma.nextDouble();
    }
}
