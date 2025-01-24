package com.derrap;
import javax.swing.JFrame;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.CardLayout;

public class VPopUpCrearCliente extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtDni;
	private JTextField txtNombre;
	private ConexionBD conexion;
	private String dni;
	private String nombre;
	private JTable tabla;
	
	// Constructor principal
		public VPopUpCrearCliente() {
			getContentPane().setBackground(new Color(243, 141, 52));
		}
		// Constructor con parámetros
		public VPopUpCrearCliente(ConexionBD conexion, JTable tabla) {
			setTitle("DERRAP - Crear Cliente");
			// Inicialización del JFrame
	        setTitle("Crear Nuevo Cliente");
	        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	        setBounds(100, 100, 450, 350);
	        contentPane = new JPanel();
	        contentPane.setBackground(new Color(243, 141, 52));
	        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	        setContentPane(contentPane);
	        contentPane.setLayout(null);

	        // Etiquetas para los campos
	        JLabel lblDNI = new JLabel("DNI (PK):");
	        lblDNI.setBounds(50, 30, 120, 25);
	        contentPane.add(lblDNI);

	        JLabel lblNombre = new JLabel("Nombre:");
	        lblNombre.setBounds(50, 70, 120, 25);
	        contentPane.add(lblNombre);

	        JLabel lblApellidos = new JLabel("Apellidos:");
	        lblApellidos.setBounds(50, 110, 120, 25);
	        contentPane.add(lblApellidos);

	        JLabel lblTelefono = new JLabel("Teléfono:");
	        lblTelefono.setBounds(50, 150, 120, 25);
	        contentPane.add(lblTelefono);

	        // Campos de texto para ingresar los datos
	        txtDni = new JTextField();
	        txtDni.setBounds(180, 30, 200, 25);
	        contentPane.add(txtDni);
	        txtDni.setColumns(10);

	        txtNombre = new JTextField();
	        txtNombre.setBounds(180, 70, 200, 25);
	        contentPane.add(txtNombre);

	        JTextField txtApellidos = new JTextField();  // Corregido
	        txtApellidos.setBounds(180, 110, 200, 25);  // Corregido
	        contentPane.add(txtApellidos);  // Corregido

	        JTextField txtTelefono = new JTextField();   // Corregido
	        txtTelefono.setBounds(180, 150, 200, 25);   // Corregido
	        contentPane.add(txtTelefono);   // Corregido
			
	        // Botón para aceptar y crear el cliente
	        JButton btnCrear = new JButton("Crear");
	        btnCrear.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                String nuevoDni = txtDni.getText();
	                String nuevoNombre = txtNombre.getText();
	                String nuevoApellidos = txtApellidos.getText();  // Corregido
	                String nuevoTelefonoStr = txtTelefono.getText();
	                int telefono = Integer.parseInt(nuevoTelefonoStr);
	                try {
	                	conexion.Conexion_Correcta();
	                	
	                    
	                    boolean creado = conexion.crearCliente(nuevoDni, nuevoNombre, nuevoApellidos, telefono);
	                    if (creado) {
	                        JOptionPane.showMessageDialog(null, "Cliente creado exitosamente.");
	                        tabla.setModel(conexion.cargarCliente()); // Actualiza la tabla con el nuevo cliente
	                       
	                    } else {
	                        JOptionPane.showMessageDialog(null, "Error al crear el cliente.");
	                    }
	                } catch (NumberFormatException ex) {
	                    JOptionPane.showMessageDialog(null, "Teléfono inválido.");
	                }
	                dispose(); // Cierra la ventana emergente después de crear el cliente
	            }
	        });
	        btnCrear.setFont(new Font("Tahoma", Font.BOLD, 11));
	        btnCrear.setBounds(250, 200, 89, 25);
	        contentPane.add(btnCrear);

	        // Botón para cancelar o cerrar el pop-up
	        JButton btnCancelar = new JButton("Cancelar");
	        btnCancelar.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                dispose(); // Cierra el pop-up sin realizar ninguna acción
	            }
	        });
	        btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 11));
	        btnCancelar.setBounds(100, 200, 89, 25);
	        contentPane.add(btnCancelar);
	    }

	  
	}
