package com.derrap;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.ArrayList;

public class PopUpCrearOrden extends JFrame {
    private ConexionBD conexion;
    private JTable tablaOrdenes;
    private JComboBox<String> cbServicios, cbVehiculos;

    public PopUpCrearOrden(ConexionBD conexion, JTable tablaOrdenes) {
        this.conexion = conexion;
        this.tablaOrdenes = tablaOrdenes;
        initUI();
    }

    private void initUI() {
        setTitle("Crear Nueva Orden");
        setSize(400, 400);
        setLayout(new GridLayout(0, 2, 5, 5));

        // Servicios ComboBox
        DefaultTableModel modeloServicios = conexion.cargarServicios();
        List<String> servicios = new ArrayList<>();
        for (int i = 0; i < modeloServicios.getRowCount(); i++) {
            servicios.add(modeloServicios.getValueAt(i, 0).toString());
        }
        cbServicios = new JComboBox<>(servicios.toArray(new String[0]));
        add(new JLabel("Servicio:"));
        add(cbServicios);

        // Vehículos ComboBox
        DefaultTableModel modeloVehiculos = conexion.cargarVehiculos();
        List<String> vehiculos = new ArrayList<>();
        for (int i = 0; i < modeloVehiculos.getRowCount(); i++) {
            vehiculos.add(modeloVehiculos.getValueAt(i, 0).toString());
        }
        cbVehiculos = new JComboBox<>(vehiculos.toArray(new String[0]));
        add(new JLabel("Vehículo:"));
        add(cbVehiculos);

        JTextField txtReferencia = new JTextField();
        add(new JLabel("Referencia:"));
        add(txtReferencia);

        JTextField txtDescripcion = new JTextField();
        add(new JLabel("Descripción:"));
        add(txtDescripcion);

        JButton btnCrear = new JButton("Crear");
        btnCrear.addActionListener(e -> {
            boolean creado = conexion.crearOrden(
                    txtReferencia.getText(),
                    "Pendiente",
                    "Sin comenzar",
                    new java.util.Date().toString(),
                    cbServicios.getSelectedItem().toString(),
                    cbVehiculos.getSelectedItem().toString(),
                    txtDescripcion.getText()
            );
            if (creado) {
                JOptionPane.showMessageDialog(null, "Orden creada exitosamente.");
                tablaOrdenes.setModel(conexion.cargarOrdenes());
                dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Error al crear la orden.");
            }
        });
        add(btnCrear);

        setLocationRelativeTo(null);
    }
}