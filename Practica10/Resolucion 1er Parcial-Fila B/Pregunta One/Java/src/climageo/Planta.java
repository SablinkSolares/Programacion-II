package climageo;

public class Planta {
    private String nombre;
    private String familia;
    private String periodoVida;
    private boolean produceSemillas;
    
    public Planta() {
        this.nombre = "";
        this.familia = "";
        this.periodoVida = "";
        this.produceSemillas = false;
    }
    
    public String obtenerNombre() { 
    	return nombre; 
    }
    
    public void establecerNombre(String nombre) { 
    	this.nombre = nombre;
    }
    
    public String obtenerFamilia() { 
    	return familia; 
    }
    
    public void establecerFamilia(String familia) { 
    	this.familia = familia; 
    }
    
    public String obtenerPeriodoVida() { 
    	return periodoVida; 
    }
    
    public void establecerPeriodoVida(String periodoVida) { 
    	this.periodoVida = periodoVida; 
    }
    
    public boolean produceSemillas() { 
    	return produceSemillas; 
    }
    
    public void configurarProduccionSemillas(boolean produceSemillas) { 
    	this.produceSemillas = produceSemillas; 
    }
    
    
    public void realizarPolinizacion() {
        System.out.println("La planta " + nombre + " está siendo polinizada.");
    }
    
    public boolean generarSemillas() {
        if (produceSemillas) {
            System.out.println(nombre + " está produciendo semillas.");
            return true;
        }
        return false;
    }
    
   
    public void imprimirDetallesPlanta() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Familia: " + familia);
        System.out.println("Periodo de Vida: " + periodoVida);
        System.out.println("Produce Semillas: " + (produceSemillas ? "Sí" : "No"));
    }
    
    public void cargarDatosPlanta(String nombre, String familia, String periodoVida, boolean semillas) {
        this.nombre = nombre;
        this.familia = familia;
        this.periodoVida = periodoVida;
        this.produceSemillas = semillas;
    }
}