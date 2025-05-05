package climageo;

public class Distribucion {
    private String region;
    private String[] barreras;
    private boolean historico;
    private int añosEstudio;
    
    public Distribucion() {
        this.region = "";
        this.barreras = new String[0];
        this.historico = false;
        this.añosEstudio = 0;
    }
    
    
    public String obtenerRegion() { 
    	return region; 
    }
    
    public void fijarRegion(String region) { 
    	this.region = region; 
    }
    
    public String[] obtenerBarreras() { 
    	return barreras; 
    }
    
    public void fijarBarreras(String[] barreras) { 
    	this.barreras = barreras; 
    }
    
    public boolean esHistorico() { 
    	return historico; 
    }
    
    public void marcarComoHistorico(boolean historico) { 
    	this.historico = historico; 
    }
    
    public int obtenerAñosEstudio() { 
    	return añosEstudio; 
    }
    
    public void establecerAñosEstudio(int añosEstudio) { 
    	this.añosEstudio = añosEstudio; 
    }
    
    
    public void analizarDispersionVegetal(Planta planta, Ambiente ambiente) {
        if (ambiente.verificarHabitadPara(planta)) {
            if (barreras == null || barreras.length < 3) {
                System.out.println(planta.obtenerNombre() + " puede dispersarse en " + region);
            } else {
                System.out.println("Dispersión limitada para " + planta.obtenerNombre() + " en " + region);
            }
        } else {
            System.out.println("Ambiente no habitable para " + planta.obtenerNombre());
        }
    }
    
    public String listarBarrerasExistentes() {
        if (barreras == null || barreras.length == 0) {
            return "No hay barreras significativas";
        }
        
        String resultado = "Barreras presentes: ";
        for (int i = 0; i < barreras.length; i++) {
            resultado += barreras[i];
            if (i < barreras.length - 1) {
                resultado += ", ";
            }
        }
        return resultado;
    }
    
    
    public void visualizarInformacionDistribucion() {
        System.out.println("Región: " + region);
        System.out.print("Barreras: [");
        if (barreras != null) {
            for (int i = 0; i < barreras.length; i++) {
                System.out.print(barreras[i]);
                if (i < barreras.length - 1) {
                    System.out.print(", ");
                }
            }
        }
        System.out.println("]");
        System.out.println("Estudio histórico: " + (historico ? "Sí" : "No"));
        System.out.println("Años de estudio: " + añosEstudio);
    }
    
    public void registrarDatosDistribucion(String region, String[] barreras, boolean historico, int años) {
        this.region = region;
        this.barreras = barreras;
        this.historico = historico;
        this.añosEstudio = años;
    }
}

