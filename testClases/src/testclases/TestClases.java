/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package testclases;

import java.util.ArrayList;

/**
 *
 * @author migue
 */
public class TestClases {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {         
        ArrayList<Humano> humanos = new ArrayList<>();
        Humano h1 = new Humano("Pepe",18);
        Humano h2 = new Humano("Juan",20);
        h1.saludar();
        h2.saludar();
        h1.depedirse();
        h2.depedirse();
        
        //prueba metodo split()
        /*
        String filaHipotetica = "Juan, 18, 2007";
        String datos [] = filaHipotetica.split(", ");  
        for (String s : datos) {
            System.out.println(s);
        }
        String nombre = datos [0];
        System.out.println("Nombre: " + nombre);
        */
    }
  
}
