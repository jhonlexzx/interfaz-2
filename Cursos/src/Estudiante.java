/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author usuario
 */
public class Estudiante {
    private String nombre;
    private String apellido;
    private String idEstudiante;
    private String curso;

    public Estudiante(String nombre, String apellido, String idEstudiante, String curso) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.idEstudiante = idEstudiante;
        this.curso = curso;
    }

    @Override
    public String toString() {
        return nombre + " " + apellido;
    }
}