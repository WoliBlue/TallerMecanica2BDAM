import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.CardLayout;

public class VPopUp extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtDni;
	private JTextField txtNombre;
	private ConexionBD conexion;
	private String dni;
	private String nombre;
	private JTable tabla;
	
	// Constructor principal
	public VPopUp() {
		initialize();
	}
	
	// Constructor con parámetros
	public VPopUp(ConexionBD conexion, JTable tabla, String dni, String nombre) {
		this.conexion = conexion;
		this.dni = dni;
		this.nombre = nombre;
		this.tabla = tabla;
		initialize();
	}
	
	// Método para inicializar y organizar todos los elementos
	private void initialize() {
		setTitle("DERRAP - Tu tallllllllllller de confianza");
		// Configuración de la ventana principal
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 742, 585);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 143, 45));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// Etiquetas (labels) para DNI y Nombre
		JLabel lblDNI = new JLabel("DNI");
		lblDNI.setBounds(98, 63, 103, 27);
		contentPane.add(lblDNI);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(211, 63, 103, 27);
		contentPane.add(lblNombre);

		// Campos de texto (text fields) para el DNI y Nombre
		txtDni = new JTextField();
		txtDni.setBounds(98, 101, 103, 27);
		contentPane.add(txtDni);
		txtDni.setColumns(10);
		if (dni != null) {
			txtDni.setText(dni);  // Pre-cargar si existe el DNI
		}

		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		txtNombre.setBounds(211, 101, 103, 27);
		contentPane.add(txtNombre);
		if (nombre != null) {
			txtNombre.setText(nombre);  // Pre-cargar si existe el Nombre
		}

		// Botón "Aceptar" para confirmar los cambios
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nuevoDni = txtDni.getText();
				String nuevoNombre = txtNombre.getText();
				conexion.actualizarCliente(dni, nuevoDni, nuevoNombre);
				tabla.setModel(conexion.cargarCliente());
				dispose();  // Cerrar la ventana
			}
		});
		btnAceptar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnAceptar.setBounds(211, 195, 89, 23);
		contentPane.add(btnAceptar);

		// Botón "Atrás" para cerrar la ventana sin hacer cambios
		JButton btnAtrs = new JButton("Atrás");
		btnAtrs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();  // Cerrar la ventana
			}
		});
		btnAtrs.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnAtrs.setBounds(98, 195, 89, 23);
		contentPane.add(btnAtrs);
	}

	
}
