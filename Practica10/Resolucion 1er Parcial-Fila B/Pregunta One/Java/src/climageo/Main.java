package climageo;

public class Main {
    public static void main(String[] args) {
        Planta rosa = new Planta();
        rosa.cargarDatosPlanta("Rosa", "Rosaceae", "5 Años", true);
        Ambiente jardin = new Ambiente();
        jardin.ingresarDatosAmbiente(22.5, 65.0, "Arcilloso", 350.0);
        Distribucion europa = new Distribucion();
        europa.registrarDatosDistribucion("Europa Central", new String[]{"Montañas", "Ríos"}, true, 5);
        System.out.println("=== Información de la Planta ===");
        rosa.imprimirDetallesPlanta();
        System.out.println("\n=== Información del Ambiente ===");
        jardin.mostrarDatosAmbiente();
        System.out.println("\n=== Información de Distribución ===");
        europa.visualizarInformacionDistribucion();
        rosa.realizarPolinizacion();
        rosa.generarSemillas();
        jardin.ajustarCondicionesClimaticas(25.0, 70.0);
        System.out.println("¿Es habitable? " + jardin.verificarHabitadPara(rosa));
        europa.analizarDispersionVegetal(rosa, jardin);
        System.out.println(europa.listarBarrerasExistentes());
    }
}