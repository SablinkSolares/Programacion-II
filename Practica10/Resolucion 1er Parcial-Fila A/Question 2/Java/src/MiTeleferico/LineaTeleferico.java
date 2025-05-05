package MiTeleferico;

import java.util.ArrayList;
import java.util.List;

public class LineaTeleferico {
    private String color;
    private String tramo;
    private int nroCabinas;
    private int nroEmpleados;
    private List<Empleado> empleados = new ArrayList<>();

    public LineaTeleferico(String color, String tramo, int nroCabinas, int nroEmpleados) {
        this.color = color;
        this.tramo = tramo;
        this.nroCabinas = nroCabinas;
        this.nroEmpleados = nroEmpleados;
    }

    public void agregarEmpleado(Empleado e) {
        empleados.add(e);
        nroEmpleados++;
    }

    public List<Empleado> getEmpleados() {
        return new ArrayList<>(empleados);
    }

    public void eliminarEmpleadosPorApellido(String apellido) {
        int empleadosEliminados = 0;
        List<Empleado> copiaEmpleados = new ArrayList<>(empleados);
        
        for (Empleado e : copiaEmpleados) {
            if (e.getApellidoPaterno().equals(apellido) || e.getApellidoMaterno().equals(apellido)) {
                empleados.remove(e);
                empleadosEliminados++;
            }
        }
        
        nroEmpleados = empleados.size();
        System.out.println("Se eliminaron " + empleadosEliminados + " empleados con apellido " + apellido);
    }

    public void transferirEmpleado(LineaTeleferico destino, Empleado empleado) {
        if (empleados.contains(empleado)) {
            empleados.remove(empleado);
            destino.agregarEmpleado(empleado);
            nroEmpleados--;
            System.out.println("Empleado " + empleado.getNombre() + " transferido a la Línea " + destino.getColor());
        } else {
            System.out.println("El empleado no pertenece a esta línea");
        }
    }

    public void mostrarEmpleadosMayorEdad() {
        if (empleados.isEmpty()) {
            System.out.println("No hay empleados registrados");
            return;
        }

        int maxEdad = empleados.stream()
                             .mapToInt(Empleado::getEdad)
                             .max()
                             .getAsInt();
        
        System.out.println("\nEmpleados con mayor edad (" + maxEdad + " años):");
        empleados.stream()
               .filter(e -> e.getEdad() == maxEdad)
               .forEach(e -> System.out.println("- " + e.getNombre() + " " + e.getApellidoPaterno()));
    }

    public void mostrarEmpleadosMayorEdad(boolean detallesCompletos) {
        if (!detallesCompletos) {
            mostrarEmpleadosMayorEdad();
            return;
        }

        if (empleados.isEmpty()) {
            System.out.println("No hay empleados registrados");
            return;
        }

        int maxEdad = empleados.stream()
                             .mapToInt(Empleado::getEdad)
                             .max()
                             .getAsInt();
        
        System.out.println("\nDetalles de empleados con mayor edad (" + maxEdad + " años):");
        empleados.stream()
               .filter(e -> e.getEdad() == maxEdad)
               .forEach(System.out::println);
    }

    public void mostrarEmpleadosMayorSueldo() {
        if (empleados.isEmpty()) {
            System.out.println("No hay empleados registrados");
            return;
        }

        double maxSueldo = empleados.stream()
                                  .mapToDouble(Empleado::calcularSueldo)
                                  .max()
                                  .getAsDouble();
        
        System.out.println("\nMayor sueldo: " + maxSueldo + " Bs");
    }

    public void mostrarEmpleadosMayorSueldo(boolean mostrarDetalles) {
        if (!mostrarDetalles) {
            mostrarEmpleadosMayorSueldo();
            return;
        }

        if (empleados.isEmpty()) {
            System.out.println("No hay empleados registrados");
            return;
        }

        double maxSueldo = empleados.stream()
                                  .mapToDouble(Empleado::calcularSueldo)
                                  .max()
                                  .getAsDouble();
        
        System.out.println("\nEmpleados con mayor sueldo (" + maxSueldo + " Bs):");
        empleados.stream()
               .filter(e -> e.calcularSueldo() == maxSueldo)
               .forEach(System.out::println);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Línea ").append(color).append("\n");
        sb.append("Tramo: ").append(tramo).append("\n");
        sb.append("N° Cabinas: ").append(nroCabinas).append("\n");
        sb.append("N° Empleados: ").append(nroEmpleados).append("\n");
        
        if (!empleados.isEmpty()) {
            sb.append("Empleados:\n");
            empleados.forEach(e -> sb.append("- ").append(e).append("\n"));
        } else {
            sb.append("No hay empleados asignados\n");
        }
        
        return sb.toString();
    }

    public String getColor() {
        return color;
    }
}

