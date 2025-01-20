import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VPopUpCrearVehiculo extends JFrame {

    private static final long serialVersionUID = 1L;
    private JTextField txtMatricula;
    private JTextField txtMarca;
    private JTextField txtModelo;
    private JTextField txtClienteDNI;
    private ConexionBD conexion;
    private JTable tabla;

    // Constructor sin parámetros
    public VPopUpCrearVehiculo() {
    	getContentPane().setBackground(new Color(243, 141, 52));
        // Configura la interfaz visual sin pasarle parámetros
        getContentPane().setLayout(null);
        setBackground(new Color(102, 204, 255));

        // Llama al método de inicialización
        initialize();
    }

    // Constructor con parámetros para crear un vehículo
    public VPopUpCrearVehiculo(ConexionBD conexion,JTable tablaVehiculos) {
        this(); // Llama al constructor sin parámetros
        this.conexion = conexion;
        this.tabla = tablaVehiculos;
        
    }

    // Método para inicializar los componentes visuales de la ventana
    private void initialize() {
    	setTitle("DERRAP - Crear Vehiculo");
        // Etiquetas de los campos
        JLabel lblMatricula = new JLabel("Matrícula:");
        lblMatricula.setBounds(50, 30, 120, 25);
        getContentPane().add(lblMatricula);

        JLabel lblMarca = new JLabel("Marca:");
        lblMarca.setBounds(50, 70, 120, 25);
        getContentPane().add(lblMarca);

        JLabel lblModelo = new JLabel("Modelo:");
        lblModelo.setBounds(50, 110, 120, 25);
        getContentPane().add(lblModelo);

        JLabel lblClienteDNI = new JLabel("DNI Cliente:");
        lblClienteDNI.setBounds(50, 150, 120, 25);
        getContentPane().add(lblClienteDNI);

        // Campos de texto para ingresar los datos
        txtMatricula = new JTextField();
        txtMatricula.setBounds(180, 30, 200, 25);
        getContentPane().add(txtMatricula);
        txtMatricula.setColumns(10);

        txtMarca = new JTextField();
        txtMarca.setBounds(180, 70, 200, 25);
        getContentPane().add(txtMarca);
        txtMarca.setColumns(10);

        txtModelo = new JTextField();
        txtModelo.setBounds(180, 110, 200, 25);
        getContentPane().add(txtModelo);
        txtModelo.setColumns(10);

        txtClienteDNI = new JTextField();
        txtClienteDNI.setBounds(180, 150, 200, 25);
        getContentPane().add(txtClienteDNI);
        txtClienteDNI.setColumns(10);

        // Botón para aceptar la creación del vehículo
        JButton btnCrear = new JButton("Crear");
        btnCrear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String matricula = txtMatricula.getText();
                String marca = txtMarca.getText();
                String modelo = txtModelo.getText();
                String clienteDNI = txtClienteDNI.getText();

                // Realizar la creación del vehículo en la base de datos
                boolean creado = conexion.crearVehiculo(matricula, marca, modelo, clienteDNI);

                if (creado) {
                    JOptionPane.showMessageDialog(null, "Vehículo creado exitosamente.");
                    // Actualizar la tabla con la nueva información de los vehículos
                    tabla.setModel(conexion.cargarVehiculos());
                } else {
                    JOptionPane.showMessageDialog(null, "Error al crear el vehículo.");
                }
                dispose(); // Cierra la ventana emergente después de crear el cliente
            }
        });
        btnCrear.setFont(new Font("Tahoma", Font.BOLD, 11));
        btnCrear.setBounds(250, 200, 120, 25);
        getContentPane().add(btnCrear);

        // Botón para cancelar la operación
        JButton btnCancelar = new JButton("Cancelar");
        btnCancelar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose(); // Cierra el pop-up sin realizar ninguna acción
            }
        });
        btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 11));
        btnCancelar.setBounds(100, 200, 100, 25);
        getContentPane().add(btnCancelar);

        // Configuración del tamaño y la posición de la ventana
        setSize(450, 300); // Establece el tamaño de la ventana (ancho x alto)
        setLocationRelativeTo(null); // Centra la ventana en la pantalla
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Asegura que la ventana se cierre correctamente
        setResizable(false); // Evita que la ventana cambie de tamaño
    }
}
