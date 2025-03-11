/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicio1_datos1;

import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author migue
 */
public class Ejercicio1_datos1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        Archivo archivoContactos = new Archivo("D:\\Proyectos NetBeans\\ejercicio1_datos1\\src\\ejercicio1_datos1\\contactos.txt");
        boolean run = true;
        while (run) {
            System.out.println("Digite opcion: \n 1. Agregar contacto \n 2. Buscar contacto \n 3. Eliminar contacto");
            int opcion = sc.nextInt();
            switch (opcion) {
                case 1:
                    archivoContactos.agregarContacto();
                break;
                case 2: 
                    archivoContactos.buscarContacto();
                break;
                case 3:
                    archivoContactos.eliminarContacto();
            }
        }
    }

}
