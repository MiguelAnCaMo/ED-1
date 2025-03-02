package bono3java;

import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author migue
 */
public class Bono3Java {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        Archivo archivoEstudiantes = new Archivo("D:\\Proyectos NetBeans\\bono3Java\\src\\bono3java\\estudiantes.txt");

        boolean run = true;
        int opcion;
        while (run) {
            //cargando datos del .txt por si hay informacion de algun estudiante
            archivoEstudiantes.cargarDatosEstudiantes();

            System.out.println("Digite opcion \n 1. Agregar estudiante \n 2. Agegar nueva calificacion \n 3. Mostrar promedio general del curso");
            opcion = sc.nextInt();
            switch (opcion) {
                case 1:
                    archivoEstudiantes.agregarEstudiante();
                    break;
                case 2:
                    archivoEstudiantes.agregarNota();
                    break;
                case 3:
                    archivoEstudiantes.mostrarPromedioCurso();
                    break;
            }
        }
    }

}
