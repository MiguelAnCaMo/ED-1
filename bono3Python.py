import csv

#variable global id incia en 1
ID = 1

class Estudiante:
    def __init__(self, ID ,nombre ,promedio, notas):
       self.ID = ID 
       self.nombre = str(nombre)
       self.promedio = float(promedio)
       self.notas = [float(nota) for nota in notas]
    
    def __str__(self):
        # Cambiar el formato para mostrar los detalles del estudiante
        return f"ID: {self.ID}, Nombre: {self.nombre}, Promedio: {self.promedio}, Notas: {', '.join(map(str, self.notas))}"

    def to_csv(self):      
        #convierte un estudiante a una lista que pueda escribirse en el .csv
        return [self.ID, self.nombre, self.promedio, self.notas]
    
    def agregar_nota(self, nueva_nota):
        # añade la nueva nota y recalcula el promedio
        self.notas.append(float(nueva_nota))
        self.promedio = sum(self.notas) / len(self.notas)

class Archivo:

    def __init__(self, nombre):
      self.nombre = nombre
      #inicia ID en 1 para el primer estudiante
      self.ID = 1      
      
    def registrar_Estudiante(self, estudiantes):
       #abrir archivo llamado archivo jeje
       archivo = open(self.nombre, "a")          
       print("Escriba su nombre:")
       tempNombre = input() #ingresa datos temporales para cada estudiante
       print("Ingrese su nota:")
       tempNota = float(input())  
       notasTemp = [tempNota]      
       sumaNotas = 0.0
        #calcula promedio con las notas del estudiante
       for nota in notasTemp:
          sumaNotas += nota

       promedio = sumaNotas/len(notasTemp)
       #se crea instancia de estudiante con sus datos
       estudiante = Estudiante(self.ID, tempNombre, promedio, notasTemp)

       #se agrega la instancia a una lista de estudiantes
       listaEstudiantes.append(estudiante)

       #se escribe en una linea del archivo los datos de este estudiante
       archivo.write(f"{estudiante.ID},{tempNombre},{promedio},{','.join(map(str, notasTemp))}\n")
       print("Estudiante agregado! Id:",self.ID," Nombre:",tempNombre,", Nota agregada: ",tempNota)
       self.ID += 1         
       archivo.close()

    def mostrar_Estudiantes(self):
       #abriendo archivo
       archivo = open(self.nombre, "r")
       #muestra los estudiantes que esten actualmente en el archivo
       print("Estudiantes registrados: \n")
       
       for linea in archivo:
          print(linea)   
       archivo.close()

    #metodo para mostrar el promedio general
    def mostrar_PromedioGeneral(self):
       archivo = open(self.nombre)
       datos = []
       promedios = [float]
       promedioGeneral = 0
       #guardar promedios en una lista que contenga floats
       for linea in archivo:
          datos = linea.strip().split(',')
          promedioTemp = float(datos[2]) 
          #acumulando promedios en variable promedioGeneral
          promedioGeneral += promedioTemp
          promedios.append(promedioTemp)
       archivo.close()
       
       cantEstudiantes = (len(promedios)-1)          
       print("Promedio general: ",promedioGeneral/cantEstudiantes)
   
    #agrega nota al estudiante
    def agregar_nota(self, estudiantes):
       # Abrir el archivo en modo lectura
       archivo = open(self.nombre, "r")
    
       idBuscar = int(input("Digite numero del estudiante a buscar: "))
       encontrado = False  #para controlar si ha sido encontrado
    
       #leer todas las líneas del archivo
       lineas = archivo.readlines()  
       archivo.close()
    
       for i, linea in enumerate(lineas):
           datos = linea.strip().split(',')
           ID = int(datos[0])
           nombre = datos[1]
           promedio = float(datos[2])
           notas = [float(nota) for nota in datos[3].split()]

           #si se encuentra al estudiante por su id
           if ID == idBuscar:
             estudiante = Estudiante(ID, nombre, promedio, notas)
             print(f"Estudiante encontrado: {estudiante}")
            
             #pedir agregar una nueva nota
             nueva_nota = float(input("Ingrese la nueva nota: "))
             estudiante.agregar_nota(nueva_nota)  #actualiza promedio
            
             print(f"Datos actualizados del estudiante: {estudiante}")
            
             # reemplazamos la línea del estudiante con los datos actualizados
             lineas[i] = f"{estudiante.ID},{estudiante.nombre},{estudiante.promedio},{','.join(map(str, estudiante.notas))}\n"
             encontrado = True
             break  # Ya hemos encontrado y actualizado al estudiante, salimos del bucle
    
        #si no se encontró el estudiante
       if not encontrado:
           print(f"No se encontró un estudiante con ID: {idBuscar}")
    
        # escribe las líneas actualizadas de vuelta al archivo
       archivo = open(self.nombre, "w")
       archivo.writelines(lineas)  #sobrescribe el archivo con las líneas nuevas
       archivo.close()
           

archivo = Archivo("estudiantes.csv")
listaEstudiantes = [] #lista que gurdará a los estudiantes

def menu_Principal():
     
     run = True
     while run:
         print("Ingrese opcion:\n 1. Agregar estudiante \n 2. Ver estudiantes \n 3. Agregar nota \n 4. Mostrar promedio general")
         opcion = int(input())
         if opcion == 1:                  
             archivo.registrar_Estudiante(listaEstudiantes)
         elif opcion == 2:
             archivo.mostrar_Estudiantes()
         elif opcion == 3:
             archivo.agregar_nota(listaEstudiantes)
         elif opcion == 4:
             archivo.mostrar_PromedioGeneral()
         else: 
          print("No hay una opcion para el valor ingresado...")

menu_Principal()