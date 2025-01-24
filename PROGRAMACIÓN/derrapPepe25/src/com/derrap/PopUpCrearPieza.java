package com.derrap;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PopUpCrearPieza extends JFrame {

    private ConexionBD conexion; // Database connection
    private JTable tablaStock;   // Table to refresh after adding a new part

    // Input fields
    private JTextField txtIdPieza;
    private JTextField txtNombrePieza;
    private JTextField txtStock;

    public PopUpCrearPieza(ConexionBD conexion, JTable tablaStock) {
        this.conexion = conexion;
        this.tablaStock = tablaStock;
        initUI();
    }

    private void initUI() {
        setTitle("Crear Nueva Pieza"); // Window title
        setSize(400, 300);             // Window size
        setLayout(new GridLayout(0, 2, 10, 10)); // Grid layout for form

        // Label and field for ID
        JLabel lblIdPieza = new JLabel("ID Pieza:");
        txtIdPieza = new JTextField();
        add(lblIdPieza);
        add(txtIdPieza);

        // Label and field for Name
        JLabel lblNombrePieza = new JLabel("Nombre Pieza:");
        txtNombrePieza = new JTextField();
        add(lblNombrePieza);
        add(txtNombrePieza);

        // Label and field for Stock
        JLabel lblStock = new JLabel("Stock:");
        txtStock = new JTextField();
        add(lblStock);
        add(txtStock);

        // Button to create the part
        JButton btnCrear = new JButton("Crear");
        btnCrear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                crearPieza();
            }
        });
        add(btnCrear);

        // Button to cancel and close the window
        JButton btnCancelar = new JButton("Cancelar");
        btnCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // Close the window
            }
        });
        add(btnCancelar);

        // Center the window on the screen
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Close only this window
    }

    private void crearPieza() {
        try {
            // Get values from the input fields
            int idPieza = Integer.parseInt(txtIdPieza.getText());
            String nombrePieza = txtNombrePieza.getText();
            String stock = txtStock.getText();

            // Call the method to create the part in the database
            boolean creado = conexion.crearPieza(idPieza, nombrePieza, stock);

            if (creado) {
                JOptionPane.showMessageDialog(this, "Pieza creada exitosamente.");
                // Refresh the stock table
                tablaStock.setModel(conexion.cargarStock());
                dispose(); // Close the window after successful creation
            } else {
                JOptionPane.showMessageDialog(this, "Error al crear la pieza.");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "El ID de la pieza debe ser un número.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        }
    }
}