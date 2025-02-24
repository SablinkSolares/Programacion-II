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

class Circulo:
    def __init__(self, centro: Punto, radio: float):
        self.centro = centro
        self.radio = radio

    def toString(self):
        return f"Circulo(centro={self.centro.toString()},radio={self.radio})"

    def dibujacirculo(self):
        for i in range(-self.radio, self.radio + 1):
            for j in range(-self.radio, self.radio + 1):
                if math.sqrt(i**2 + j**2) <= self.radio:
                    print("*", end="")
                else:
                    print(" ", end="")
            print()
# Ejemplo de uso
p = Punto(1,2)
c = Circulo(p,6)

print(p.toString())
print(c.toString())

print("Dibujando círculo:")
c.dibujacirculo()
