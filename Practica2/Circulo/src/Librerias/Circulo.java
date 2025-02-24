package Librerias;
import java.lang.Math;
class Punto {
    public float x;
    public float y;

    public Punto(float x,float y) {
        this.x = x;
        this.y = y;
    }

    public float[] coordCartesianas() {
        return new float[]{this.x, this.y};
    }

    public float[] coordPolares() {
        float r =(float) Math.sqrt(this.x * this.x + this.y * this.y);
        float theta =(float) Math.atan2(this.y, this.x);
        return new float[]{r, theta};
    }

    @Override
    public String toString() {
        return "Punto(" + this.x + "," + this.y + ")";
    }
}
public class Circulo {
	public Punto centro;
    public float radio;

    public Circulo(Punto centro, float radio) {
        this.centro = centro;
        this.radio = radio;
    }

    @Override
    public String toString() {
        return "Circulo(centro=" + this.centro.toString() + ",radio=" + this.radio + ")";
    }
    public void dibujarCirculo() {
        for (int i = (int) -this.radio; i <= this.radio; i++) {
            for (int j = (int) -this.radio; j <= this.radio; j++) {
                if (Math.sqrt(i * i + j * j) <= this.radio) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
		public static void main(String[] args) {
		Punto p = new Punto(1, 2);
        Circulo c = new Circulo(p, 6);

        System.out.println(p.toString());
        System.out.println(c.toString());

        System.out.println("Dibujando círculo:");
        c.dibujarCirculo();
	}

}
