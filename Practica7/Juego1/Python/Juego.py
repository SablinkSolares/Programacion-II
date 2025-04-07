import pygame
import random
import sys

pygame.init()

class Juego:
    def __init__(self):
        self._numeroDeVidas = 0
        self._record = 0

    @property
    def numeroDeVidas(self):
        return self._numeroDeVidas

    @numeroDeVidas.setter
    def numeroDeVidas(self, valor):
        self._numeroDeVidas = valor

    @property
    def record(self):
        return self._record

    @record.setter
    def record(self, valor):
        self._record = valor

    def reiniciaPartida(self):
        pass

    def actualizaRecord(self):
        pass

    def quitaVida(self):
        pass


class JuegoAdivinaNumero(Juego):
    def __init__(self, numeroDeVidas):
        super().__init__()
        self._numeroDeVidas = numeroDeVidas
        self._numeroAAdivinar = 0
        self.vidasIniciales = numeroDeVidas
        self.input_text = ""
        self.message = ""
        self.game_active = True
        self.screen_width = 800
        self.screen_height = 600
        self.screen = pygame.display.set_mode((self.screen_width, self.screen_height))
        pygame.display.set_caption("Juego Adivina el Número")
        self.blanco = (255, 255, 255)
        self.oscuro = (0, 0, 0)
        self.morado = (138, 43, 226)
        self.crimson = (220, 20, 60)
        self.font_large = pygame.font.Font(None, 48)
        self.font_medium = pygame.font.Font(None, 36)
        self.font_small = pygame.font.Font(None, 24)

    def reiniciaPartida(self):
        self.numeroDeVidas = self.vidasIniciales
        self._numeroAAdivinar = random.randint(0, 10)
        self.input_text = ""
        self.message = f" Adivina un número entre 0 y 10."
        self.game_active = True

    def actualizaRecord(self):
        self.record += 1
        self.message = f"¡Acertaste! Récord actual: {self.record}."
        self.game_active = False

    def quitaVida(self):
        self.numeroDeVidas -= 1
        if self.numeroDeVidas <= 0:
            self.message = "¡Perdiste! No te quedan más vidas. El número era: " + str(self._numeroAAdivinar)
            self.game_active = False
            return False
        return True

    def handle_events(self):
        for event in pygame.event.get():
            if event.type == pygame.QUIT:
                pygame.quit()
                sys.exit()

            if event.type == pygame.KEYDOWN:
                if event.key == pygame.K_ESCAPE:
                    pygame.quit()
                    sys.exit()

                if self.game_active:
                    if event.key == pygame.K_RETURN:
                        try:
                            guess = int(self.input_text)
                            if guess < 0 or guess > 10:
                                self.message = "¡Error! El número debe estar entre 0 y 10"
                                self.input_text = ""
                            else:
                                if guess == self._numeroAAdivinar:
                                    self.actualizaRecord()
                                else:
                                    if not self.quitaVida():
                                        continue

                                    if guess < self._numeroAAdivinar:
                                        self.message = f"El número es MAYOR. Vidas restantes: {self.numeroDeVidas}"
                                    else:
                                        self.message = f"El número es MENOR. Vidas restantes: {self.numeroDeVidas}"
                        except ValueError:
                            self.message = "Por favor, introduce un número válido"
                        self.input_text = ""

                    elif event.key == pygame.K_BACKSPACE:
                        self.input_text = self.input_text[:-1]
                    elif event.unicode.isdigit():
                        self.input_text += event.unicode

            if event.type == pygame.MOUSEBUTTONDOWN and not self.game_active:
                self.reiniciaPartida()

    def render(self):
        self.screen.fill(self.blanco)

        title = self.font_large.render("Juego de Adivinar un Número", True, self.oscuro)
        self.screen.blit(title, (self.screen_width // 2 - title.get_width() // 2, 50))

        if self.message:
            msg = self.font_medium.render(self.message, True, self.oscuro)
            self.screen.blit(msg, (self.screen_width // 2 - msg.get_width() // 2, 150))

        if self.game_active:
            input_label = self.font_small.render("Introduce un número (0-10):", True, self.oscuro)
            self.screen.blit(input_label, (self.screen_width // 2 - input_label.get_width() // 2, 250))

            input_surface = self.font_medium.render(self.input_text, True, self.oscuro)
            pygame.draw.rect(self.screen, self.oscuro, (self.screen_width // 2 - 100, 300, 200, 40), 2)
            self.screen.blit(input_surface, (self.screen_width // 2 - input_surface.get_width() // 2, 310))

            instructions = self.font_small.render("Presiona ENTER para enviar tu respuesta", True, self.crimson)
            self.screen.blit(instructions, (self.screen_width // 2 - instructions.get_width() // 2, 370))
        else:
            restart = self.font_medium.render("Haz clic para jugar de nuevo", True, self.morado)
            self.screen.blit(restart, (self.screen_width // 2 - restart.get_width() // 2, 400))

        vidas = self.font_small.render(f"Vidas: {self.numeroDeVidas}", True, self.oscuro)
        self.screen.blit(vidas, (20, 20))

        record = self.font_small.render(f"Récord: {self.record}", True, self.oscuro)
        self.screen.blit(record, (self.screen_width - record.get_width() - 20, 20))

        pygame.display.flip()

    def juega(self):
        self.reiniciaPartida()
        clock = pygame.time.Clock()

        while True:
            self.handle_events()
            self.render()
            clock.tick(60)


class Aplicacion:
    @staticmethod
    def main():
        juego = JuegoAdivinaNumero(3)  # Comienza con 3 vidas
        juego.juega()


if __name__ == "__main__":
    Aplicacion.main()



