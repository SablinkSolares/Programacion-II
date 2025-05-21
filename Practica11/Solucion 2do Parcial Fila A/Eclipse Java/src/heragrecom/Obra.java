package heragrecom;
import java.util.ArrayList;

public class Obra {
    public String titulo;
    public String material;
    public Artista a1;
    public Artista a2;
    public Anuncio b;
    
    public Obra(String t, String m, Artista a1, Artista a2, Anuncio b) {
        this.titulo = t;
        this.material = m;
        this.a1 = a1;
        this.a2 = a2;
        this.b = b;
    }
    
    public static String masAñoExp(Pintura pca, Pintura psa) {
        ArrayList<Artista> artistas = new ArrayList<>();
        
        if (pca.a1 != null) artistas.add(pca.a1);
        if (pca.a2 != null) artistas.add(pca.a2);
        if (psa.a1 != null) artistas.add(psa.a1);
        if (psa.a2 != null) artistas.add(psa.a2);
        
        if (artistas.isEmpty()) { 
            return "No hay Artistas...";
        }
        
        Artista masAñoExpu = artistas.get(0);
        for (Artista artista : artistas) {
            if (artista.añosExperiencia > masAñoExpu.añosExperiencia) {
                masAñoExpu = artista;
            }
        }
        
        return masAñoExpu.nombre;
    }
}

