import pygame
import sys
import random

pygame.init()

# Colores
WHITE = (255, 255, 255)
BLACK = (0, 0, 0)
GRAY = (200, 200, 200)
BLUE = (0, 150, 255)
GREEN = (0, 200, 100)
RED = (200, 0, 0)

# Pantalla
WIDTH, HEIGHT = 600, 400
screen = pygame.display.set_mode((WIDTH, HEIGHT))
pygame.display.set_caption("Juego Adivina Número")

# Fuente
FONT = pygame.font.SysFont("Arial", 28)

# Botón
class Boton:
    def __init__(self, texto, x, y, w, h, color=GRAY):
        self.rect = pygame.Rect(x, y, w, h)
        self.texto = texto
        self.color = color

    def dibujar(self, screen):
        pygame.draw.rect(screen, self.color, self.rect)
        texto = FONT.render(self.texto, True, BLACK)
        screen.blit(texto, (self.rect.x + (self.rect.w - texto.get_width()) // 2,
                            self.rect.y + (self.rect.h - texto.get_height()) // 2))

    def esta_clickeado(self, pos):
        return self.rect.collidepoint(pos)

# Clase base
class JuegoAdivinaNumero:
    def __init__(self):
        self.vidas = 3
        self.puntaje = 0
        self.numero_secreto = random.randint(0, 10)

    def validaNumero(self, numero):
        return 0 <= numero <= 10

    def animacion(self, mensaje, color_fondo):
        for _ in range(3):
            screen.fill(color_fondo)
            texto = FONT.render(mensaje, True, WHITE)
            screen.blit(texto, (WIDTH // 2 - texto.get_width() // 2, HEIGHT // 2))
            pygame.display.flip()
            pygame.time.wait(300)

    def mostrar_texto(self, texto, y):
        render = FONT.render(texto, True, BLACK)
        screen.blit(render, (WIDTH // 2 - render.get_width() // 2, y))

    def jugar(self):
        entrada = ''
        jugando = True
        while jugando and self.vidas > 0:
            screen.fill(WHITE)
            self.mostrar_texto(f"Vidas: {self.vidas} | Puntaje: {self.puntaje}", 20)
            self.mostrar_texto("Adivina un número (0-10):", 120)
            input_render = FONT.render(entrada, True, BLUE)
            screen.blit(input_render, (WIDTH // 2 - input_render.get_width() // 2, 160))

            pygame.display.flip()

            for event in pygame.event.get():
                if event.type == pygame.QUIT:
                    pygame.quit()
                    sys.exit()
                elif event.type == pygame.KEYDOWN:
                    if event.key == pygame.K_RETURN:
                        if entrada.isdigit():
                            numero = int(entrada)
                            if not self.validaNumero(numero):
                                self.animacion("¡Número inválido!", RED)
                                self.puntaje = max(0, self.puntaje - 5)
                            elif numero == self.numero_secreto:
                                self.animacion("¡Correcto!", GREEN)
                                self.puntaje += 10
                                jugando = False
                            else:
                                self.animacion("¡Incorrecto!", RED)
                                self.vidas -= 1
                                self.puntaje = max(0, self.puntaje - 5)
                        entrada = ''
                    elif event.key == pygame.K_BACKSPACE:
                        entrada = entrada[:-1]
                    elif event.unicode.isdigit():
                        entrada += event.unicode

        screen.fill(WHITE)
        if self.vidas == 0:
            self.mostrar_texto(f"¡Perdiste! Era: {self.numero_secreto}", HEIGHT // 2 - 20)
        else:
            self.mostrar_texto("¡Ganaste!", HEIGHT // 2 - 20)

        self.mostrar_texto(f"Puntaje Final: {self.puntaje}", HEIGHT // 2 + 20)
        pygame.display.flip()
        pygame.time.wait(2000)

# Juego par
class JuegoAdivinaPar(JuegoAdivinaNumero):
    def validaNumero(self, numero):
        if numero % 2 == 0 and 0 <= numero <= 10:
            return True
        self.animacion("Debe ser PAR entre 0 y 10", RED)
        self.puntaje = max(0, self.puntaje - 5)
        return False

# Juego impar
class JuegoAdivinaImpar(JuegoAdivinaNumero):
    def validaNumero(self, numero):
        if numero % 2 == 1 and 0 <= numero <= 10:
            return True
        self.animacion("Debe ser IMPAR entre 0 y 10", RED)
        self.puntaje = max(0, self.puntaje - 5)
        return False

# Menú principal
def menu():
    botones = [
        Boton("Juego Normal", 200, 100, 200, 50),
        Boton("Juego Par", 200, 170, 200, 50),
        Boton("Juego Impar", 200, 240, 200, 50)
    ]

    while True:
        screen.fill(WHITE)
        titulo = FONT.render("Selecciona un Juego", True, BLACK)
        screen.blit(titulo, (WIDTH // 2 - titulo.get_width() // 2, 40))

        for boton in botones:
            boton.dibujar(screen)

        pygame.display.flip()

        for event in pygame.event.get():
            if event.type == pygame.QUIT:
                pygame.quit()
                sys.exit()
            if event.type == pygame.MOUSEBUTTONDOWN:
                if botones[0].esta_clickeado(event.pos):
                    return JuegoAdivinaNumero()
                elif botones[1].esta_clickeado(event.pos):
                    return JuegoAdivinaPar()
                elif botones[2].esta_clickeado(event.pos):
                    return JuegoAdivinaImpar()

# Aplicación principal
class Aplicacion:
    def ejecutar(self):
        while True:
            juego = menu()
            juego.jugar()

# Iniciar
if __name__ == "__main__":
    app = Aplicacion()
    app.ejecutar()
