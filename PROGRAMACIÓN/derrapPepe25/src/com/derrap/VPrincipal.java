package com.derrap;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import java.awt.CardLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import javax.swing.AbstractAction;
import java.awt.event.KeyEvent;
import javax.swing.Action;

public class VPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private CardLayout cardLayout;
	private JPanel cardPanel;
	private ConexionBD conexion;
	private JTable tablaCliente;
	private JTable tablaVehiculos;
	private JScrollPane scrollPaneVehiculos;
	private JTable tablaOrdenes;
	private JScrollPane scrollPaneOrdenes;
	private JPanel panel_Empleados;
	private JTable tablaEmpleados;
	private JScrollPane scrollPaneEmpleados;
	private JTable tablaStock;
	private JScrollPane scrollPaneStock;
	private JTable tablaFacturas;
	private JScrollPane scrollPaneFacturas;
	private JTable tablaServicios;
	private JScrollPane scrollPaneServicios;

	private JButton btnClientes;
	private JButton btnVehiculos;
	private JButton btnOrden;
	private JButton btnStock;
	private JButton btnFactur;
	private JButton btnEmpleados;
	private JButton btnPagPrin;
	private JButton btnPrecio;
	private JLabel lblControles2;
	private JLabel lblcontroles3;
	private JLabel lblNewGuia;
	private JLabel lblConsulteLaGuia;
	private JLabel lblPeroSobretodoDisfruta;
	private JButton btnCrearCliente;
	private JButton btnCrearEmpleado;
	private JButton btnActualizarEmpleado;
	private JButton btnEliminar_1;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VPopUp frame = new VPopUp();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public VPrincipal(ConexionBD conexion, String nombreUsuario) {
		this.conexion = conexion;

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1411, 763);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setTitle("DERRAP - Tu taller de Confianza");
		contentPane.setLayout(null);

		JLabel lblBienvenido = new JLabel("Bienvenido, " + nombreUsuario);
		lblBienvenido.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblBienvenido.setForeground(Color.WHITE);
		lblBienvenido.setBounds(20, 20, 400, 30);

		JPanel panel_arriba = new JPanel();
		panel_arriba.setBackground(new Color(242, 183, 5));
		panel_arriba.setBounds(243, 0, 1142, 106);
		panel_arriba.setLayout(null);
		panel_arriba.add(lblBienvenido);
		contentPane.add(panel_arriba);

		JLabel lblControles1 = new JLabel("Controles: Q = Clientes, W= Vehiculos, E= Orden");
		lblControles1.setFont(new Font("Consolas", Font.PLAIN, 14));
		lblControles1.setBounds(719, 0, 423, 63);
		panel_arriba.add(lblControles1);

		lblControles2 = new JLabel("R = Precio, T= Stock, Y= Factura");
		lblControles2.setFont(new Font("Consolas", Font.PLAIN, 14));
		lblControles2.setBounds(807, 37, 291, 26);
		panel_arriba.add(lblControles2);

		lblcontroles3 = new JLabel("U = Empleados, ESQ = Pgn Principal");
		lblcontroles3.setFont(new Font("Consolas", Font.PLAIN, 14));
		lblcontroles3.setBounds(806, 55, 292, 26);
		panel_arriba.add(lblcontroles3);

		JLabel lblNewLabel = new JLabel("Inicio de sesión correcto.");
		lblNewLabel.setBounds(20, 81, 149, 14);
		panel_arriba.add(lblNewLabel);

		JPanel panel_izq = new JPanel();
		panel_izq.setBackground(new Color(242, 183, 5));
		panel_izq.setBounds(0, 0, 244, 713);
		contentPane.add(panel_izq);
		panel_izq.setLayout(null);

		btnPagPrin = new JButton("Página Principal");
		btnPagPrin.setBackground(new Color(255, 143, 45));
		btnPagPrin.setFocusPainted(false);
		btnPagPrin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(cardPanel, "PaginaPrincipal");
				setTitle("DERRAP - Tu taller de Confianza");
			}
		});
		btnPagPrin.setBounds(10, 150, 224, 23);
		panel_izq.add(btnPagPrin);

		btnVehiculos = new JButton("Vehículos");
		btnVehiculos.setBackground(new Color(255, 143, 45));
		btnVehiculos.setFocusPainted(false);
		btnVehiculos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setTitle("DERRAP - Apartado Vehiculos");
				cardLayout.show(cardPanel, "Vehiculos");
				tablaVehiculos.setModel(conexion.cargarVehiculos());
			}
		});
		btnVehiculos.setBounds(10, 218, 224, 23);
		panel_izq.add(btnVehiculos);

		tablaCliente = new JTable();
		JScrollPane scrollPane = new JScrollPane(tablaCliente);
		scrollPane.setBounds(192, 67, 723, 508);

		btnClientes = new JButton("Clientes");
		btnClientes.setBackground(new Color(255, 143, 45));
		btnClientes.setFocusPainted(false);
		btnClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(cardPanel, "Clientes");
				setTitle("DERRAP - Apartado Clientes");
				tablaCliente.setModel(conexion.cargarCliente());
			}
		});
		btnClientes.setBounds(10, 184, 224, 23);
		panel_izq.add(btnClientes);

		btnOrden = new JButton("Órdenes");
		btnOrden.setBackground(new Color(255, 143, 45));
		btnOrden.setFocusPainted(false);
		btnOrden.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setTitle("DERRAP - Apartado Ordenes");
				cardLayout.show(cardPanel, "Órdenes");
				tablaOrdenes.setModel(conexion.cargarOrdenes());
			}
		});
		btnOrden.setBounds(10, 252, 224, 23);
		panel_izq.add(btnOrden);

		btnStock = new JButton("Stock");
		btnStock.setBackground(new Color(255, 143, 45));
		btnStock.setFocusPainted(false);
		btnStock.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setTitle("DERRAP - Apartado Stock");
				cardLayout.show(cardPanel, "Stock");
				tablaStock.setModel(conexion.cargarStock());
			}
		});
		btnStock.setBounds(10, 320, 224, 23);
		panel_izq.add(btnStock);

		btnFactur = new JButton("Facturación");
		btnFactur.setBackground(new Color(255, 143, 45));
		btnFactur.setFocusPainted(false);
		btnFactur.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setTitle("DERRAP - Apartado Facturación");
				cardLayout.show(cardPanel, "Facturación");
				tablaFacturas.setModel(conexion.cargarFacturas());
			}
		});
		btnFactur.setBounds(10, 354, 224, 23);
		panel_izq.add(btnFactur);

		btnPrecio = new JButton("Precio");
		btnPrecio.setBackground(new Color(255, 143, 45));
		btnPrecio.setFocusPainted(false);
		btnPrecio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setTitle("DERRAP - Apartado Precio");
				cardLayout.show(cardPanel, "Precio");
				tablaServicios.setModel(conexion.cargarServicios());
			}
		});
		btnPrecio.setBounds(10, 286, 224, 23);
		panel_izq.add(btnPrecio);

		btnEmpleados = new JButton("Empleados");
		btnEmpleados.setBackground(new Color(255, 143, 45));
		btnEmpleados.setFocusPainted(false);
		btnEmpleados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setTitle("DERRAP - Apartado Empleados");
				cardLayout.show(cardPanel, "Empleados");
				tablaEmpleados.setModel(conexion.cargarEmpleados());
			}
		});
		btnEmpleados.setBounds(10, 388, 224, 23);
		panel_izq.add(btnEmpleados);

        ImageIcon icon = new ImageIcon(getClass().getResource("/com/derrap/resources/icon.png"));
        if (icon.getImageLoadStatus() != MediaTracker.COMPLETE) {
            throw new RuntimeException("Icon not found!");
        }		Image image = icon.getImage().getScaledInstance(150, 100, Image.SCALE_SMOOTH);
		icon = new ImageIcon(image);

        JLabel iconoizq = new JLabel(icon);
        iconoizq.setBounds(17, 10, 239, 100);
        panel_izq.add(iconoizq);
        iconoizq.setToolTipText("DERRAP - Sistema de Gestión de Taller");

		JLabel lblCopyright = new JLabel("Copyright LuisJoseSergio S.A");
		lblCopyright.setFont(new Font("Verdana", Font.PLAIN, 12));
		lblCopyright.setBounds(10, 688, 213, 14);
		panel_izq.add(lblCopyright);

		cardLayout = new CardLayout();
		cardPanel = new JPanel(cardLayout);
		cardPanel.setBackground(new Color(243, 141, 52));
		cardPanel.setBounds(243, 106, 1142, 607);
		contentPane.add(cardPanel);

		JPanel panel_PaginaPrincipal = new JPanel();
		panel_PaginaPrincipal.setBackground(new Color(255, 143, 45));
		cardPanel.add(panel_PaginaPrincipal, "PaginaPrincipal");
		panel_PaginaPrincipal.setLayout(null);

		JLabel lblBienvenidoCard = new JLabel("Bienvenido al programa");
		lblBienvenidoCard.setBackground(Color.WHITE);
		lblBienvenidoCard.setForeground(Color.BLACK);
		lblBienvenidoCard.setFont(new Font("Consolas", Font.BOLD, 28));
		lblBienvenidoCard.setBounds(413, 152, 337, 41);
		panel_PaginaPrincipal.add(lblBienvenidoCard);

		JButton btnSalir = new JButton("Salir");
		btnSalir.setFont(new Font("Segoe UI", Font.BOLD, 16));
		btnSalir.setBounds(1017, 551, 84, 23);
		panel_PaginaPrincipal.add(btnSalir);

		lblNewGuia = new JLabel("Interactue con los botones de la izquierda para moverte por el programa.");
		lblNewGuia.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewGuia.setBounds(177, 202, 455, 41);
		panel_PaginaPrincipal.add(lblNewGuia);

		lblConsulteLaGuia = new JLabel("Consulte la guia de botones arriba o cierre sesion pulsando abajo");
		lblConsulteLaGuia.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblConsulteLaGuia.setBounds(522, 239, 403, 41);
		panel_PaginaPrincipal.add(lblConsulteLaGuia);

		lblPeroSobretodoDisfruta = new JLabel("Pero sobretodo, disfruta.");
		lblPeroSobretodoDisfruta.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPeroSobretodoDisfruta.setBounds(475, 276, 157, 41);
		panel_PaginaPrincipal.add(lblPeroSobretodoDisfruta);
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();

				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							DerrapLogin frame = new DerrapLogin();
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});

		JPanel panel_Cliente = new JPanel();
		panel_Cliente.setBackground(new Color(255, 143, 45));
		cardPanel.add(panel_Cliente, "Clientes");
		panel_Cliente.setLayout(null);

		JLabel lblClientes = new JLabel("Estás en Clientes");
		lblClientes.setFont(new Font("Monospaced", Font.PLAIN, 27));
		lblClientes.setBounds(406, 11, 277, 41);
		panel_Cliente.add(lblClientes);

		panel_Cliente.add(scrollPane);

		JButton btnActualizarCli = new JButton("Actualizar");
		btnActualizarCli.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int filaSeleccionada = tablaCliente.getSelectedRow();
					String dni = tablaCliente.getValueAt(filaSeleccionada, 0).toString();
					String nombre = tablaCliente.getValueAt(filaSeleccionada, 1).toString();
					VPopUp PopUpActualizar = new VPopUp(conexion, tablaCliente, dni, nombre);
					PopUpActualizar.setVisible(true);
					PopUpActualizar.setLocationRelativeTo(null);
				}catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Tienes que PINCHAR lo que quieres actualizar. Zopenco.");
					System.out.println(ex);
				}
				 /*
				if (filaSeleccionada >= 0) {
					String dni = tablaCliente.getValueAt(filaSeleccionada, 0).toString();
					conexion.actualizarCliente(dni, tablaCliente);
					tablaCliente.setModel(conexion.cargarCliente());
				} else {
					JOptionPane.showMessageDialog(null, "Tienes que PINCHAR lo que quieres actualizar. Zopenco.");
				}
				*/
				
				
			}
		});
		btnActualizarCli.setFont(new Font("MS PGothic", Font.PLAIN, 19));
		btnActualizarCli.setBounds(925, 205, 183, 23);
		panel_Cliente.add(btnActualizarCli);
		
		btnCrearCliente = new JButton("Crear Cliente");
		btnCrearCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					VPopUpCrearCliente PopUpCrearCliente = new VPopUpCrearCliente(conexion, tablaCliente);
					PopUpCrearCliente.setVisible(true);
					PopUpCrearCliente.setLocationRelativeTo(null);
				}catch (Exception ex) {
					System.out.println(ex);
				}
				
			}
		});
		btnCrearCliente.setFont(new Font("MS PGothic", Font.PLAIN, 19));
		btnCrearCliente.setBounds(925, 159, 183, 23);
		panel_Cliente.add(btnCrearCliente);

		JPanel panel_Vehiculo = new JPanel();
		panel_Vehiculo.setBackground(new Color(255, 143, 45));
		cardPanel.add(panel_Vehiculo, "Vehiculos");
		panel_Vehiculo.setLayout(null);

		JLabel lblVehiculos = new JLabel("Estás en Vehículos");
		lblVehiculos.setFont(new Font("Monospaced", Font.PLAIN, 27));
		lblVehiculos.setBounds(454, 98, 293, 41);
		panel_Vehiculo.add(lblVehiculos);

		tablaVehiculos = new JTable();
		scrollPaneVehiculos = new JScrollPane(tablaVehiculos);
		scrollPaneVehiculos.setBounds(208, 149, 661, 371);
		panel_Vehiculo.add(scrollPaneVehiculos);
		
		JButton btnActualizarVehiculo = new JButton("ActualizarVehiculo");
		btnActualizarVehiculo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int filaSeleccionada = tablaVehiculos.getSelectedRow();
					String matricula = tablaVehiculos.getValueAt(filaSeleccionada, 0).toString();
					String marca = tablaVehiculos.getValueAt(filaSeleccionada, 1).toString();
					String modelo = tablaVehiculos.getValueAt(filaSeleccionada, 2).toString();
					String clienteDNI = tablaVehiculos.getValueAt(filaSeleccionada, 3).toString();
					PopUpActualizarVehiculo PopUpActualizarVehiculo = new PopUpActualizarVehiculo(conexion, tablaVehiculos,matricula,marca,modelo,clienteDNI);
					PopUpActualizarVehiculo.setVisible(true);
					PopUpActualizarVehiculo.setLocationRelativeTo(null);
				}catch (Exception ex) {
					System.out.println(ex);
				}
			}
		});
		btnActualizarVehiculo.setFont(new Font("MS PGothic", Font.PLAIN, 19));
		btnActualizarVehiculo.setBounds(926, 244, 183, 23);
		panel_Vehiculo.add(btnActualizarVehiculo);
		
		JButton btnCrearVehiculo = new JButton("Crear Vehiculo");
		btnCrearVehiculo.setBackground(new Color(242, 207, 102));
		btnCrearVehiculo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					VPopUpCrearVehiculo CrearVehiculo = new VPopUpCrearVehiculo(conexion,tablaVehiculos);
					CrearVehiculo.setVisible(true);
					CrearVehiculo.setLocationRelativeTo(null);
				}catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Tienes que PINCHAR lo que quieres actualizar. Zopenco.");
					System.out.println(ex);
				}
			}
		});
		btnCrearVehiculo.setFont(new Font("MS PGothic", Font.PLAIN, 19));
		btnCrearVehiculo.setBounds(926, 198, 183, 23);
		panel_Vehiculo.add(btnCrearVehiculo);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int fila = tablaVehiculos.getSelectedRow();
				String matricula = (String) tablaVehiculos.getValueAt(fila, 0);
				
				conexion.eliminarVehiculo(matricula);
				tablaVehiculos.setModel(conexion.cargarVehiculos());
			}
		});
		btnEliminar.setFont(new Font("MS PGothic", Font.PLAIN, 19));
		btnEliminar.setBounds(926, 291, 183, 23);
		panel_Vehiculo.add(btnEliminar);

		JPanel panel_Ordenes = new JPanel();
		panel_Ordenes.setBackground(new Color(255, 143, 45));
		cardPanel.add(panel_Ordenes, "Órdenes");
		panel_Ordenes.setLayout(null);

		JLabel lblOrdenes = new JLabel("Estás en Órdenes");
		lblOrdenes.setFont(new Font("Monospaced", Font.PLAIN, 27));
		lblOrdenes.setBounds(448, 128, 277, 41);
		panel_Ordenes.add(lblOrdenes);
		
		JButton btnCrearOrden = new JButton("Crear Orden");
		btnCrearOrden.addActionListener(e -> {
		    PopUpCrearOrden popup = new PopUpCrearOrden(conexion, tablaOrdenes);
		    popup.setVisible(true);
		});
		btnCrearOrden.setBounds(906, 180, 113, 52);
		panel_Ordenes.add(btnCrearOrden);
		
		JButton btnEliminarOrden = new JButton("Eliminar Orden");
		btnEliminarOrden.addActionListener(e -> {
		    int fila = tablaOrdenes.getSelectedRow();
		    if (fila >= 0) {
		        String referencia = tablaOrdenes.getValueAt(fila, 0).toString();
		        if (conexion.eliminarOrden(referencia)) {
		            tablaOrdenes.setModel(conexion.cargarOrdenes());
		        }
		    }
		});
		btnEliminarOrden.setBounds(906, 243, 113, 52);
		panel_Ordenes.add(btnEliminarOrden);

		tablaOrdenes = new JTable();
		scrollPaneOrdenes = new JScrollPane(tablaOrdenes);
		scrollPaneOrdenes.setBounds(259, 180, 637, 357);
		panel_Ordenes.add(scrollPaneOrdenes);

		JPanel panel_Precio = new JPanel();
		panel_Precio.setBackground(new Color(255, 143, 45));
		cardPanel.add(panel_Precio, "Precio");
		panel_Precio.setLayout(null);

		JLabel lblPrecio = new JLabel("Estás en Precio");
		lblPrecio.setFont(new Font("Monospaced", Font.PLAIN, 27));
		lblPrecio.setBounds(448, 128, 277, 41);
		panel_Precio.add(lblPrecio);

		tablaServicios = new JTable();
		scrollPaneServicios = new JScrollPane(tablaServicios);
		scrollPaneServicios.setBounds(393, 229, 415, 291);
		panel_Precio.add(scrollPaneServicios);

		JPanel panel_Stock = new JPanel();
		panel_Stock.setBackground(new Color(255, 143, 45));
		cardPanel.add(panel_Stock, "Stock");
		panel_Stock.setLayout(null);

		JLabel lblStock = new JLabel("Estás en Shock, y también en Stock");
		lblStock.setFont(new Font("Monospaced", Font.PLAIN, 27));
		lblStock.setBounds(355, 130, 616, 41);
		panel_Stock.add(lblStock);
		
		JButton btnCrearPieza = new JButton("Crear Pieza");
		btnCrearPieza.addActionListener(e -> {
		    PopUpCrearPieza popup = new PopUpCrearPieza(conexion, tablaStock);
		    popup.setVisible(true);
		});
		btnCrearPieza.setBounds(851, 229, 145, 41);
		panel_Stock.add(btnCrearPieza);
		

		tablaStock = new JTable();
		scrollPaneStock = new JScrollPane(tablaStock);
		scrollPaneStock.setBounds(393, 229, 415, 291);
		panel_Stock.add(scrollPaneStock);

		JButton btnActualizarStock = new JButton("Actualizar Stock");
		btnActualizarStock.setFont(new Font("MS PGothic", Font.PLAIN, 19));
		btnActualizarStock.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int filaSeleccionada = tablaStock.getSelectedRow();
				if (filaSeleccionada >= 0) {
					int idPieza = Integer.parseInt(tablaStock.getValueAt(filaSeleccionada, 0).toString());
					String nuevoStock = JOptionPane.showInputDialog("Ingrese el nuevo stock (e.g., '150 litros'):");
					if (nuevoStock != null && !nuevoStock.isEmpty()) {
						boolean actualizado = conexion.actualizarStock(idPieza, nuevoStock);
						if (actualizado) {
							JOptionPane.showMessageDialog(null, "Stock actualizado correctamente.");
							tablaStock.setModel(conexion.cargarStock());
						} else {
							JOptionPane.showMessageDialog(null, "Error al actualizar el stock.");
						}
					}
				} else {
					JOptionPane.showMessageDialog(null, "Tienes que PINCHAR lo que quieres actualizar. Zopenco.");
				}
			}
		});
		btnActualizarStock.setBounds(393, 530, 183, 23);
		panel_Stock.add(btnActualizarStock);

		JPanel panel_Facturacion = new JPanel();
		panel_Facturacion.setBackground(new Color(255, 143, 45));
		cardPanel.add(panel_Facturacion, "Facturación");
		panel_Facturacion.setLayout(null);

		JLabel lblFacturacion = new JLabel("Estás en Facturación");
		lblFacturacion.setFont(new Font("Monospaced", Font.PLAIN, 27));
		lblFacturacion.setBounds(469, 177, 339, 41);
		panel_Facturacion.add(lblFacturacion);

		tablaFacturas = new JTable();
		scrollPaneFacturas = new JScrollPane(tablaFacturas);
		scrollPaneFacturas.setBounds(393, 229, 415, 291);
		panel_Facturacion.add(scrollPaneFacturas);

		panel_Empleados = new JPanel();
		panel_Empleados.setBackground(new Color(255, 143, 45));
		cardPanel.add(panel_Empleados, "Empleados");
		panel_Empleados.setLayout(null);

		JLabel lblEmpleados = new JLabel("Estás en Empleados");
		lblEmpleados.setFont(new Font("Monospaced", Font.PLAIN, 27));
		lblEmpleados.setBounds(431, 32, 302, 41);
		panel_Empleados.add(lblEmpleados);

		tablaEmpleados = new JTable();
		scrollPaneEmpleados = new JScrollPane(tablaEmpleados);
		scrollPaneEmpleados.setBounds(153, 83, 655, 437);
		panel_Empleados.add(scrollPaneEmpleados);
		
		btnCrearEmpleado = new JButton("Crear Empleado");
		btnCrearEmpleado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					PopUpCrearEmpleado PopUpCrearMecanico = new PopUpCrearEmpleado(conexion, tablaEmpleados);
					PopUpCrearMecanico.setVisible(true);
					PopUpCrearMecanico.setLocationRelativeTo(null);
				}catch (Exception ex) {
					System.out.println(ex);
					JOptionPane.showMessageDialog(null, "Tienes que PINCHAR lo que quieres actualizar. Zopenco.");
				}
				
			}
		});
		btnCrearEmpleado.setFont(new Font("MS PGothic", Font.PLAIN, 19));
		btnCrearEmpleado.setBounds(888, 251, 183, 23);
		panel_Empleados.add(btnCrearEmpleado);
		
		btnActualizarEmpleado = new JButton("Actualizar Empleado");
		btnActualizarEmpleado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				int fila = tablaEmpleados.getSelectedRow();
				String dni= (String) tablaEmpleados.getValueAt(fila, 1);
				String nombre =(String) tablaEmpleados.getValueAt(fila, 0);
				String Password = (String) tablaEmpleados.getValueAt(fila, 2);
				
				PopUpActualizarEmpleados actualizarEmpleados = new PopUpActualizarEmpleados(conexion,dni,nombre,Password,tablaEmpleados);
				actualizarEmpleados.setVisible(true);
				actualizarEmpleados.setLocationRelativeTo(lblFacturacion);
				}catch (Exception ex) {
					System.out.println(ex);
					
				}
				
			}
		});
		btnActualizarEmpleado.setFont(new Font("MS PGothic", Font.PLAIN, 19));
		btnActualizarEmpleado.setBounds(869, 297, 212, 23);
		panel_Empleados.add(btnActualizarEmpleado);
		
		btnEliminar_1 = new JButton("Eliminar");
		btnEliminar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int fila = tablaEmpleados.getSelectedRow();
				String dni = (String) tablaEmpleados.getValueAt(fila, 1);
				
				conexion.eliminarEmpleado(dni);
				tablaEmpleados.setModel(conexion.cargarEmpleados());
				
			}
		});
		btnEliminar_1.setFont(new Font("MS PGothic", Font.PLAIN, 19));
		btnEliminar_1.setBounds(888, 344, 183, 23);
		panel_Empleados.add(btnEliminar_1);

		cardLayout.show(cardPanel, "PaginaPrincipal");

		teclasteclado();
	}

	private void teclasteclado() {
		añadirteclateclado("Q", btnClientes);
		añadirteclateclado("W", btnVehiculos);
		añadirteclateclado("E", btnOrden);
		añadirteclateclado("R", btnPrecio);
		añadirteclateclado("T", btnStock);
		añadirteclateclado("Y", btnFactur);
		añadirteclateclado("U", btnEmpleados);

		añadirteclateclado("ESCAPE", btnPagPrin);
	}

	private void añadirteclateclado(String key, JButton button) {
		Action action = new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				button.doClick();
			}
		};

		contentPane.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(key), key);
		contentPane.getActionMap().put(key, action);
	}
}