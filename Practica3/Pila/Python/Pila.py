class Pila:
    def __init__(self, n):
        self.__top = 0
        self.__n = n    
        self.__arreglo = [0] * (n + 1)  

    # Método para agregar un elemento a la pila
    def push(self, e):
        if self.isFull():
            print("Pila Llena")
        else:
            self.__top = self.__top + 1
            self.__arreglo[self.__top] = e

    # Método para eliminar y devolver el elemento en la parte superior de la pila
    def pop(self):
        if self.isEmpty():
            print("Pila Vacia")
            return 0
        else:
            num = self.__arreglo[self.__top]
            self.__top = self.__top - 1
            return num

    # Método para ver el elemento en la parte superior de la pila sin eliminarlo
    def peek(self):
        return self.__arreglo[self.__top]

    # Método para verificar si la pila está vacía
    def isEmpty(self):
        return self.__top == 0

    # Método para verificar si la pila está llena
    def isFull(self):
        return self.__top == self.__n

    # Método para imprimir la pila
    def imprimirPila(self):
        if self.isEmpty():
            print("La Pila está Vacía.")
        else:
            print()
            print("Datos de mi Pila: ", end="")
            for i in range(self.__top, 0, -1):
                print(self.__arreglo[i], end="")
                if i > 1:
                    print(" ", end="")  # Separador entre elementos
            print()  # Salto de línea al final

# Método para mostrar los datos de una pila
def mostrarPila(pila):
    if pila.isEmpty():
        print("La Pila está Vacía.")
    else:
        for i in range(pila._Pila__top, 0, -1):
            print(pila._Pila__arreglo[i])

# Método para pasar los datos de una pila a otra
def pasarDatos(pilaOrigen, pilaDestino):
    while not pilaOrigen.isEmpty():
        num = pilaOrigen.pop()
        pilaDestino.push(num)

# Método principal
if __name__ == "__main__":
    # Crear una pila de tamaño 5
    pila = Pila(5)
    # Agregar elementos a la pila
    pila.push(5)
    pila.push(10)
    pila.push(15)
    pila.push(20)
    pila.push(25)
    # Mostrar los datos de la pila original
    print("\nPila 1:")
    mostrarPila(pila)
    # Intentar agregar un elemento cuando la pila está llena
    pila.push(30)
    pila.imprimirPila()
    # Crear una pila extra y pasar los datos de la pila original a la pila extra
    pilaExtra = Pila(5)
    pasarDatos(pila, pilaExtra)
    # Mostrar los datos de la pila extra
    print("\nPila Extra:")
    mostrarPila(pilaExtra)
