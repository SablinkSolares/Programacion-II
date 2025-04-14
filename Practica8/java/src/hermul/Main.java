package hermul;

public class Main {
    public static void main(String[] args) {
        D u = new D(1, 2, 3);
        System.out.println("Herencia Multiple en POO con Interfaces");
        System.out.println("Incrementar 3 Numeros");
        System.out.println("\nValores iniciales: x=" + u.x + ", y=" + u.getY() + ", z=" + u.z);
        System.out.println();
        u.incrementaYZ(); 
        System.out.println("Después de incrementaYZ(): x=" + u.x + ", y=" + u.getY() + ", z=" + u.z);
        System.out.println();
        u.incrementaXYZ();
        System.out.println("Después de incrementaXYZ(): x=" + u.x + ", y=" + u.getY() + ", z=" + u.z);
        System.out.println();
        u.incrementaXZ();
        System.out.println("Después de incrementaXZ(): x=" + u.x + ", y=" + u.getY() + ", z=" + u.z);
        System.out.println();
        u.incrementaZ();
        System.out.println("Después de incrementaZ(): x=" + u.x + ", y=" + u.getY() + ", z=" + u.z);
        System.out.println();
        System.out.println();
    }
}
