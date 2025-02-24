import math

class Punto:
    def __init__(self, x: float, y: float):
        self.x = x
        self.y = y

    def coord_cartesianas(self):
        return (self.x, self.y)

    def coord_polares(self):
        r = math.sqrt(self.x**2 + self.y**2)
        theta = math.atan2(self.y, self.x)
        return (r, theta)

    def toString(self):
        return f"Punto({self.x},{self.y})"

class Linea:
    def __init__(self, p1: Punto, p2: Punto):
        self.p1 = p1
        self.p2 = p2

    def toString(self):
        return f"Linea({self.p1.toString()},{self.p2.toString()})"

    def dibujalinea(self):
        # Dibujar la línea con asteriscos
        x1, y1 = self.p1.coord_cartesianas()
        x2, y2 = self.p2.coord_cartesianas()

        # Determinar la dirección de la línea
        dx = x2 - x1
        dy = y2 - y1

        # Determinar el número de pasos
        steps = max(abs(dx), abs(dy))

        # Calcular incrementos
        x_inc = dx / steps
        y_inc = dy / steps

        # Dibujar la línea
        x, y = x1, y1
        for _ in range(steps + 1):
            print("*", end="")
            x += x_inc
            y += y_inc
        print()

# Ejemplo de uso
p1 = Punto(1,1)
p2 = Punto(20,1)
linea = Linea(p1, p2)
print(linea.toString())
print()
linea.dibujalinea()
