
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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VPrincipal frame = new VPrincipal();
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
	public VPrincipal() {

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

		JButton btnPagPrin = new JButton("Página Principal");
		btnPagPrin.setBounds(10, 150, 224, 23);

		JButton btnVehiculos = new JButton("Vehículos");
		btnVehiculos.setBounds(10, 218, 224, 23);

		JButton btnClientes = new JButton("Clientes");
		btnClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnClientes.setBounds(10, 184, 224, 23);

		JButton btnOrden = new JButton("Órdenes");
		btnOrden.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnOrden.setBounds(10, 252, 224, 23);

		JButton btnStock = new JButton("Stock");
		btnStock.setBounds(10, 320, 224, 23);

		JButton btnFactur = new JButton("Facturación");
		btnFactur.setVisible(false);
		btnFactur.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnFactur.setBounds(10, 354, 224, 23);

		JButton btnPrecio = new JButton("Precio");
		btnPrecio.setBounds(10, 286, 224, 23);

		JButton btnEmpleados = new JButton("Empleados");
		btnEmpleados.setBounds(10, 388, 224, 23);
		panel_1.setLayout(null);
		panel_1.add(btnPagPrin);
		panel_1.add(btnVehiculos);
		panel_1.add(btnClientes);
		panel_1.add(btnOrden);
		panel_1.add(btnStock);
		panel_1.add(btnFactur);
		panel_1.add(btnPrecio);
		panel_1.add(btnEmpleados);

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

	public VPrincipal(String perfil) {
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

		JButton btnPagPrin = new JButton("Página Principal");
		btnPagPrin.setBounds(10, 150, 224, 23);

		JButton btnVehiculos = new JButton("Vehículos");
		btnVehiculos.setBounds(10, 218, 224, 23);

		JButton btnClientes = new JButton("Clientes");
		btnClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnClientes.setBounds(10, 184, 224, 23);

		JButton btnOrden = new JButton("Órdenes");
		btnOrden.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnOrden.setBounds(10, 252, 224, 23);

		JButton btnStock = new JButton("Stock");
		btnStock.setBounds(10, 320, 224, 23);

		JButton btnFactur = new JButton("Facturación");
		btnFactur.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnFactur.setBounds(10, 354, 224, 23);

		JButton btnPrecio = new JButton("Precio");
		btnPrecio.setBounds(10, 286, 224, 23);

		JButton btnEmpleados = new JButton("Empleados");
		btnEmpleados.setBounds(10, 388, 224, 23);
		panel_1.setLayout(null);
		panel_1.add(btnPagPrin);
		panel_1.add(btnVehiculos);
		panel_1.add(btnClientes);
		panel_1.add(btnOrden);
		panel_1.add(btnStock);
		panel_1.add(btnFactur);
		panel_1.add(btnPrecio);
		panel_1.add(btnEmpleados);

		if(perfil.equals("mecanico")) {
			btnFactur.setVisible(false);
			btnEmpleados.setVisible(false);

		}
		
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
