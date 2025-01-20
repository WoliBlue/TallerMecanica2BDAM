import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;

public class PopUpActualizarVehiculo extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField txtMatricula;
    private JTextField txtMarca;
    private JTextField txtModelo;
    private JTextField txtClienteDNI;
    private ConexionBD conexion;
    private JTable tabla;

 // Constructor con parámetros para actualizar el vehículo
    public PopUpActualizarVehiculo(ConexionBD conexion, JTable tablaVehiculos, String matricula, String marca, String modelo, String clienteDNI) {
        this.conexion = conexion;
        this.tabla = tablaVehiculos;

        // Configuración del JFrame
        setTitle("Actualizar Vehículo");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 450, 350);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(243, 141, 52));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        // Llama al método de inicialización
        initialize();

        // Rellenar los campos con los datos pasados
        txtMatricula.setText(matricula);
        txtMarca.setText(marca);
        txtModelo.setText(modelo);
        txtClienteDNI.setText(clienteDNI);
    }

    // Método para inicializar los componentes visuales de la ventana
    private void initialize() {
        // Etiquetas de los campos
        JLabel lblMatricula = new JLabel("Matrícula:");
        lblMatricula.setBounds(50, 30, 120, 25);
        contentPane.add(lblMatricula);

        JLabel lblMarca = new JLabel("Marca:");
        lblMarca.setBounds(50, 70, 120, 25);
        contentPane.add(lblMarca);

        JLabel lblModelo = new JLabel("Modelo:");
        lblModelo.setBounds(50, 110, 120, 25);
        contentPane.add(lblModelo);

        JLabel lblClienteDNI = new JLabel("DNI Cliente:");
        lblClienteDNI.setBounds(50, 150, 120, 25);
        contentPane.add(lblClienteDNI);

        // Campos de texto para ingresar los datos
        txtMatricula = new JTextField();
        txtMatricula.setBounds(180, 30, 200, 25);
        contentPane.add(txtMatricula);
        txtMatricula.setColumns(10);

        txtMarca = new JTextField();
        txtMarca.setBounds(180, 70, 200, 25);
        contentPane.add(txtMarca);
        txtMarca.setColumns(10);

        txtModelo = new JTextField();
        txtModelo.setBounds(180, 110, 200, 25);
        contentPane.add(txtModelo);
        txtModelo.setColumns(10);

        txtClienteDNI = new JTextField();
        txtClienteDNI.setBounds(180, 150, 200, 25);
        contentPane.add(txtClienteDNI);
        txtClienteDNI.setColumns(10);

        // Botón para aceptar la actualización del vehículo
        JButton btnActualizar = new JButton("Actualizar");
        btnActualizar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String matricula = txtMatricula.getText();
                String marca = txtMarca.getText();
                String modelo = txtModelo.getText();
                String clienteDNI = txtClienteDNI.getText();

                // Realizar la actualización del vehículo en la base de datos
                boolean actualizado = conexion.actualizarVehiculo(matricula, marca, modelo, clienteDNI);

                if (actualizado) {
                    JOptionPane.showMessageDialog(null, "Vehículo actualizado exitosamente.");
                    // Actualizar la tabla con la nueva información de los vehículos
                    tabla.setModel(conexion.cargarVehiculos());
                } else {
                    JOptionPane.showMessageDialog(null, "Error al actualizar el vehículo.");
                }
                dispose(); // Cierra el pop-up después de la actualización
            }
        });
        btnActualizar.setFont(new Font("Tahoma", Font.BOLD, 11));
        btnActualizar.setBounds(250, 200, 120, 25);
        contentPane.add(btnActualizar);

        // Botón para cancelar la operación
        JButton btnCancelar = new JButton("Cancelar");
        btnCancelar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose(); // Cierra el pop-up sin realizar ninguna acción
            }
        });
        btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 11));
        btnCancelar.setBounds(100, 200, 100, 25);
        contentPane.add(btnCancelar);
    }

   
}
