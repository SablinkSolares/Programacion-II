import math
class FigurasGeometricas:
    # Método para calcular el área de un círculo
    def area(self, radio):
        return math.pi * radio * radio

    # Método para calcular el área de un rectángulo
    def area_rectangulo(self, base, altura):
        return base * altura

    # Método para calcular el área de un triángulo rectángulo
    def area_triangulo(self, base, altura):
        return 0.5 * base * altura

    # Método para calcular el área de un trapecio
    def area_trapecio(self, baseMayor, baseMenor, altura):
        return ((baseMayor + baseMenor) / 2) * altura

    # Método para calcular el área de un hexágono
    def area_hexagono(self, lado):
        return (6 * lado * lado * math.sqrt(3)) / 4
figura = FigurasGeometricas()
figura1 = FigurasGeometricas()
figura2 = FigurasGeometricas()
figura3 = FigurasGeometricas()
figura4 = FigurasGeometricas()
print("Área de un Círculo:", figura.area(5.0))
print("Área de un Rectángulo:", figura1.area_rectangulo(7.0, 6.0))
print("Área de un Triángulo Rectángulo:", figura2.area_triangulo(9, 8))
print("Área de un Trapecio:", figura3.area_trapecio(1, 2, 3))
print("Área de un Hexágono:", figura4.area_hexagono(6))
