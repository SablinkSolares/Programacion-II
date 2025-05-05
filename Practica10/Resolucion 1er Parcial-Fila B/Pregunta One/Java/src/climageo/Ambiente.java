package climageo;

public class Ambiente {
    private double temperatura;
    private double humedad;
    private String tipoSuelo;
    private double altitud;
    
    public Ambiente() {
        this.temperatura = 0.0;
        this.humedad = 0.0;
        this.tipoSuelo = "";
        this.altitud = 0.0;
    }
    
   
    public double obtenerTemperatura() { 
    	return temperatura; 
    }
    
    public void fijarTemperatura(double temperatura) { 
    	this.temperatura = temperatura; 
    }
    
    public double obtenerHumedad() { 
    	return humedad; 
    }
    
    public void fijarHumedad(double humedad) { 
    	this.humedad = humedad; 
    }
    
    public String obtenerTipoSuelo() { 
    	return tipoSuelo; 
    }
    
    public void fijarTipoSuelo(String tipoSuelo) { 
    	this.tipoSuelo = tipoSuelo; 
    }
    
    public double obtenerAltitud() { 
    	return altitud; 
    }
    
    public void fijarAltitud(double altitud) { 
    	this.altitud = altitud; 
    }
    
    
    public boolean verificarHabitadPara(Planta planta) {
        if (temperatura > 0 && humedad > 20 && !tipoSuelo.isEmpty()) {
            System.out.println("Ambiente habitable para " + planta.obtenerNombre());
            return true;
        }
        return false;
    }
    
    public void ajustarCondicionesClimaticas(double nuevaTemp, double nuevaHumedad) {
        this.temperatura = nuevaTemp;
        this.humedad = nuevaHumedad;
        System.out.println("El clima ha cambiado: Temp=" + nuevaTemp + "°C, Humedad=" + nuevaHumedad + "%");
    }
    
    
    public void mostrarDatosAmbiente() {
        System.out.println("Temperatura: " + temperatura + " °C");
        System.out.println("Humedad: " + humedad + " %");
        System.out.println("Tipo de Suelo: " + tipoSuelo);
        System.out.println("Altitud: " + altitud + " m");
    }
    
    public void ingresarDatosAmbiente(double temp, double hum, String suelo, double alt) {
        this.temperatura = temp;
        this.humedad = hum;
        this.tipoSuelo = suelo;
        this.altitud = alt;
    }
}