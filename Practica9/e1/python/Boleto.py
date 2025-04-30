import tkinter as tk
from tkinter import messagebox
from PIL import Image, ImageTk  

class Boleto:
    def __init__(self, numero):
        self.numero = numero
        self.precio = 0
    def __str__(self):
        return f"Número: {self.numero}, Precio: {self.precio:.1f}"

class Palco(Boleto):
    def __init__(self, numero):
        super().__init__(numero)
        self.precio = 100

class Platea(Boleto):
    def __init__(self, numero, dias_anticipacion):
        super().__init__(numero)
        self.precio = 50 if dias_anticipacion >= 10 else 60

class Galeria(Boleto):
    def __init__(self, numero, dias_anticipacion):
        super().__init__(numero)
        self.precio = 25.00 if dias_anticipacion >= 10 else 30.00

class TeatroMunicipalApp(tk.Tk):
    def __init__(self):
        super().__init__()
        self.title("Teatro Municipal")
        self.geometry("400x400")
        self.tipo_boleto = tk.StringVar(value="Palco")
        self.numero_boleto = tk.StringVar()
        self.dias_anticipacion = tk.IntVar()
        try:
            img_pil = Image.open("teatro.png")
            img_pil = img_pil.resize((80, 80), Image.LANCZOS)
            self.imagen_logo = ImageTk.PhotoImage(img_pil)
        except Exception as e:
            print(f"Error al cargar la imagen: {e}")
            self.imagen_logo = None
        self.frame_titulo = tk.Frame(self)
        self.frame_titulo.pack(pady=10)
        self.label_titulo = tk.Label(self.frame_titulo, text="Teatro Municipal", font=("Arial", 16, "bold"))
        self.label_titulo.pack(side=tk.LEFT)
        if self.imagen_logo:
            self.label_imagen = tk.Label(self.frame_titulo, image=self.imagen_logo)
            self.label_imagen.pack(side=tk.LEFT, padx=10)
        self.frame_datos = tk.LabelFrame(self, text="Datos del Boleto")
        self.frame_datos.pack(pady=10, padx=10)
        self.radio_palco = tk.Radiobutton(self.frame_datos, text="Palco", variable=self.tipo_boleto, value="Palco")
        self.radio_palco.grid(row=0, column=0, padx=5, pady=5, sticky="w")
        self.radio_platea = tk.Radiobutton(self.frame_datos, text="Platea", variable=self.tipo_boleto, value="Platea")
        self.radio_platea.grid(row=0, column=1, padx=5, pady=5, sticky="w")
        self.radio_galeria = tk.Radiobutton(self.frame_datos, text="Galería", variable=self.tipo_boleto, value="Galería")
        self.radio_galeria.grid(row=0, column=2, padx=5, pady=5, sticky="w")
        self.label_numero = tk.Label(self.frame_datos, text="Número:")
        self.label_numero.grid(row=1, column=0, padx=5, pady=5, sticky="e")
        self.entry_numero = tk.Entry(self.frame_datos, textvariable=self.numero_boleto)
        self.entry_numero.grid(row=1, column=1, columnspan=2, padx=5, pady=5, sticky="w")
        self.label_dias = tk.Label(self.frame_datos, text="Cant. Días para el Evento:")
        self.label_dias.grid(row=2, column=0, padx=5, pady=5, sticky="e")
        self.entry_dias = tk.Entry(self.frame_datos, textvariable=self.dias_anticipacion)
        self.entry_dias.grid(row=2, column=1, columnspan=2, padx=5, pady=5, sticky="w")
        self.frame_botones = tk.Frame(self)
        self.frame_botones.pack(pady=10)
        self.button_vender = tk.Button(self.frame_botones, text="Vender", command=self.vender_boleto)
        self.button_vender.pack(side=tk.LEFT, padx=10)
        self.button_salir = tk.Button(self.frame_botones, text="Salir", command=self.destroy)
        self.button_salir.pack(side=tk.LEFT, padx=10)
        self.frame_informacion = tk.LabelFrame(self, text="Información")
        self.frame_informacion.pack(pady=10, padx=10, fill=tk.BOTH, expand=True)
        self.text_info = tk.Text(self.frame_informacion, height=5, width=40, state=tk.DISABLED)
        self.text_info.pack(fill=tk.BOTH, expand=True)

    def vender_boleto(self):
        try:
            numero = int(self.numero_boleto.get())
            if numero <= 0:
                raise ValueError("El número de boleto debe ser mayor que cero.")
            dias = self.dias_anticipacion.get()
            tipo = self.tipo_boleto.get()
            if tipo == "Palco":
                boleto = Palco(numero)
            elif tipo == "Platea":
                boleto = Platea(numero, dias)
            elif tipo == "Galería":
                boleto = Galeria(numero, dias)
            else:
                raise ValueError("Tipo de boleto no válido.")
            self.mostrar_boleto(boleto)
        except ValueError as e:
            messagebox.showerror("Error", str(e))

    def mostrar_boleto(self, boleto):
        self.text_info.config(state=tk.NORMAL)
        self.text_info.delete(1.0, tk.END)
        self.text_info.insert(tk.END, str(boleto))
        self.text_info.config(state=tk.DISABLED)

app = TeatroMunicipalApp()
app.mainloop()
