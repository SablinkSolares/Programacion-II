package dates;

public class Cola {
    private long arreglo[];
    private int inicio;
    private int fin;
    private int n;

    public Cola(int n) {
        this.arreglo = new long[n + 1];
        this.inicio = 0;
        this.fin = 0;
        this.n = n;
    }

    public void insert(long e) {
        if (this.fin == n) {
            System.out.println("Cola Llena");
        } else {
            this.fin = this.fin + 1;
            this.arreglo[this.fin] = e;
        }
    }

    public long remove() {
        if (this.inicio == 0 && this.fin == 0) {
            System.out.println("Cola vacia");
            return -1;
        } else {
            this.inicio = this.inicio + 1;
            long dato = this.arreglo[this.inicio];

            if (this.inicio == this.fin) {
                this.inicio = 0;
                this.fin = 0;
            }
            return dato;
        }
    }

    public long peek() {
        return this.arreglo[this.inicio + 1];
    }

    public boolean isEmpty() {
        return this.inicio == 0 && this.fin == 0;
    }

    public boolean isFull() {
        return this.fin == this.n;
    }

    public int nroelem() { // size
        return this.fin - this.inicio;
    }

    public void mostrarColaHorizontal() {
        for (int i = inicio + 1; i <= fin; i++) {
            System.out.print(arreglo[i] + " ");
        }
        System.out.println();
    }

    public Cola copiarCola() {
        Cola nuevaCola = new Cola(this.n);
        for (int i = inicio + 1; i <= fin; i++) {
            nuevaCola.insert(arreglo[i]);
        }
        return nuevaCola;
    }

    public static void main(String[] args) {
        Cola cola = new Cola(6);
        cola.insert(1);
        cola.insert(3);
        cola.insert(5);
        cola.insert(7);
        cola.insert(9);
        cola.insert(11);

        // Mostrar la cola original de manera horizontal
        System.out.print("Cola : ");
        cola.mostrarColaHorizontal();
        cola.insert(13);
        // Copiar la cola original a una nueva cola
        Cola colaExtra = cola.copiarCola();

        // Mostrar la cola original nuevamente para verificar que no fue afectada
        System.out.print("Datos de mi Cola: ");
        cola.mostrarColaHorizontal();
        System.out.print("Cola Extra: ");
        colaExtra.mostrarColaHorizontal();
    }
}