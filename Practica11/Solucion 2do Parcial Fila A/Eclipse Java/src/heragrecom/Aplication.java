package heragrecom;

public class Aplication {
    public static void main(String[] args) {
    	System.out.println("Fila A-Ejercicio 1");
    	System.out.println("Herencia-Agregacion-Composicion:");
    	System.out.println();
        Artista a1 = new Artista("Mamani Mamani", "28461946", 10);
        Artista a2 = new Artista("Leonardo Da Vinci", "19735468", 30);
        Anuncio b1 = new Anuncio(1, 2000);
        Pintura pca = new Pintura("El Condor y la Chakana", "Pintura Acrilica", "Simbolismo Andino", a1, null, b1);
        Pintura psa = new Pintura("Salvator Mundi", "Oleo sobre Nogal", "Pintura Religiosa", a2, null, null);
        String artmasexp = Obra.masAñoExp(pca, psa);
        System.out.println("Artista con mas Años de Experiencia: " + artmasexp);
        Anuncio b2 = new Anuncio(1,5000);
        psa.b = b2;
        double tl = Pintura.totalVentas(pca, psa);
        System.out.println("El Total de Ventas de: $" + tl);
    }
}


