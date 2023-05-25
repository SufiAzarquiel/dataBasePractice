package org.sufiAzarquiel.verduleros.ui;

import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class Ventana extends JFrame {

    private JPanel contentPane;
    private JTable table;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                    Ventana frame = new Ventana();
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
    public Ventana() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 366);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 196, 414, -183);
        contentPane.add(scrollPane);

        table = new JTable();
        table.setModel(new DefaultTableModel(
                new Object[][]{
                        {null, null, null, null}
                },
                new String[]{
                        "IdProducto", "Nombre", "Grupo", "Precio"
                }
        ));
        table.setBounds(20, 108, 247, -83);
        contentPane.add(table);

        JLabel lblID = new JLabel("IdProducto");
        lblID.setBounds(10, 171, 67, 14);
        contentPane.add(lblID);

        JLabel lblNombre = new JLabel("Nombre");
        lblNombre.setBounds(10, 196, 46, 14);
        contentPane.add(lblNombre);

        JLabel lblGrupo = new JLabel("Grupo");
        lblGrupo.setBounds(10, 221, 46, 14);
        contentPane.add(lblGrupo);

        JLabel lblPrecio = new JLabel("Precio");
        lblPrecio.setBounds(10, 246, 46, 14);
        contentPane.add(lblPrecio);

        textField = new JTextField();
        textField.setBounds(87, 165, 86, 20);
        contentPane.add(textField);
        textField.setColumns(10);

        textField_1 = new JTextField();
        textField_1.setBounds(87, 193, 86, 20);
        contentPane.add(textField_1);
        textField_1.setColumns(10);

        textField_2 = new JTextField();
        textField_2.setBounds(87, 243, 86, 20);
        contentPane.add(textField_2);
        textField_2.setColumns(10);

        JComboBox comboBox = new JComboBox();
        comboBox.setBounds(87, 218, 86, 20);
        contentPane.add(comboBox);

        JButton btnModificar = new JButton("Modificar");
        btnModificar.setBounds(305, 273, 119, 43);
        contentPane.add(btnModificar);
    }
}
