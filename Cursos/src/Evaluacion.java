/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author usuario
 */
public class Evaluacion {
    private String curso;
    private String estudiante;
    private String nota;

    public Evaluacion(String curso, String estudiante, String nota) {
        this.curso = curso;
        this.estudiante = estudiante;
        this.nota = nota;
    }

    @Override
    public String toString() {
        return curso + " - " + estudiante + " - " + nota;
    }
}
