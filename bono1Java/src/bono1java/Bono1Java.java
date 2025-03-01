/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package bono1java;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author migue
 */
public class Bono1Java {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        
        //crea archivo si este no existe
        File archivoLibros = new File("D:\\NetBeansProjects\\bono1Java\\src\\bono1java\\libros.txt");
        BufferedWriter bw;
        if (archivoLibros.exists()) {
        } else {
            bw = new BufferedWriter(new FileWriter(archivoLibros));
            bw.close();
        }

        //estructura hashmap para guardar los ids e informacion del libro
        HashMap<Integer, String> libros = new HashMap<>();

        boolean run = true;
        int opcion;

        while (run == true) {
            System.out.println("Digite opcion: \n 1. Agregar libro \n 2. Consultar codigo unico");
            opcion = sc.nextInt();
            switch (opcion) {
                case 1: 

                case 2:

                case 3:
            }
        }

    }

}
