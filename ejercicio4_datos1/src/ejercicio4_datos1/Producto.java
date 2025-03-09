/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio4_datos1;

/**
 *
 * @author migue
 */
public class Producto {
    
    String nombre;
    int cantidadVendida;
    float precio;
    int id;

    public Producto(int id, String nombre, int cantidadVendida, float precio) {   
        this.id = id;
        this.nombre = nombre;
        this.cantidadVendida = cantidadVendida;
        this.precio = precio;
    }
  
}
