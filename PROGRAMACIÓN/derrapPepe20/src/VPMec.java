import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
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

public class VPMec extends JFrame {

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
	private JTable tablaStock;
	private JScrollPane scrollPaneStock;

	private JButton btnClientes;
	private JButton btnVehiculos;
	private JButton btnOrden;
	private JButton btnStock;
	private JLabel lblControles2;
	private JLabel lblcontroles3;
	private JButton btnCrearCliente;

	public VPMec(ConexionBD conexion, String nombreUsuario, String dni) {
		this.conexion = conexion;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1411, 763);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setTitle("DERRAP - Tu taller de Confianza (MECANICO)");
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
				tablaOrdenes.setModel(conexion.cargarOrdenes(nombreUsuario));
			}
		});
		btnOrden.setBounds(10, 151, 224, 23);
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
		btnStock.setBounds(10, 251, 224, 23);
		panel_izq.add(btnStock);

		ImageIcon icon = new ImageIcon(getClass().getResource("/resources/Icon.png"));
		Image image = icon.getImage().getScaledInstance(150, 100, Image.SCALE_SMOOTH);
		icon = new ImageIcon(image);

		JLabel iconoizq = new JLabel(new ImageIcon(VPMec.class.getResource("/resources/Icon.png")));
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

		JPanel panel_Ordenes = new JPanel();
		panel_Ordenes.setBackground(new Color(255, 143, 45));
		cardPanel.add(panel_Ordenes, "Órdenes");
		panel_Ordenes.setLayout(null);

		JLabel lblOrdenes = new JLabel("Estás en Órdenes");
		lblOrdenes.setFont(new Font("Monospaced", Font.PLAIN, 27));
		lblOrdenes.setBounds(363, 10, 277, 41);
		panel_Ordenes.add(lblOrdenes);

		tablaOrdenes = new JTable();
		scrollPaneOrdenes = new JScrollPane(tablaOrdenes);
		scrollPaneOrdenes.setBounds(112, 82, 762, 457);
		panel_Ordenes.add(scrollPaneOrdenes);
		tablaOrdenes.setModel(conexion.cargarOrdenes(nombreUsuario));

		JButton btnAsignarOrden = new JButton("Asignar Orden");
		btnAsignarOrden.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int filaSeleccionada = tablaOrdenes.getSelectedRow();
				String referencia = tablaOrdenes.getValueAt(filaSeleccionada, 0).toString();
				String estado = tablaOrdenes.getValueAt(filaSeleccionada, 4).toString();
				if (estado.equals("Pendiente")) {
					conexion.asignarOrden(referencia, dni);
					tablaOrdenes.setModel(conexion.cargarOrdenes(nombreUsuario));
				} else {
					JOptionPane.showMessageDialog(null, "Ya está asignada");
				}
			}
		});
		btnAsignarOrden.setFont(new Font("MS PGothic", Font.PLAIN, 19));
		btnAsignarOrden.setBounds(923, 152, 183, 23);
		panel_Ordenes.add(btnAsignarOrden);

		JButton btnDesasignarOrden = new JButton("Desasignar Orden");
		btnDesasignarOrden.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int filaSeleccionada = tablaOrdenes.getSelectedRow();
				String referencia = tablaOrdenes.getValueAt(filaSeleccionada, 0).toString();
				String estado = tablaOrdenes.getValueAt(filaSeleccionada, 4).toString();
				if (estado.equals("Asignada")) {
					conexion.desasignarOrden(referencia);
					tablaOrdenes.setModel(conexion.cargarOrdenes(nombreUsuario));
				} else {
					JOptionPane.showMessageDialog(null, "No está asignada");
				}
			}
		});
		btnDesasignarOrden.setFont(new Font("MS PGothic", Font.PLAIN, 19));
		btnDesasignarOrden.setBounds(923, 185, 183, 23);
		panel_Ordenes.add(btnDesasignarOrden);

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
					VPopUp v1 = new VPopUp(conexion, tablaCliente, dni, nombre);
					v1.setVisible(true);
					v1.setLocationRelativeTo(null);
				} catch (Exception ex) {
					System.out.println(ex);
				}
				/*
				 * if (filaSeleccionada >= 0) { String dni =
				 * tablaCliente.getValueAt(filaSeleccionada, 0).toString();
				 * conexion.actualizarCliente(dni, tablaCliente);
				 * tablaCliente.setModel(conexion.cargarCliente()); } else {
				 * JOptionPane.showMessageDialog(null,
				 * "Tienes que PINCHAR lo que quieres actualizar. Zopenco."); }
				 */

			}
		});
		btnActualizarCli.setFont(new Font("MS PGothic", Font.PLAIN, 19));
		btnActualizarCli.setBounds(925, 205, 183, 23);
		panel_Cliente.add(btnActualizarCli);

		btnCrearCliente = new JButton("Crear Cliente");
		btnCrearCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VPopUp crearClente = new VPopUp();

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
		scrollPaneVehiculos.setBounds(393, 229, 415, 291);
		panel_Vehiculo.add(scrollPaneVehiculos);

		JPanel panel_Stock = new JPanel();
		panel_Stock.setBackground(new Color(255, 143, 45));
		cardPanel.add(panel_Stock, "Stock");
		panel_Stock.setLayout(null);

		JLabel lblStock = new JLabel("Estás en Shock, y también en Stock");
		lblStock.setFont(new Font("Monospaced", Font.PLAIN, 27));
		lblStock.setBounds(243, 174, 616, 41);
		panel_Stock.add(lblStock);

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

		cardLayout.show(cardPanel, "PaginaPrincipal");

		teclasteclado();
	}

	private void teclasteclado() {
		añadirteclateclado("Q", btnClientes);
		añadirteclateclado("W", btnVehiculos);
		añadirteclateclado("E", btnOrden);
		añadirteclateclado("T", btnStock);
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