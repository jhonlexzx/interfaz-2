/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author usuario
 */
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class EscuelaApp extends JFrame {
    private JTabbedPane tabbedPane;
    private ArrayList<Curso> cursos;
    private ArrayList<Profesor> profesores;
    private ArrayList<Estudiante> estudiantes;
    private ArrayList<Asignatura> asignaturas;
    private ArrayList<Evaluacion> evaluaciones;
    private ArrayList<Horario> horarios;
    private DefaultListModel<String> cursoModel;
    private DefaultListModel<String> profesorModel;
    private DefaultListModel<String> estudianteModel;
    private DefaultListModel<String> asignaturaModel;
    private DefaultListModel<String> evaluacionModel;
    private DefaultListModel<String> horarioModel;

    public EscuelaApp() {
        setTitle("Registro Académico");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);

        cursos = new ArrayList<>();
        profesores = new ArrayList<>();
        estudiantes = new ArrayList<>();
        asignaturas = new ArrayList<>();
        evaluaciones = new ArrayList<>();
        horarios = new ArrayList<>();

        cursoModel = new DefaultListModel<>();
        profesorModel = new DefaultListModel<>();
        estudianteModel = new DefaultListModel<>();
        asignaturaModel = new DefaultListModel<>();
        evaluacionModel = new DefaultListModel<>();
        horarioModel = new DefaultListModel<>();

        tabbedPane = new JTabbedPane();
        tabbedPane.setFont(new Font("Helvetica", Font.BOLD, 12));
        tabbedPane.add("Cursos", createCursoPanel());
        tabbedPane.add("Profesores", createProfesorPanel());
        tabbedPane.add("Estudiantes", createEstudiantePanel());
        tabbedPane.add("Asignaturas", createAsignaturaPanel());
        tabbedPane.add("Evaluaciones", createEvaluacionPanel());
        tabbedPane.add("Horarios", createHorarioPanel());

        add(tabbedPane);
    }

    private JPanel createCursoPanel() {
        String[] fields = {"Nombre", "Profesor", "Horario"};
        return createEntryPanel(fields, "Registrar Curso", cursoModel, this::registrarCurso);
    }

    private JPanel createProfesorPanel() {
        String[] fields = {"Nombre", "Apellido"};
        return createEntryPanel(fields, "Registrar Profesor", profesorModel, this::registrarProfesor);
    }

    private JPanel createEstudiantePanel() {
        String[] fields = {"Nombre", "Apellido", "ID Estudiante", "Curso"};
        return createEntryPanel(fields, "Registrar Estudiante", estudianteModel, this::registrarEstudiante);
    }

    private JPanel createAsignaturaPanel() {
        String[] fields = {"Nombre", "Profesor"};
        return createEntryPanel(fields, "Registrar Asignatura", asignaturaModel, this::registrarAsignatura);
    }

    private JPanel createEvaluacionPanel() {
        String[] fields = {"Curso", "Estudiante", "Nota"};
        return createEntryPanel(fields, "Registrar Evaluación", evaluacionModel, this::registrarEvaluacion);
    }

    private JPanel createHorarioPanel() {
        String[] fields = {"Día"};
        return createEntryPanel(fields, "Registrar Horario", horarioModel, this::registrarHorario);
    }

    private JPanel createEntryPanel(String[] fields, String buttonText, DefaultListModel<String> listModel, ActionListener actionListener) {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setBackground(new Color(230, 247, 255));
        JPanel formPanel = new JPanel(new GridBagLayout());
        formPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        formPanel.setBackground(new Color(230, 247, 255));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JTextField[] textFields = new JTextField[fields.length];
        for (int i = 0; i < fields.length; i++) {
            gbc.gridx = 0;
            gbc.gridy = i;
            formPanel.add(new JLabel(fields[i]), gbc);
            gbc.gridx = 1;
            textFields[i] = new JTextField(20);
            formPanel.add(textFields[i], gbc);
        }

        JButton button = new JButton(buttonText);
        button.addActionListener(e -> actionListener.actionPerformed(new ActionEvent(textFields, ActionEvent.ACTION_PERFORMED, null)));
        gbc.gridx = 0;
        gbc.gridy = fields.length;
        gbc.gridwidth = 2;
        formPanel.add(button, gbc);

        panel.add(formPanel, BorderLayout.NORTH);
        JList<String> list = new JList<>(listModel);
        panel.add(new JScrollPane(list), BorderLayout.CENTER);

        return panel;
    }

    private void registrarCurso(ActionEvent e) {
        JTextField[] textFields = (JTextField[]) e.getSource();
        String nombre = textFields[0].getText();
        String profesor = textFields[1].getText();
        String horario = textFields[2].getText();
        if (!nombre.isEmpty() && !profesor.isEmpty() && !horario.isEmpty()) {
            Curso curso = new Curso(nombre, profesor, horario);
            cursos.add(curso);
            cursoModel.addElement(nombre);
            clearFields(textFields);
        }
    }

    private void registrarProfesor(ActionEvent e) {
        JTextField[] textFields = (JTextField[]) e.getSource();
        String nombre = textFields[0].getText();
        String apellido = textFields[1].getText();
        if (!nombre.isEmpty() && !apellido.isEmpty()) {
            Profesor profesor = new Profesor(nombre, apellido);
            profesores.add(profesor);
            profesorModel.addElement(nombre + " " + apellido);
            clearFields(textFields);
        }
    }

    private void registrarEstudiante(ActionEvent e) {
        JTextField[] textFields = (JTextField[]) e.getSource();
        String nombre = textFields[0].getText();
        String apellido = textFields[1].getText();
        String idEstudiante = textFields[2].getText();
        String curso = textFields[3].getText();
        if (!nombre.isEmpty() && !apellido.isEmpty() && !idEstudiante.isEmpty() && !curso.isEmpty()) {
            Estudiante estudiante = new Estudiante(nombre, apellido, idEstudiante, curso);
            estudiantes.add(estudiante);
            estudianteModel.addElement(nombre + " " + apellido);
            clearFields(textFields);
        }
    }

    private void registrarAsignatura(ActionEvent e) {
        JTextField[] textFields = (JTextField[]) e.getSource();
        String nombre = textFields[0].getText();
        String profesor = textFields[1].getText();
        if (!nombre.isEmpty() && !profesor.isEmpty()) {
            Asignatura asignatura = new Asignatura(nombre, profesor);
            asignaturas.add(asignatura);
            asignaturaModel.addElement(nombre);
            clearFields(textFields);
        }
    }

    private void registrarEvaluacion(ActionEvent e) {
        JTextField[] textFields = (JTextField[]) e.getSource();
        String curso = textFields[0].getText();
        String estudiante = textFields[1].getText();
        String nota = textFields[2].getText();
        if (!curso.isEmpty() && !estudiante.isEmpty() && !nota.isEmpty()) {
            Evaluacion evaluacion = new Evaluacion(curso, estudiante, nota);
            evaluaciones.add(evaluacion);
            evaluacionModel.addElement(curso + " - " + estudiante + " - " + nota);
            clearFields(textFields);
        }
    }

    private void registrarHorario(ActionEvent e) {
        JTextField[] textFields = (JTextField[]) e.getSource();
        String dia = textFields[0].getText();
        if (!dia.isEmpty()) {
            Horario horario = new Horario(dia); // Adjust this line according to your Horario class requirements
            horarios.add(horario);
            horarioModel.addElement(dia);
            clearFields(textFields);
        }
    }

    private void clearFields(JTextField[] fields) {
        for (JTextField field : fields) {
            field.setText("");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            EscuelaApp escuelaApp = new EscuelaApp();
            escuelaApp.setVisible(true);
        });
    }
}
