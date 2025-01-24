package com.derrap;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PopUpCrearEmpleado extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField txtDni;
    private JTextField txtNombre;
    private JPasswordField txtPassword;
    private ConexionBD conexion;
    private JTable tablaEmpleados;

    // Constructor
    public PopUpCrearEmpleado(ConexionBD conexion, JTable tablaEmpleados) {
    	setTitle("DERRAP - Crear Empleado");
        this.conexion = conexion;
        this.tablaEmpleados = tablaEmpleados;

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 350);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(243, 141, 52));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        // Etiqueta y campo para el DNI
        JLabel lblDni = new JLabel("DNI:");
        lblDni.setBounds(50, 30, 120, 25);
        contentPane.add(lblDni);

        txtDni = new JTextField();
        txtDni.setBounds(180, 30, 200, 25);
        contentPane.add(txtDni);
        txtDni.setColumns(10);

        // Etiqueta y campo para el Nombre
        JLabel lblNombre = new JLabel("Nombre:");
        lblNombre.setBounds(50, 70, 120, 25);
        contentPane.add(lblNombre);

        txtNombre = new JTextField();
        txtNombre.setBounds(180, 70, 200, 25);
        contentPane.add(txtNombre);
        txtNombre.setColumns(10);

        // Etiqueta y campo para la Contraseña
        JLabel lblPassword = new JLabel("Contraseña:");
        lblPassword.setBounds(50, 110, 120, 25);
        contentPane.add(lblPassword);

        txtPassword = new JPasswordField();
        txtPassword.setBounds(180, 110, 200, 25);
        contentPane.add(txtPassword);

        // Botón Crear
        JButton btnCrear = new JButton("Crear");
        btnCrear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Obtie	ne los datos de los campos
                String dni = txtDni.getText();
                String nombre = txtNombre.getText();
                String password = new String(txtPassword.getPassword());
              

                // Llamar al método para crear el empleado
                boolean creado = conexion.crearEmpleado(dni, nombre, password);

                if (creado) {
                    JOptionPane.showMessageDialog(null, "Empleado creado exitosamente.");
                    // Actualizar la tabla con la nueva información de empleados
                    tablaEmpleados.setModel(conexion.cargarEmpleados());
                } else {
                    JOptionPane.showMessageDialog(null, "Error al crear el empleado.");
                }
                dispose(); // Cierra la ventana emergente
            }
        });
        btnCrear.setBounds(260, 210, 120, 25);
        contentPane.add(btnCrear);

        // Botón Cancelar
        JButton btnCancelar = new JButton("Cancelar");
        btnCancelar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose(); // Cierra el pop-up sin realizar ninguna acción
            }
        });
        btnCancelar.setBounds(70, 210, 100, 25);
        contentPane.add(btnCancelar);
    }
}
