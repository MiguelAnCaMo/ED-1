import csv

class Libro:
    def __init__(self, isbn, titulo, autores, categorias):
        self.isbn = isbn
        self.titulo = titulo
        self.autores = autores
        self.categorias = categorias

    def __str__(self):
        return f"ISBN: {self.isbn}, Título: {self.titulo}, Autores: {', '.join(self.autores)}, Categorías: {', '.join(self.categorias)}"

    def to_csv(self):
        #convierte un libro a una lista que pueda escribirse en el .csv
        return [self.isbn, self.titulo, ",".join(self.autores), ",".join(self.categorias)]


class Biblioteca:
    #biblioteca creada para guardas diferentes libros
    def __init__(self, archivo_libros):
        self.libros_por_isbn = {}
        self.libros_por_categoria = {}
        self.archivo_libros = archivo_libros
        #cargar los libros siempre al inicio
        self.cargar_libros()  

    def cargar_libros(self):
        #cargar los libros que esten en el .csv
        try:
            with open(self.archivo_libros, mode='r', newline='', encoding='utf-8') as file:
                reader = csv.reader(file)
                next(reader)  #saltar una linea
                for row in reader:
                    isbn = row[0]
                    titulo = row[1]
                    autores = row[2].split(',')
                    categorias = row[3].split(',')
                    libro = Libro(isbn, titulo, autores, categorias)
                    self.libros_por_isbn[isbn] = libro
                    for categoria in categorias:
                        if categoria not in self.libros_por_categoria:
                            self.libros_por_categoria[categoria] = []
                        self.libros_por_categoria[categoria].append(libro)
            print("Libros cargados exitosamente.")
        except FileNotFoundError:
            print(f"Archivo {self.archivo_libros} no encontrado. Se creará uno nuevo.")

    def guardar_libros(self):
        """Guarda los libros en el archivo CSV"""
        with open(self.archivo_libros, mode='w', newline='', encoding='utf-8') as file:
            writer = csv.writer(file)
            writer.writerow(["ISBN", "Título", "Autores", "Categorías"])
            for libro in self.libros_por_isbn.values():
                writer.writerow(libro.to_csv())  #guardar el libro en el .csv               
        print(f"Libros guardados en {self.archivo_libros}.")

    def registrar_libro(self, isbn, titulo, autores, categorias):
        """Registra un libro asegurando que el ISBN sea único"""
        if isbn in self.libros_por_isbn:
            print(f"Error: El ISBN {isbn} ya está registrado.")
            return

        libro = Libro(isbn, titulo, autores, categorias)
        self.libros_por_isbn[isbn] = libro

        for categoria in categorias:
            if categoria not in self.libros_por_categoria:
                self.libros_por_categoria[categoria] = []
            self.libros_por_categoria[categoria].append(libro)

        self.guardar_libros()  #guardar cambios en el .csv
        print(f"Libro '{titulo}' registrado correctamente.")

    def buscar_por_isbn(self, isbn):
        """Busca un libro por su ISBN"""
        libro = self.libros_por_isbn.get(isbn)
        if libro:
            print(libro)
        else:
            print(f"No se encontró un libro con el ISBN {isbn}.")

    def buscar_por_categoria(self, categoria):
        """Busca libros por categoría"""
        libros = self.libros_por_categoria.get(categoria, [])
        if libros:
            for libro in libros:
                print(libro)
        else:
            print(f"No se encontraron libros en la categoría '{categoria}'.")

    def listar_libros(self):
        """Lista todos los libros registrados, ordenados alfabéticamente por título"""
        libros_ordenados = sorted(self.libros_por_isbn.values(), key=lambda x: x.titulo)
        if libros_ordenados:
            for libro in libros_ordenados:
                print(libro)
        else:
            print("No hay libros registrados en el sistema.")

#funcion para mostrar el menu principal
def mostrar_menu():
    """Muestra las opciones del menú"""
    print("\n--- Menú Sistema de Biblioteca ---")
    print("1. Registrar Libro")
    print("2. Buscar Libro por ISBN")
    print("3. Buscar Libro por Categoría")
    print("4. Listar Todos los Libros")
    print("5. Salir")
    print("---------------------------------")


def menu_principal():
    #archivo .csv donde se guardan los libros
    archivo_libros = "libros.csv"  
    #instancia creada de la biblioteca con archivo
    biblioteca = Biblioteca(archivo_libros)  

    while True:
        mostrar_menu()
        opcion = input("Seleccione una opción (1-5): ")

        if opcion == '1':
            #registra un libro con sus respectivos datos
            isbn = input("Ingrese el ISBN: ")
            titulo = input("Ingrese el título del libro: ")
            autores = input("Ingrese los autores (separados por coma): ").split(',')
            categorias = input("Ingrese las categorías (separadas por coma): ").split(',')
            biblioteca.registrar_libro(isbn, titulo, autores, categorias)

        elif opcion == '2':
            #buscar libro por codigo unico
            isbn = input("Ingrese el ISBN del libro que desea buscar: ")
            biblioteca.buscar_por_isbn(isbn)

        elif opcion == '3':
            #busca libro por categoría
            categoria = input("Ingrese la categoría del libro que desea buscar: ")
            biblioteca.buscar_por_categoria(categoria)

        elif opcion == '4':
            #muestra todos los libros guardados
            biblioteca.listar_libros()

        elif opcion == '5':
            #sale del programa
            print("¡Hasta luego!")
            break

        else:
            print("Opción no válida, por favor ingrese una opción entre 1 y 5.")


#funcion que ejecuta el menu principal
menu_principal()