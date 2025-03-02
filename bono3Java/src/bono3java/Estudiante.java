package bono3java;

/**
 *
 * @author migue
 */
public class Estudiante {

    private String nombre;
    private float nota;
    private int cantidadNotas;
    private float promedio;
    private float notaAcumuladas;
    private int ID;

    public Estudiante(int ID, String nombre, float promedio, float notasAcumuladas) {
        this.ID = ID;
        this.nombre = nombre;
        this.cantidadNotas = cantidadNotas;
        this.notaAcumuladas = notaAcumuladas;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setNota(float nota) {
        this.nota = nota;
    }

    public float getNotaAcumuladas() {
        return notaAcumuladas;
    }

    public void setPromedio(float promedio) {
        this.promedio = promedio;
    }

}
