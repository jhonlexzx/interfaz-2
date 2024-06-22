/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author usuario
 */
public class Asignatura {
    private String nombre;
    private String profesor;

    public Asignatura(String nombre, String profesor) {
        this.nombre = nombre;
        this.profesor = profesor;
    }

    @Override
    public String toString() {
        return nombre;
    }
}
