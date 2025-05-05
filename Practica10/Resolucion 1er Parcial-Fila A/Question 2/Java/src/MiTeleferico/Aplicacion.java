package MiTeleferico;

public class Aplicacion {
	
    public static void main(String[] args) {
        
        LineaTeleferico lineaRoja = new LineaTeleferico("Roja", "Estación Central - Estación Cementerio - Estación 16 de Julio", 110, 0);
        LineaTeleferico lineaVerde = new LineaTeleferico("Verde", "Chuqui Apu - Pata Obrajes - Aynacha Obrajes - Irpawi", 167, 0);
        lineaRoja.agregarEmpleado(new Empleado("Juan", "Gomez", "Perez", 40, 2000)); 
        lineaRoja.agregarEmpleado(new EmpleadoAdministrativo("Pedro", "Rojas", "Luna", 35, 2000, 500));
        lineaRoja.agregarEmpleado(new EmpleadoTecnico("Lucy", "Sosa", "Rios", 43, 2500, 750));
        lineaRoja.agregarEmpleado(new EmpleadoAtencionCliente("Ana", "Perez", "Rojas", 26, 1800, 900));
        lineaVerde.agregarEmpleado(new Empleado("Mario", "Santos", "Lopez", 45, 2200)); 
        lineaVerde.agregarEmpleado(new EmpleadoAdministrativo("Daniel", "Cortez", "Flores", 38, 2200, 700));
        lineaVerde.agregarEmpleado(new EmpleadoAtencionCliente("Jazmin", "Machaca", "Zapata", 32, 1900, 1150));
        System.out.println("=== MI TELEFÉRICO ===");
        System.out.println("\n--- Estado Inicial de las Líneas ---");
        System.out.println(lineaRoja);
        System.out.println(lineaVerde);
        System.out.println("\n--- Operaciones con Empleados ---");
        System.out.println("\nEliminando empleados con apellido 'Rojas' de la línea Roja...");
        lineaRoja.eliminarEmpleadosPorApellido("Rojas");
        System.out.println("\nTransferencia de empleado Lucy Sosa a línea Verde...");
        Empleado lucy = lineaRoja.getEmpleados().stream().filter(e -> e.getNombre().equals("Lucy")).findFirst().orElse(null);
        lineaRoja.transferirEmpleado(lineaVerde, lucy);
        System.out.println("\n--- Estado Actualizado de las Líneas ---");
        System.out.println(lineaRoja);
        System.out.println(lineaVerde);
        System.out.println("\n--- Empleados Destacados ---");
        System.out.println("\nLínea Roja:");
        lineaRoja.mostrarEmpleadosMayorEdad(true);
        lineaRoja.mostrarEmpleadosMayorSueldo(true);
        System.out.println("\nLínea Verde:");
        lineaVerde.mostrarEmpleadosMayorEdad(true);
        lineaVerde.mostrarEmpleadosMayorSueldo(true);
       
    }
}

