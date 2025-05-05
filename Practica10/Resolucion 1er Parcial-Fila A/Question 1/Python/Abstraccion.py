class ComunidadIndigena:
    def __init__(self, nombre: str, region: str, contaminantes: list[str], poblacionAfectada: int):
        self.__nombre = nombre
        self.__region = region
        self.__contaminantes = contaminantes.copy()
        self.__poblacionAfectada = poblacionAfectada

    @property
    def nombre(self) -> str:
        return self.__nombre

    @property
    def region(self) -> str:
        return self.__region

    @property
    def contaminantes(self) -> list[str]:
        return self.__contaminantes.copy()

    @property
    def poblacionAfectada(self) -> int:
        return self.__poblacionAfectada

    def realizarProtesta(self) -> None:
        print(f"{self.__nombre} realiza protesta en {self.__region}")

    def medirContaminacion(self) -> float:
        return len(self.__contaminantes) * self.__poblacionAfectada * 0.1

    @classmethod
    def leer(cls) -> 'ComunidadIndigena':
        nombre = input("Ingrese nombre de la comunidad: ")
        region = input("Ingrese región: ")
        contaminantes = input("Ingrese contaminantes (separados por coma): ").split(',')
        contaminantes = [c.strip() for c in contaminantes]
        poblacion = int(input("Ingrese población afectada: "))
        return cls(nombre, region, contaminantes, poblacion)

    def mostrar(self) -> None:
        print(f"Comunidad: {self.nombre}")
        print(f"Región: {self.region}")
        print(f"Contaminantes: {', '.join(self.contaminantes)}")
        print(f"Población afectada: {self.poblacionAfectada}")


class Gobierno:
    def __init__(self, presidente: str, ministerios: list[str], presupuestoAmbiental: float, leyesVigentes: list[str]):
        self.__presidente = presidente
        self.__ministerios = ministerios.copy()
        self.__presupuestoAmbiental = presupuestoAmbiental
        self.__leyesVigentes = leyesVigentes.copy()

    @property
    def presidente(self) -> str:
        return self.__presidente

    @property
    def ministerios(self) -> list[str]:
        return self.__ministerios.copy()

    @property
    def presupuestoAmbiental(self) -> float:
        return self.__presupuestoAmbiental

    @property
    def leyesVigentes(self) -> list[str]:
        return self.__leyesVigentes.copy()

    def implementarRegulaciones(self) -> bool:
        print(f"Implementando regulaciones con presupuesto de ${self.__presupuestoAmbiental}")
        return len(self.__leyesVigentes) > 0

    def fiscalizarMineria(self) -> bool:
        print("Iniciando fiscalización de actividades mineras")
        return "Mineria" in self.__ministerios

    @classmethod
    def leer(cls) -> 'Gobierno':
        presidente = input("Ingrese nombre del presidente: ")
        ministerios = input("Ingrese ministerios (separados por coma): ").split(',')
        ministerios = [m.strip() for m in ministerios]
        presupuesto = float(input("Ingrese presupuesto ambiental: "))
        leyes = input("Ingrese leyes vigentes (separadas por coma): ").split(',')
        leyes = [l.strip() for l in leyes]
        return cls(presidente, ministerios, presupuesto, leyes)

    def mostrar(self) -> None:
        print(f"Presidente: {self.presidente}")
        print(f"Ministerios: {', '.join(self.ministerios)}")
        print(f"Presupuesto ambiental: ${self.presupuestoAmbiental:,.2f}")
        print(f"Leyes vigentes: {', '.join(self.leyesVigentes)}")


class EmpresaMinera:
    def __init__(self, nombre: str, concesiones: list[str], sustanciasToxicas: list[str], gananciasAnuales: float):
        self.__nombre = nombre
        self.__concesiones = concesiones.copy()
        self.__sustanciasToxicas = sustanciasToxicas.copy()
        self.__gananciasAnuales = gananciasAnuales

    @property
    def nombre(self) -> str:
        return self.__nombre

    @property
    def concesiones(self) -> list[str]:
        return self.__concesiones.copy()

    @property
    def sustanciasToxicas(self) -> list[str]:
        return self.__sustanciasToxicas.copy()

    @property
    def gananciasAnuales(self) -> float:
        return self.__gananciasAnuales

    def crearFondoCompensacion(self) -> bool:
        if self.__gananciasAnuales > 1000000:
            print(f"{self.__nombre} creó fondo de compensación")
            return True
        return False

    def reducirEmisiones(self) -> bool:
        print(f"{self.__nombre} implementa reducción de emisiones")
        return len(self.__sustanciasToxicas) > 0

    @classmethod
    def leer(cls) -> 'EmpresaMinera':
        nombre = input("Ingrese nombre de la empresa: ")
        concesiones = input("Ingrese concesiones (separadas por coma): ").split(',')
        concesiones = [c.strip() for c in concesiones]
        sustancias = input("Ingrese sustancias tóxicas (separadas por coma): ").split(',')
        sustancias = [s.strip() for s in sustancias]
        ganancias = float(input("Ingrese ganancias anuales: "))
        return cls(nombre, concesiones, sustancias, ganancias)

    def mostrar(self) -> None:
        print(f"Empresa: {self.nombre}")
        print(f"Concesiones: {', '.join(self.concesiones)}")
        print(f"Sustancias tóxicas: {', '.join(self.sustanciasToxicas)}")
        print(f"Ganancias anuales: ${self.gananciasAnuales:,.2f}")


print("=== Crear Comunidad Indígena ===")
comunidad = ComunidadIndigena.leer()
print("\n=== Crear Gobierno ===")
gobierno = Gobierno.leer()
print("\n=== Crear Empresa Minera ===")
minera = EmpresaMinera.leer()
print("\n=== Mostrar Datos ===")
print("\n** Comunidad Indígena **")
comunidad.mostrar()
print("\n** Gobierno **")
gobierno.mostrar()
print("\n** Empresa Minera **")
minera.mostrar()
print("\n=== Acciones ===")
comunidad.realizarProtesta()
minera.crearFondoCompensacion()
gobierno.implementarRegulaciones()

