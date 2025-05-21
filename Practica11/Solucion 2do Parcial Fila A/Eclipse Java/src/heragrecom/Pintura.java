package heragrecom;

public class Pintura extends Obra {
    public String genero;
    
    public Pintura(String t, String m, String g, Artista a1, Artista a2, Anuncio b) {
        super(t, m, a1, a2, b);
        this.genero = g;
    }
    
    public static double totalVentas(Pintura pca, Pintura psa) {
        double to = 0;
        if (pca.b != null) to += pca.b.precio;
        if (psa.b != null) to += psa.b.precio;
        return to;
    }
}


