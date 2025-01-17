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

public class VPopUp extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private String dni;
	private String nombre;
	private String apellidos;
	private String telefono;
	private JTextField txtDni;
	private JTextField txtNombre;
	private ConexionBD conexion;

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

	/**
	 * Create the frame.
	 */
	public VPopUp() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 143, 45));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDNI = new JLabel("DNI");
		lblDNI.setBounds(98, 63, 103, 27);
		contentPane.add(lblDNI);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(211, 63, 103, 27);
		contentPane.add(lblNombre);
		
		txtDni = new JTextField();
		txtDni.setBounds(98, 101, 89, 27);
		contentPane.add(txtDni);
		txtDni.setColumns(10);
		
		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		txtNombre.setBounds(211, 101, 89, 27);
		contentPane.add(txtNombre);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nuevoDni = txtDni.getText();
				String nuevoNombre = txtNombre.getText();
				
			}
		});
		btnAceptar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnAceptar.setBounds(211, 195, 89, 23);
		contentPane.add(btnAceptar);
		
		JButton btnAtrs = new JButton("Atrás");
		btnAtrs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			dispose();
			}
		});
		btnAtrs.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnAtrs.setBounds(98, 195, 89, 23);
		contentPane.add(btnAtrs);
		
	}
	public VPopUp(ConexionBD conexion, String dni, String nombre) {
		this.conexion = conexion;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 143, 45));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		
		
		JLabel lblDNI = new JLabel("DNI");
		lblDNI.setBounds(98, 63, 103, 27);
		contentPane.add(lblDNI);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(211, 63, 103, 27);
		contentPane.add(lblNombre);
		
		txtDni = new JTextField();
		txtDni.setBounds(98, 101, 103, 27);
		contentPane.add(txtDni);
		txtDni.setColumns(10);
		txtDni.setText(dni);
		
		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		txtNombre.setBounds(211, 101, 103, 27);
		contentPane.add(txtNombre);
		txtNombre.setText(nombre);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nuevoDni = txtDni.getText();
				String nuevoNombre = txtNombre.getText();
				conexion.actualizarCliente(dni, nuevoDni, nuevoNombre);
				dispose();
			}
		});
		btnAceptar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnAceptar.setBounds(211, 195, 89, 23);
		contentPane.add(btnAceptar);

		
		JButton btnAtrs = new JButton("Atrás");
		btnAtrs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			dispose();
			}
		});
		btnAtrs.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnAtrs.setBounds(98, 195, 89, 23);
		contentPane.add(btnAtrs);

	}
}
