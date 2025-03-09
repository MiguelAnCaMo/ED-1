package ejercicio4_datos1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author migue
 */
public class Archivo {

    private String ruta;
    private static int id = 1; 

    public Archivo(String ruta) {
        this.ruta = ruta;
    }
    Scanner sc = new Scanner(System.in);
    HashMap<Integer ,Producto> listaProductos = new HashMap<>();

    public void agregarProducto() {
        try (FileWriter writer = new FileWriter(ruta, true)) {
            writer.write(id + ", ");
            System.out.println("Digite el nombre del producto");
            String nombre = sc.nextLine();
            writer.write(nombre + ", ");
            System.out.println("Digite la cantidad vendida del producto");
            int cantidadVendida = sc.nextInt();
            writer.write(cantidadVendida + ", ");
            System.out.println("Digite el precio del producto");
            float precio = sc.nextFloat();
            writer.write(precio + "\n");
            Producto producto = new Producto(id, nombre, cantidadVendida, precio);
            listaProductos.put(id, producto);
            id++;
            System.out.println("Producto agregado con exito");
            writer.close();
        } catch (Exception e) {
            System.out.println("Error");
        }
    }

    public void mostrarProductos() {
        System.out.println("Productos: \n");
        try (FileReader reader = new FileReader(ruta); BufferedReader br = new BufferedReader(reader);) {
            String linea;        
            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
            }
        } catch (Exception e) {

        }

    }
    public void buscarPorCodigo() {
        System.out.println("Ingresa el codigo a buscar, minimo desde 1:");
        int codigoBuscar = sc.nextInt();                   
          if (listaProductos.containsKey(codigoBuscar)) {  
              System.out.println(listaProductos.get(codigoBuscar));
          } else {
              System.out.println("No se encuentra el producto con ese codigo : (");
          }
    }
}
    
