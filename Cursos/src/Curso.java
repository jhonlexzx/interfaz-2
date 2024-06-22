/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author usuario
 */
public class Curso {
    private String nombre;
    private String profesor;
    private String horario;

    public Curso(String nombre, String profesor, String horario) {
        this.nombre = nombre;
        this.profesor = profesor;
        this.horario = horario;
    }

    @Override
    public String toString() {
        return nombre;
    }
}
