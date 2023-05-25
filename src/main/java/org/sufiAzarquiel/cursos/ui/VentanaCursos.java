package org.sufiAzarquiel.cursos.ui;

import org.sufiAzarquiel.cursos.dao.DAOAlumnos;
import org.sufiAzarquiel.cursos.entities.Alumno;

import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class VentanaCursos extends JFrame {

    private JPanel contentPane;
    private JTextField textFieldNota;
    private JTextField textFieldObservaciones;
    private JTable tableAlumnos;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    VentanaCursos frame = new VentanaCursos();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public VentanaCursos() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 608, 481);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblAlumno = new JLabel("Seleccione Alumno:");
        lblAlumno.setHorizontalAlignment(SwingConstants.RIGHT);
        lblAlumno.setBounds(115, 45, 120, 14);
        contentPane.add(lblAlumno);

        JLabel lblCurso = new JLabel("Seleccione Curso:");
        lblCurso.setHorizontalAlignment(SwingConstants.RIGHT);
        lblCurso.setBounds(115, 83, 120, 14);
        contentPane.add(lblCurso);

        JLabel lblNota = new JLabel("Nota:");
        lblNota.setHorizontalAlignment(SwingConstants.RIGHT);
        lblNota.setBounds(115, 116, 120, 14);
        contentPane.add(lblNota);

        JLabel lblObservaciones = new JLabel("Observaciones:");
        lblObservaciones.setHorizontalAlignment(SwingConstants.RIGHT);
        lblObservaciones.setBounds(115, 141, 120, 14);
        contentPane.add(lblObservaciones);

        JComboBox comboBoxAlumno = new JComboBox();
        comboBoxAlumno.setBounds(245, 41, 236, 22);
        contentPane.add(comboBoxAlumno);

        JComboBox comboBoxCurso = new JComboBox();
        comboBoxCurso.setBounds(245, 79, 236, 22);
        contentPane.add(comboBoxCurso);

        textFieldNota = new JTextField();
        textFieldNota.setBounds(245, 113, 86, 20);
        contentPane.add(textFieldNota);
        textFieldNota.setColumns(10);

        textFieldObservaciones = new JTextField();
        textFieldObservaciones.setBounds(245, 138, 279, 36);
        contentPane.add(textFieldObservaciones);
        textFieldObservaciones.setColumns(10);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 416, 572, -218);
        contentPane.add(scrollPane);

        tableAlumnos = new JTable();
        tableAlumnos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tableAlumnos.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent arg0) {
                cargarTablaAlumnos();
            }
        });

        tableAlumnos.setModel(new DefaultTableModel(
                new Object[][] {
                        {null, null, null, null},
                        {null, null, null, null},
                },
                new String[] {
                        "Alumno", "Curso", "Nota", "Observaciones"
                }
        ) {
            Class[] columnTypes = new Class[] {
                    String.class, String.class, Integer.class, String.class
            };
            public Class getColumnClass(int columnIndex) {
                return columnTypes[columnIndex];
            }
            boolean[] columnEditables = new boolean[] {
                    false, false
            };
            public boolean isCellEditable(int row, int column) {
                return columnEditables[column];
            }
        });
        tableAlumnos.getColumnModel().getColumn(0).setPreferredWidth(216);
        tableAlumnos.getColumnModel().getColumn(1).setPreferredWidth(159);
        tableAlumnos.getColumnModel().getColumn(2).setPreferredWidth(114);
        tableAlumnos.getColumnModel().getColumn(3).setPreferredWidth(217);
        tableAlumnos.setBounds(0, 0, 1, 1);
        scrollPane.setViewportView(tableAlumnos);


    }

    private void cargarTablaAlumnos() {
        ArrayList<Alumno> alumnos = new ArrayList<Alumno>();
        alumnos = DAOAlumnos.get();

        Object[][] datos = new Object[alumnos.size()][4];
        for(int i=0;i<alumnos.size();i++) {
            // TODO: set table data
        }
        tableAlumnos.setModel(new DefaultTableModel(
                datos,
                new String[] {
                        "Alumno", "Curso", "Nota", "Observaciones"
                }
        ) {
            Class[] columnTypes = new Class[] {
                    String.class, String.class, Integer.class, String.class
            };
            public Class getColumnClass(int columnIndex) {
                return columnTypes[columnIndex];
            }
            boolean[] columnEditables = new boolean[] {
                    false, false, false, false
            };
            public boolean isCellEditable(int row, int column) {
                return columnEditables[column];
            }
        });
        tableAlumnos.getColumnModel().getColumn(0).setResizable(false);
        tableAlumnos.getColumnModel().getColumn(1).setResizable(false);
        tableAlumnos.getColumnModel().getColumn(2).setResizable(false);
        tableAlumnos.getColumnModel().getColumn(3).setResizable(false);
    }

}