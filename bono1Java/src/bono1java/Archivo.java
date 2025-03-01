/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bono1java;

import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author migue
 */
public class Archivo {

    private String ruta;
    private String contenido;
    
    public Archivo(String ruta) {
        this.ruta = ruta;
    }

    public void agregarLibro() {
        try ( FileWriter writer = new FileWriter(ruta, true)) {
            writer.write(contenido + "\n");
            
        } catch (IOException e) {
            System.out.println("Error");
        }
    }
    
    public void buscarPorISBN(){
        
    }
}
