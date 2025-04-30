package interf;
import java.util.Random;
public class Aplication {
	public static void main(String[] args) {
		Random random = new Random();
        Figura[] figuras = new Figura[5];
        
        // Crear 5 figuras aleatorias
        for (int i = 0; i < figuras.length; i++) {
            int tipo = random.nextInt(2) + 1; // 1-Cuadrado, 2-Circulo
            double dimension = random.nextDouble() * 10 + 1; // Entre 1 y 11
            
            if (tipo == 1) {
                figuras[i] = new Cuadrado(dimension, "Rosado");
            } else {
                figuras[i] = new Circulo(dimension, "Cafe");
            }
        }
        
        // Mostrar información de cada figura
        for (Figura figura : figuras) {
            System.out.println("---------------------");
            System.out.println(figura);
            System.out.printf("Área: %.2f\n", figura.area());
            System.out.printf("Perímetro: %.2f\n", figura.perimetro());
            
            if (figura instanceof Coloreado) {
                Coloreado coloreado = (Coloreado) figura;
                System.out.println(coloreado.comoColorear());
            }
        }
	}

}
