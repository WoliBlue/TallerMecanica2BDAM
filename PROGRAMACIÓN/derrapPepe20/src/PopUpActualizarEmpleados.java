import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class PopUpActualizarEmpleados extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField txtDni, txtNombre, txtPassword, txtEstado;
    private ConexionBD conexion;

    // Constructor que recibe la información del empleado y la conexión
    public PopUpActualizarEmpleados(ConexionBD conexion,String dni, String nombre, String password,JTable TablaEmpleados) {
        this.conexion = conexion; // Asignar la conexión
        setTitle("Actualizar Empleado");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(243, 141, 52));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        // Etiquetas y campos de texto para mostrar y editar la información del empleado
        JLabel lblDni = new JLabel("DNI:");
        lblDni.setBounds(30, 30, 120, 25);
        contentPane.add(lblDni);

        txtDni = new JTextField(dni);
        txtDni.setBounds(150, 30, 200, 25);
        contentPane.add(txtDni);
        txtDni.setColumns(10);
        txtDni.setEditable(false);  // El DNI no se debe modificar

        JLabel lblNombre = new JLabel("Nombre:");
        lblNombre.setBounds(30, 70, 120, 25);
        contentPane.add(lblNombre);

        txtNombre = new JTextField(nombre);
        txtNombre.setBounds(150, 70, 200, 25);
        contentPane.add(txtNombre);
        txtNombre.setColumns(10);

        JLabel lblPassword = new JLabel("Password:");
        lblPassword.setBounds(30, 110, 120, 25);
        contentPane.add(lblPassword);

        txtPassword = new JTextField(password);
        txtPassword.setBounds(150, 110, 200, 25);
        contentPane.add(txtPassword);
        txtPassword.setColumns(10);

        JLabel lblEstado = new JLabel("Estado:");
        lblEstado.setBounds(30, 157, 120, 25);
        contentPane.add(lblEstado);

        txtEstado = new JTextField("");
        txtEstado.setBounds(150, 157, 200, 25);
        contentPane.add(txtEstado);
        txtEstado.setColumns(10);

        // Botón para actualizar los datos del empleado
        JButton btnActualizar = new JButton("Actualizar");
        btnActualizar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Recuperar los valores de los campos
                String dni = txtDni.getText();
                String nombre = txtNombre.getText();
                String password = txtPassword.getText();
                String estado = txtEstado.getText();

                // Llamar al método de actualización en la clase ConexionBD
                boolean actualizado = conexion.actualizarEmpleado(conexion, dni, nombre, password,estado);

                if (actualizado) {
                    JOptionPane.showMessageDialog(null, "Empleado actualizado exitosamente.");
                } else {
                    JOptionPane.showMessageDialog(null, "Error al actualizar el empleado.");
                }
                TablaEmpleados.setModel(conexion.cargarEmpleados());
                dispose(); // Cerrar la ventana emergente
            }
        });
        btnActualizar.setFont(new Font("Tahoma", Font.BOLD, 11));
        btnActualizar.setBounds(250, 230, 120, 25);
        contentPane.add(btnActualizar);

        // Botón para cancelar la operación
        JButton btnCancelar = new JButton("Cancelar");
        btnCancelar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose(); // Cerrar la ventana emergente sin realizar ninguna acción
            }
        });
        btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 11));
        btnCancelar.setBounds(100, 230, 100, 25);
        contentPane.add(btnCancelar);
    }

   
}
