package Librerias;
public class Punto {
	public float x;
	public float y;
	public Punto(float x,float y){
		this.x=x;
		this.y=y;
	}
	public float[] coord_cartesianas(){
		return new float[] {this.x,this.y};
	}
	public float[] coord_polares(){
		float radio=(float)Math.sqrt(this.x*this.x+this.y*this.y);
		float angulo=(float)Math.atan(this.y/this.y);
		angulo=(float) Math.toDegrees(angulo);
		return new float[] {radio,angulo};
		}
	public String toString(){
		return String.format("(%.2f,%.2f)",this.x,this.y);
	}
	public static void main(String[] args) {
		Punto p1=new Punto(3,5);
		System.out.println("Punto:");
		System.out.println(p1);
		float A[]=p1.coord_cartesianas();
		System.out.println("Coordenadas Cartesianas:");
		System.out.println("("+A[0]+","+A[1]+")");
		float B[]=p1.coord_polares();
		System.out.println("Coordenadas Polares:");
		System.out.println("("+B[0]+","+B[1]+")");
	}
}
