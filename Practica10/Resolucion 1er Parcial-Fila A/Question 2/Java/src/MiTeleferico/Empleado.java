package MiTeleferico;

public class Empleado {
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private int edad;
    protected double sueldoBase;  

    public Empleado(String nombre, String apellidoPaterno, String apellidoMaterno, int edad, double sueldoBase) {
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.edad = edad;
        this.sueldoBase = sueldoBase;
    }

  
    public double calcularSueldo() {
        return sueldoBase;
    }

    public String getNombre() { return nombre; }
    public String getApellidoPaterno() { return apellidoPaterno; }
    public String getApellidoMaterno() { return apellidoMaterno; }
    public int getEdad() { return edad; }
    public double getSueldoBase() { return sueldoBase; }

    @Override
    public String toString() {
        return nombre + " " + apellidoPaterno + " " + apellidoMaterno + 
               " - Edad: " + edad + " Años, Sueldo: " + calcularSueldo() + " Bs (Empleado Base)";
    }
}

class EmpleadoAdministrativo extends Empleado {
    private double bonoProductividad;

    public EmpleadoAdministrativo(String nombre, String apellidoPaterno, String apellidoMaterno, 
                                int edad, double sueldoBase, double bonoProductividad) {
        super(nombre, apellidoPaterno, apellidoMaterno, edad, sueldoBase);
        this.bonoProductividad = bonoProductividad;
    }

    @Override
    public double calcularSueldo() {
        return super.calcularSueldo() + bonoProductividad;
    }

    @Override
    public String toString() {
        return super.toString().replace("(Empleado Base)", "(Administrativo)");
    }
}

class EmpleadoTecnico extends Empleado {
    private double bonoRiesgo;

    public EmpleadoTecnico(String nombre, String apellidoPaterno, String apellidoMaterno, 
                          int edad, double sueldoBase, double bonoRiesgo) {
        super(nombre, apellidoPaterno, apellidoMaterno, edad, sueldoBase);
        this.bonoRiesgo = bonoRiesgo;
    }

    @Override
    public double calcularSueldo() {
        return super.calcularSueldo() + bonoRiesgo;
    }

    @Override
    public String toString() {
        return super.toString().replace("(Empleado Base)", "(Técnico)");
    }
}

class EmpleadoAtencionCliente extends Empleado {
    private double comisiones;

    public EmpleadoAtencionCliente(String nombre, String apellidoPaterno, String apellidoMaterno, 
                                 int edad, double sueldoBase, double comisiones) {
        super(nombre, apellidoPaterno, apellidoMaterno, edad, sueldoBase);
        this.comisiones = comisiones;
    }

    @Override
    public double calcularSueldo() {
        return super.calcularSueldo() + comisiones;
    }

    @Override
    public String toString() {
        return super.toString().replace("(Empleado Base)", "(Atención al Cliente)");
    }
}



