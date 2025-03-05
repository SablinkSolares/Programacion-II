class Cola:
    def __init__(self, n):
        self.__arreglo = [0] * (n + 1)
        self.__inicio = 0
        self.__fin = 0
        self.__n = n
    def insert(self, e):
        if self.__fin == self.__n:
            print("Cola Llena")
        else:
            self.__fin = self.__fin + 1
            self.__arreglo[self.__fin] = e
    def remove(self):
        if self.__inicio == 0 and self.__fin == 0:
            print("Cola Vacia")
            return None
        else:
            self.__inicio = self.__inicio + 1
            dato = self.__arreglo[self.__inicio]
            if self.__inicio == self.__fin:
                self.__inicio = 0
                self.__fin = 0
            return dato
    def peek(self):
        if self.isEmpty():
            return None
        return self.__arreglo[self.__inicio + 1]
    def isEmpty(self):
        return self.__inicio == 0 and self.__fin == 0
    def isFull(self):
        return self.__fin == self.__n
    def nroelem(self):  # size
        aux = Cola(self.__n)
        contador = 0
        while not self.isEmpty():
            dato = self.remove()
            aux.insert(dato)
            contador = contador + 1
        while not aux.isEmpty():
            dato = aux.remove()
            self.insert(dato)
        return contador
    def nroelem2(self):  # size
        return self.__fin - self.__inicio
    def __str__(self):
        if self.isEmpty():
            return "Cola Vacía"
        elementos = []
        aux = Cola(self.__n)
        while not self.isEmpty():
            dato = self.remove()
            elementos.append(str(dato))
            aux.insert(dato)
        while not aux.isEmpty():
            dato = aux.remove()
            self.insert(dato)
        return " ".join(elementos)
    def copy(self):
        nueva_cola = Cola(self.__n)
        aux = Cola(self.__n)
        while not self.isEmpty():
            dato = self.remove()
            nueva_cola.insert(dato)
            aux.insert(dato)
        while not aux.isEmpty():
            dato = aux.remove()
            self.insert(dato)
        return nueva_cola
# Ejemplo de uso
colas = Cola(9)
colas.insert(2)
colas.insert(4)
colas.insert(6)
colas.insert(8)
colas.insert(10)
colas.insert(12)
colas.insert(14)
colas.insert(16)
colas.insert(18)
print("Cola:",colas)
colas.insert(20)
aux = colas.copy()
print("Datos de mi Cola:",colas)
print("Cola Auxiliar:", aux)
