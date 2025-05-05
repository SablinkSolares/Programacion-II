class Ministerio:
    def __init__(self, nombre="", direccion="", nroEmpleados=0, empleados=None, edades=None, sueldos=None):
        self.nombre = nombre
        self.direccion = direccion
        self.nroEmpleados = nroEmpleados
        self.empleados = empleados if empleados is not None else []
        self.edades = edades if edades is not None else []
        self.sueldos = sueldos if sueldos is not None else []
    
    def __str__(self):
        return f"Ministerio {self.nombre} - Empleados: {self.nroEmpleados}"
    
    @classmethod
    def crear_ministerio_ejemplo(cls):
        nombre = "Economía y Finanzas Públicas"
        direccion = "Calle Mercado Esq. Ayacucho, Edificio Mariscal de Ayacucho"
        nroEmpleados = 4
        empleados = [
            ["Pedro", "Lucy", "Ana", "Saul"],
            ["Rojas", "Sosa", "Perez", "Arce"],
            ["Luna", "Rios", "Rojas", "Calle"]
        ]
        edades = [35, 43, 26, 29]
        sueldos = [2500, 3250, 2700, 2500]
        return cls(nombre, direccion, nroEmpleados, empleados, edades, sueldos)
    
    def eliminar_por_edad(self, edad_x):
        indices_a_eliminar = [i for i, edad in enumerate(self.edades) if edad == edad_x]
        for i in sorted(indices_a_eliminar, reverse=True):
            for lista in self.empleados:
                lista.pop(i)
            self.edades.pop(i)
            self.sueldos.pop(i)
        self.nroEmpleados = len(self.edades)
    
    def __add__(self, otro):
        if not isinstance(otro, Ministerio):
            raise TypeError("Solo se pueden transferir empleados entre Ministerios")
        
        if otro.nroEmpleados == 0:
            return self
        
        
        for i in range(len(self.empleados)):
            self.empleados[i].append(otro.empleados[i][0])
        self.edades.append(otro.edades[0])
        self.sueldos.append(otro.sueldos[0])
        self.nroEmpleados += 1
        otro.eliminar_por_indice(0)
        return self
    
    def eliminar_por_indice(self, index):
        for lista in self.empleados:
            lista.pop(index)
        self.edades.pop(index)
        self.sueldos.pop(index)
        self.nroEmpleados = len(self.edades)
    
    
    def mostrar_menores(self, criterio='edad'):
        if criterio == 'edad':
            valores = self.edades
            texto = "edad"
        elif criterio == 'sueldo':
            valores = self.sueldos
            texto = "sueldo"
        else:
            raise ValueError("Criterio no válido. Use 'edad' o 'sueldo'")
        
        if not valores:
            print(f"No hay empleados para mostrar {texto} menor")
            return
        
        min_val = min(valores)
        indices = [i for i, val in enumerate(valores) if val == min_val]
        
        print(f"Empleados con menor {texto} ({min_val}):")
        for i in indices:
            nombre_completo = f"{self.empleados[0][i]} {self.empleados[1][i]} {self.empleados[2][i]}"
            print(f"- {nombre_completo}: {texto}={valores[i]}")
    
    
    def mostrar(self, tipo='edad'):
        self.mostrar_menores(tipo)


ministerio1 = Ministerio.crear_ministerio_ejemplo()
ministerio2 = Ministerio(
    nombre="Obras Públicas",
    direccion="Av. Mariscal Santa Cruz, Edificio Alberto Bailey,(ex Banco Central)",
    nroEmpleados=3,
    empleados=[
        ["Juan", "Maria", "Carlos"],
        ["Gomez", "Lopez", "Sanchez"],
        ["Perez", "Garcia", "Fernandez"]
    ],
    edades=[40, 28, 35],
    sueldos=[3000, 2800, 3200]
)

print("\n--- Ministerios creados ---")
print(ministerio1)
print(ministerio2)
print("\n--- Eliminar empleados con edad 35 del ministerio1 ---")
ministerio1.eliminar_por_edad(35)
print(f"Empleados después de eliminar: {ministerio1.nroEmpleados}")
print("\n--- Transferir empleado de ministerio2 a ministerio1 ---")
ministerio1 + ministerio2
print(f"ministerio1 ahora tiene {ministerio1.nroEmpleados} empleados")
print(f"ministerio2 ahora tiene {ministerio2.nroEmpleados} empleados")
print("\n--- Empleados con menor edad en ministerio1 ---")
ministerio1.mostrar('edad')  
print("\n--- Empleados con menor sueldo en ministerio1 ---")
ministerio1.mostrar('sueldo')
