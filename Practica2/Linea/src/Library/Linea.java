package Library;
import java.lang.Math;
class Punto{
	public float x;
    public float y;

    public Punto(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public float[] coordCartesianas() {
        return new float[]{this.x,this.y};
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
public class Linea {
	public Punto p1;
    public Punto p2;
    public Linea(Punto p1, Punto p2) {
        this.p1 = p1;
        this.p2 = p2;
  }
    public String toString() {
        return "Linea(" + this.p1.toString() + "," + this.p2.toString() + ")";
    }
    public void dibujarLinea() {
        // Obtener coordenadas cartesianas
        float[] coords1 = this.p1.coordCartesianas();
        float[] coords2 = this.p2.coordCartesianas();
        float x1 = coords1[0];
        float y1 = coords1[1];
        float x2 = coords2[0];
        float y2 = coords2[1];

        // Determinar la dirección de la línea
        float dx = x2 - x1;
        float dy = y2 - y1;

        // Determinar el número de pasos
        float steps = Math.max(Math.abs(dx), Math.abs(dy));

        // Calcular incrementos
        float xInc = dx / steps;
        float yInc = dy / steps;

        // Dibujar la línea
        float x = x1;
        float y = y1;
        for (int i = 0; i <= steps; i++) {
            System.out.print("*");
            x += xInc;
            y += yInc;
        }
        System.out.println();
    }
	public static void main(String[] args) {
		Punto p1 = new Punto(1,1);
        Punto p2 = new Punto(20,1);
        Linea linea = new Linea(p1,p2);
        System.out.println(linea.toString());
        System.out.println();
        linea.dibujarLinea();	
	}
}
