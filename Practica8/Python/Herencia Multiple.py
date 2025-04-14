class A:
    def __init__(self, x, z):
        self.x = x
        self.z = z
    def incrementaXZ(self):
        self.x += 1
        self.z += 1
        print(f"A: incrementaXZ() -> x={self.x}, z={self.z}")
    def incrementaZ(self):
        self.z += 1
        print(f"A: incrementaZ() -> z={self.z}")

class B:
    def __init__(self, y, z):
        self.y = y
        self.z = z
    def incrementaYZ(self):
        self.y += 1
        self.z += 1
        print(f"B: incrementaYZ() -> y={self.y}, z={self.z}")
    def incrementaZ(self):
        self.z += 1
        print(f"B: incrementaZ() -> z={self.z}")

class D(A, B):
    def __init__(self, x, y, z):
        A.__init__(self, x, z)
        B.__init__(self, y, z)
    def incrementaXYZ(self):
        self.x += 1
        self.y += 1
        self.z += 1
        print(f"D: incrementaXYZ() -> x={self.x}, y={self.y}, z={self.z}")
    def incrementaZ(self):
        super().incrementaZ()
    def incrementaYZ(self):
        B.incrementaYZ(self)
        print(f"D: incrementaYZ() -> y={self.y}, z={self.z}")
    def incrementaXZ(self):
        A.incrementaXZ(self)

u = D(1, 2, 3)
print("Herencia Múltiple en POO")
print("Incrementar de 3 Números")
print(f"\nValores iniciales: x={u.x}, y={u.y}, z={u.z}")
print()    
u.incrementaYZ()
print(f"Después de incrementaYZ(): x={u.x}, y={u.y}, z={u.z}")
print()      
u.incrementaXYZ()
print(f"Después de incrementaXYZ(): x={u.x}, y={u.y}, z={u.z}")
print()      
u.incrementaXZ()
print(f"Después de incrementaXZ(): x={u.x}, y={u.y}, z={u.z}")
print()      
u.incrementaZ()
print(f"Después de incrementaZ(): x={u.x}, y={u.y}, z={u.z}")
print()  
