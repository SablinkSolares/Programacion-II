package figubits;
public class FigurasGeometricasu {
	// Método para calcular el área de un círculo
    double area(double radio) {
        return (float) Math.PI * radio * radio;
    }
    // Método para calcular el área de un rectángulo
    double area(double base, double altura) {
        return base * altura;
    }
    // Método para calcular el área de un triángulo rectángulo
    double area(float base,double altura) {
        return(double)0.5 * base * altura;
    }
    // Método para calcular el área de un trapecio
    double area(double baseMayor, double baseMenor, double altura) {
        return ((baseMayor + baseMenor) / 2) * altura;
    }
    // Método para calcular el área de un hexágono
    double area(float lado) {
        return (6 *lado*lado*Math.sqrt(3)/4);
    }
	public static void main(String[] args) {
		FigurasGeometricasu figura1= new FigurasGeometricasu();
		FigurasGeometricasu figura2 = new FigurasGeometricasu();
        FigurasGeometricasu figura3 = new FigurasGeometricasu();
        FigurasGeometricasu figura4 = new FigurasGeometricasu();
        FigurasGeometricasu figura5 = new FigurasGeometricasu();
        // Calcular y mostrar el área de cada figura
        System.out.println("Area de un Circulo: " + figura1.area(5.0));
        System.out.println("Area de un Rectangulo: " + figura2.area(7.0,6.0));
        System.out.println("Area de un Triangulo Rectangulo: " + figura3.area(9,8));
        System.out.println("Area de un Trapecio: " + figura4.area(1,2,3));
        System.out.println("Area de un Hexagono: " + figura5.area(6));
	}

}

