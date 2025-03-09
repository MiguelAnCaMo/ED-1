package ejercicio4_datos1;

import java.util.Scanner;

/**
 *
 * @author migue
 */
public class Ejercicio4_datos1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Archivo archivo = new Archivo("D:\\Proyectos NetBeans\\ejercicio3_datos1\\src\\ejercicio4_datos1\\productos.txt");
        boolean run = true;
        while (run) {
            System.out.println("Digite opcion \n 1. Agregar producto \n 2. Ver productos \n 3. Buscar producto por ID");
            int opcion = sc.nextInt();
            switch (opcion) {
                case 1:
                    archivo.agregarProducto();
                    break;
                case 2:
                    archivo.mostrarProductos();
                    break;
                case 3:
                    archivo.buscarPorCodigo();
                    break;
            }
        }
    }

}
