package derrape;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JCheckBox;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class logIn extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtusuario;
	private JPasswordField txtcontrasenia;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					logIn frame = new logIn();
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
	public logIn() {
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 403, 401);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(243, 141, 52));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblContraseña = new JLabel("Introduzca contraseña");
		lblContraseña.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblContraseña.setBounds(135, 182, 204, 24);
		contentPane.add(lblContraseña);
		
		txtusuario = new JTextField();
		txtusuario.setToolTipText("DNI");
		txtusuario.setBounds(151, 100, 86, 20);
		contentPane.add(txtusuario);
		txtusuario.setColumns(10);
		
		txtcontrasenia = new JPasswordField();
		txtcontrasenia.setToolTipText("contraseña");
		txtcontrasenia.setBounds(145, 217, 101, 20);
		contentPane.add(txtcontrasenia);
		
		JLabel lblNewLabel_1 = new JLabel("Inicio de Sesion");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(148, 65, 123, 24);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblinicio = new JLabel("DERRAP");
		lblinicio.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblinicio.setBounds(166, 30, 123, 24);
		contentPane.add(lblinicio);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Recuérdame");
		chckbxNewCheckBox.setBounds(135, 245, 97, 23);
		contentPane.add(chckbxNewCheckBox);
		
		JLabel lblNewLabel = new JLabel("¿Tienes problemas? Contacte con el Administrador");
		lblNewLabel.setBounds(90, 275, 261, 14);
		contentPane.add(lblNewLabel);
		
		JButton btnlogin = new JButton("Log In");
		btnlogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				char [] password = txtcontrasenia.getPassword();
				String passwordstring = new String(password);
				if (txtusuario.getText().equals("ADMIN")&& passwordstring.equals("ADMIN")) {
					// abrimos nueva ventana 
						JFrame prinAdmin = new prinAdmin();
						prinAdmin.setVisible(true);
						prinAdmin.setLocationRelativeTo(null);
				}else {
					JOptionPane.showMessageDialog(null, "Contraseña incorrecta");
				}
			}
		});
		btnlogin.setBounds(148, 150, 89, 23);
		contentPane.add(btnlogin);
	}
}
