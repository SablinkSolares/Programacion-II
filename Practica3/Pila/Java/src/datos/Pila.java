package datos;
public class Pila {
    private long arreglo[];
    private int top;
    private int n;

    // Constructor
    public Pila(int n) {
        this.top = 0;
        this.n = n;
        arreglo = new long[n + 1];
    }
    // Método para agregar un elemento a la pila
    public void push(long e) {
        if (this.isFull()) {
            System.out.println("Pila Llena");
        } else {
            this.top = this.top + 1;
            arreglo[this.top] = e;
        }
    }
    // Método para eliminar y devolver el elemento en la parte superior de la pila
    public long pop() {
        if (this.isEmpty()) {
            System.out.println("Pila Vacia");
            return 0;
        } else {
            long num = arreglo[this.top];
            this.top = this.top - 1;
            return num;
        }
    }

    // Método para ver el elemento en la parte superior de la pila sin eliminarlo
    public long peek() {
        return arreglo[this.top];
    }

    // Método para verificar si la pila está vacía
    public boolean isEmpty() {
        return this.top == 0;
    }

    // Método para verificar si la pila está llena
    public boolean isFull() {
        return this.top == n;
    }
    public void imprimirPila() {
        if (this.isEmpty()) {
            System.out.println("La Pila está Vacía.");
        } else {
        	System.out.println();
            System.out.print("Datos de mi Pila: ");
            for (int i = this.top; i > 0; i--) {
                System.out.print(arreglo[i]);
                if (i > 1) {
                    System.out.print(" "); // Separador entre elementos
                }
            }
            System.out.println(); // Salto de línea al final
        }
    }


    // Método principal
    public static void main(String[] args) {
        // Crear una pila de tamaño 5
        Pila pila = new Pila(5);
        // Agregar elementos a la pila
        pila.push(5);
        pila.push(10);
        pila.push(15);
        pila.push(20);
        pila.push(25);
       // Mostrar los datos de la pila original
        System.out.println("\nPila 1:");
        mostrarPila(pila);
     // Intentar agregar un elemento cuando la pila está llena
        pila.push(30);
        pila.imprimirPila();
       // Crear una pila extra y pasar los datos de la pila original a la pila extra
        Pila pilaExtra = new Pila(5);
        pasarDatos(pila, pilaExtra);
        // Mostrar los datos de la pila extra
        System.out.println("\nPila Extra:");
        mostrarPila(pilaExtra);
    }

    // Método para mostrar los datos de una pila
    public static void mostrarPila(Pila pila) {
        if (pila.isEmpty()) {
            System.out.println("La Pila está Vacía.");
        } else {
            for (int i = pila.top; i > 0; i--) {
                System.out.println(pila.arreglo[i]);
            }
        }
    }

    // Método para pasar los datos de una pila a otra
    public static void pasarDatos(Pila pilaOrigen, Pila pilaDestino) {
        while (!pilaOrigen.isEmpty()) {
            long num = pilaOrigen.pop();
            pilaDestino.push(num);
        }
    }
}