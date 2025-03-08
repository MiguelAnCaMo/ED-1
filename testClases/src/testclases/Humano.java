/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package testclases;

/**
 *
 * @author migue
 */
public class Humano {
    private String nombre;
    private int edad;

    public Humano(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }
    public void saludar(){
        System.out.println("Hola, soy un Humano");
    }         
    public void depedirse(){
        System.out.println("Chao");
    }
}
