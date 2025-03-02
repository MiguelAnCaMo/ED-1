/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bono3java;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author migue
 */
class Archivo {

    private static int IDestudiante = 1;
    public String ruta;
    Scanner sc = new Scanner(System.in);
    //estructura para guardar los datos de los estudiantes
    HashMap<Integer, Estudiante> estudiantes = new HashMap<>();

    public Archivo(String ruta) {
        this.ruta = ruta;
    }

    public void agregarEstudiante() throws IOException {
        //crea archivo si este no existe
        File archivoEstudiantes = new File("D:\\Proyectos NetBeans\\bono3Java\\src\\bono3java\\estudiantes.txt");
        BufferedWriter bw;

        if (archivoEstudiantes.exists()) {
            //System.out.println("Ya existe el archivo : )");
        } else {
            bw = new BufferedWriter(new FileWriter(archivoEstudiantes));
            System.out.println("Archivo creado con exito : )");
            bw.close();
        }
        try (FileWriter writer = new FileWriter(ruta, true)) {
            System.out.println("Digite su nombre");
            String tempnombre = sc.nextLine();
            System.out.println("Digite su nota");
            Float tempnota = sc.nextFloat();
            float notaAcumulada = 0;
            notaAcumulada = tempnota + notaAcumulada;
            int tempCantidadNotas = 0;
            tempCantidadNotas++;
            float promedio = notaAcumulada / tempCantidadNotas;
            //escribir los datos del estudiante en una linea del archivo
            writer.write("\n" + IDestudiante + ", " + tempnombre + ", " + String.valueOf(promedio) + ", " + String.valueOf(tempCantidadNotas) + "\n");
            //crea instancia del estudiante y agrega sus datos
            Estudiante estudiante = new Estudiante(IDestudiante, tempnombre, promedio, notaAcumulada);
            estudiantes.put(IDestudiante, estudiante);
            IDestudiante++;
            System.out.println("Estudiante agregado! \n");

        } catch (IOException e) {
            System.out.println("Error");
        }
    }

    //metodo para guardar datos del .txt en un hashmap
    public void cargarDatosEstudiantes() {
        try (BufferedReader reader = new BufferedReader(new FileReader("D:\\Proyectos NetBeans\\bono3Java\\src\\bono3java\\estudiantes.txt"))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] partes = linea.split(", ");
                if (partes.length == 4) {
                    int IDestudiante = Integer.parseInt(partes[0]);
                    String nombre = partes[1];
                    Float promedio = Float.parseFloat(partes[2]);
                    int cantidadNotas = Integer.parseInt(partes[3]);

                    Estudiante estudiante = new Estudiante(IDestudiante, nombre, promedio, cantidadNotas);
                    estudiantes.put(IDestudiante, estudiante);
                }
            }
        } catch (IOException e) {
            System.out.println("No se encontro el archivo : (");
        }
    }

    public void agregarNota() {
        int tempNumeroEstudiante;
        System.out.println("Digite el numero del estudiante, minimo 1:");
        tempNumeroEstudiante = sc.nextInt();
        boolean encontrado = false;
        if (estudiantes.containsKey(tempNumeroEstudiante)) {
            encontrado = true;
            System.out.println("Digite nota del estudiante:");
            float nuevaNota = sc.nextFloat();
            try (BufferedReader reader = new BufferedReader(new FileReader("D:\\Proyectos NetBeans\\bono3Java\\src\\bono3java\\estudiantes.txt"))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] partes = linea.split(", ");
                if (partes.length == 4) {
                    int IDestudiante = Integer.parseInt(partes[0]);                 
                    Float promedio = Float.parseFloat(partes[2]);
                    int cantidadNotas = Integer.parseInt(partes[3]);
                    if (IDestudiante == tempNumeroEstudiante) {
                        
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("No se encontro el archivo : (");
        }
        }
        if (!encontrado) {
            System.out.println("No existe un estudiante con ese numero : (");
        }
    }
    public void mostrarPromedioCurso(){
        try (BufferedReader reader = new BufferedReader(new FileReader("D:\\Proyectos NetBeans\\bono3Java\\src\\bono3java\\estudiantes.txt"))) {
            String linea;
            int nEstudiantes = 0;
            float promedioAcumulado = 0;
            while ((linea = reader.readLine()) != null) {               
                String[] partes = linea.split(", ");
                if (partes.length == 4) {                                
                    float promedioEstudiante = Float.parseFloat(partes[2]);
                    promedioAcumulado = promedioEstudiante + promedioAcumulado;
                    nEstudiantes++;
                }
            }
            System.out.println("Estudiantes: " + nEstudiantes);
            float promedioTotal = promedioAcumulado/nEstudiantes;
            System.out.println("Promedio del curso: " + promedioTotal);
        } catch (IOException e) {
            System.out.println("No se encontro el archivo : (");
        }
    }
}
