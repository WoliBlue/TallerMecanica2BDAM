package derrape;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

public class prinAdmin extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					prinAdmin frame = new prinAdmin();
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
	public prinAdmin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1411, 763);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(243, 141, 52));
		panel.setBounds(10, 11, 1385, 713);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(242, 183, 5));
		panel_1.setBounds(0, 0, 244, 713);
		panel.add(panel_1);
		
		JButton btnNewButton = new JButton("Página Principal");
		btnNewButton.setBounds(10, 150, 224, 23);
		
		JButton btnVehculos = new JButton("Vehículos");
		btnVehculos.setBounds(10, 252, 224, 23);
		
		JButton btnClientes = new JButton("Clientes");
		btnClientes.setBounds(10, 184, 224, 23);
		
		JButton btnNewButton_1_1 = new JButton("Órdenes");
		btnNewButton_1_1.setBounds(10, 320, 224, 23);
		
		JButton btnStock = new JButton("Stock");
		btnStock.setBounds(10, 388, 224, 23);
		
		JButton btnNewButton_1_2 = new JButton("Facturación");
		btnNewButton_1_2.setBounds(10, 286, 224, 23);
		
		JButton btnNewButton_2_1 = new JButton("Precio");
		btnNewButton_2_1.setBounds(10, 354, 224, 23);
		
		JButton btnNewButton_1_1_1 = new JButton("Empleados");
		btnNewButton_1_1_1.setBounds(10, 218, 224, 23);
		panel_1.setLayout(null);
		panel_1.add(btnNewButton);
		panel_1.add(btnVehculos);
		panel_1.add(btnClientes);
		panel_1.add(btnNewButton_1_1);
		panel_1.add(btnStock);
		panel_1.add(btnNewButton_1_2);
		panel_1.add(btnNewButton_2_1);
		panel_1.add(btnNewButton_1_1_1);
		
		JLabel lblNewLabel = new JLabel("DERRAP");
		lblNewLabel.setBounds(74, 46, 84, 28);
		panel_1.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 23));
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(242, 183, 5));
		panel_2.setBounds(243, 0, 1142, 106);
		panel.add(panel_2);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(301, 132, 213, 193);
		panel.add(panel_3);
		
		JPanel panel_3_1 = new JPanel();
		panel_3_1.setBounds(857, 132, 225, 193);
		panel.add(panel_3_1);
		
		JPanel panel_3_2 = new JPanel();
		panel_3_2.setBounds(597, 132, 197, 193);
		panel.add(panel_3_2);
		
		JPanel panel_3_3 = new JPanel();
		panel_3_3.setBounds(1138, 132, 204, 193);
		panel.add(panel_3_3);
	}
}
