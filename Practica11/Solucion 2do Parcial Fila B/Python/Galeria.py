class Artista:
    def __init__(self, nombre, ci, añosExperiencia):
        self.nombre = nombre
        self.ci = ci
        self.añosExperiencia = añosExperiencia

class Anuncio:
    def __init__(self, numero, precio):
        self.numero = numero
        self.precio = precio

class Obra:
    def __init__(self, titulo, material, artista1, artista2, anuncio):
        self.titulo = titulo
        self.material = material
        self.a1 = artista1
        self.a2 = artista2
        self.b = anuncio

class Pintura(Obra):
    def __init__(self, titulo, material, artista1, artista2, anuncio, genero):
        super().__init__(titulo, material, artista1, artista2, anuncio)
        self.genero = genero

print("Fila B-Ejercicio 1")
print("Herencia-Agregacion-Composicion")
print()
a1 = Artista("Pablo Picasso", "446556", 20)
a2 = Artista("Vincent van Gogh", "779811", 25)
a3 = Artista("Leonardo da Vinci", "2551546", 30)
a4 = Artista("Claude Monet", "98414", 10)
anu1 = Anuncio(1, 5000)
anu2 = Anuncio(1, 2000)
pint1 = Pintura("Guernica", "Óleo", a1, a2, anu1, "Cubismo")
pint2 = Pintura("La noche estrellada", "Óleo", a3, a4, anu2, "Postimpresionismo")

def promedio_experiencia(pint1, pint2):
    artistas = [
        pint1.a1, pint1.a2,
        pint2.a1, pint2.a2
    ]
    s = sum(artista.añosExperiencia for artista in artistas)
    return s / len(artistas)

h = promedio_experiencia(pint1, pint2)
print(f"El Promedio de Años de Experiencia es: {h}")

def ipa(pinturas, nomart, n):
    for pintura in pinturas:
        if pintura.a1.nombre == nomart or pintura.a2.nombre == nomart:
            pintura.b.precio += n
            print(f"Nuevo Precio de la Obra {pintura.titulo} de Pablo Picasso es: ${pintura.b.precio}")

ipa([pint1, pint2], "Pablo Picasso", 6500)

