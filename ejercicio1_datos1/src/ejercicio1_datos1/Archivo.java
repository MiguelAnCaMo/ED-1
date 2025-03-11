/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio1_datos1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author migue
 */
public class Archivo {
    private String ruta;
  
    public Archivo(String ruta) {
        this.ruta = ruta;
    }
    
    private ArrayList <Contacto> contactos = new ArrayList<>();
    Scanner sc = new Scanner(System.in);
    
    public void agregarContacto() throws IOException {       
        try (FileWriter fw = new FileWriter(ruta, true); BufferedWriter bw = new BufferedWriter(fw)) {
            System.out.println("Ingrese nombre de contacto:");
            String nombre = sc.nextLine();            
            System.out.println("Ingrese telefono de contacto:");
            String telefono = sc.nextLine();           
            System.out.println("Ingrese correo de contacto:");
            String correo = sc.nextLine();         
            Contacto contacto = new Contacto(nombre, telefono, correo);
            contactos.add(contacto);
            bw.write(contacto.toString() + "\n");
            bw.close();
        } catch (Exception e) {
            System.out.println("error xd");
            System.out.println(e);
        }          
    }
    
    public void buscarContacto(){       
        try (FileReader fr = new FileReader(ruta); BufferedReader br = new BufferedReader(fr)) {
           System.out.println("Digite el telefono del contacto a buscar:");
           String telefonoBuscar = sc.nextLine();
           String datos [];
           String linea;          
            while ((linea = br.readLine()) != null) {
               datos = linea.split(", ");
                if (datos[1].equals(telefonoBuscar)) {                   
                    System.out.println("Se encontro el contacto!");
                    System.out.println("Telefono encontrado: " + linea);
                    return;
                }                
            }
        } catch (Exception e) {
            System.out.println("Error");
            System.out.println(e);
        }    
    }
    public void eliminarContacto() {
        ArrayList <Contacto> contactos2 = new ArrayList<>();
        ArrayList <String> lineas = new ArrayList<>();
        try (FileReader fr = new FileReader(ruta); BufferedReader br = new BufferedReader(fr)) {
            System.out.println("Digita el telefono del contacto a eliminar");
            String contactoEliminar = sc.nextLine();
            String linea;
            String datos []; 
             while ((linea = br.readLine()) != null) {
               datos = linea.split(", ");
                if (!datos[1].equals(contactoEliminar)) {                    
                    Contacto contacto = new Contacto(datos[0], datos[1], datos[2]);
                    contactos2.add(contacto);
                }                
            }                                                      
        } catch (Exception e) {
            System.out.println("error xd: " + e);
        } 
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ruta))) {
            for (Contacto contacto : contactos2) {
                bw.write(contacto.toString());
                bw.newLine();
            }
            System.out.println("Contacto eliminado");
        } catch (IOException e) {

        }
    } 
}