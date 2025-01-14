import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.CardLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JOptionPane;

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

    public VPrincipal(ConexionBD conexion) {
        this.conexion = conexion;

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1411, 763);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel panel_izq = new JPanel();
        panel_izq.setBackground(new Color(242, 183, 5));
        panel_izq.setBounds(0, 0, 244, 713);
        contentPane.add(panel_izq);
        panel_izq.setLayout(null);

        JButton btnPagPrin = new JButton("Página Principal");
        btnPagPrin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "PaginaPrincipal");
            }
        });
        btnPagPrin.setBounds(10, 150, 224, 23);
        panel_izq.add(btnPagPrin);

        JButton btnVehiculos = new JButton("Vehículos");
        btnVehiculos.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "Vehiculos");
                tablaVehiculos.setModel(conexion.cargarVehiculos());
            }
        });
        btnVehiculos.setBounds(10, 218, 224, 23);
        panel_izq.add(btnVehiculos);

        tablaCliente = new JTable();
        JScrollPane scrollPane = new JScrollPane(tablaCliente);
        scrollPane.setBounds(393, 229, 415, 291);

        JButton btnClientes = new JButton("Clientes");
        btnClientes.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "Clientes");
                tablaCliente.setModel(conexion.cargarCliente());
            }
        });
        btnClientes.setBounds(10, 184, 224, 23);
        panel_izq.add(btnClientes);

        JButton btnOrden = new JButton("Órdenes");
        btnOrden.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "Órdenes");
                tablaOrdenes.setModel(conexion.cargarOrdenes());
            }
        });
        btnOrden.setBounds(10, 252, 224, 23);
        panel_izq.add(btnOrden);

        JButton btnStock = new JButton("Stock");
        btnStock.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "Stock");
                tablaStock.setModel(conexion.cargarStock()); 
            }
        });
        btnStock.setBounds(10, 320, 224, 23);
        panel_izq.add(btnStock);

        JButton btnFactur = new JButton("Facturación");
        btnFactur.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "Facturación");
                tablaFacturas.setModel(conexion.cargarFacturas()); 
            }
        });
        btnFactur.setBounds(10, 354, 224, 23);
        panel_izq.add(btnFactur);
        btnFactur.setBounds(10, 354, 224, 23);
        panel_izq.add(btnFactur);

        JButton btnPrecio = new JButton("Precio");
        btnPrecio.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "Precio");
                tablaServicios.setModel(conexion.cargarServicios()); 
            }
        });
        btnPrecio.setBounds(10, 286, 224, 23);
        panel_izq.add(btnPrecio);

        JButton btnEmpleados = new JButton("Empleados");
        btnEmpleados.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "Empleados");
                tablaEmpleados.setModel(conexion.cargarEmpleados());
            }
        });
        btnEmpleados.setBounds(10, 388, 224, 23);
        panel_izq.add(btnEmpleados);

        JLabel lblNewLabel = new JLabel("DERRAP");
        lblNewLabel.setBounds(74, 46, 84, 28);
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 23));
        panel_izq.add(lblNewLabel);

        JPanel panel_arriba = new JPanel();
        panel_arriba.setBackground(new Color(242, 183, 5));
        panel_arriba.setBounds(243, 0, 1142, 106);
        contentPane.add(panel_arriba);

        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);
        cardPanel.setBackground(new Color(243, 141, 52));
        cardPanel.setBounds(243, 106, 1142, 607);
        contentPane.add(cardPanel);
        cardPanel.setLayout(cardLayout);

        
        JPanel panel_PaginaPrincipal = new JPanel();
        panel_PaginaPrincipal.setBackground(Color.WHITE);
        cardPanel.add(panel_PaginaPrincipal, "PaginaPrincipal");
        panel_PaginaPrincipal.setLayout(null);

        JTextArea txtrBienvenido = new JTextArea();
        txtrBienvenido.setBounds(419, 127, 392, 41);
        txtrBienvenido.setFont(new Font("Monospaced", Font.PLAIN, 27));
        txtrBienvenido.setText("Bienvenido al programa");
        panel_PaginaPrincipal.add(txtrBienvenido);

        JPanel panel_Cliente = new JPanel();
        panel_Cliente.setBackground(Color.WHITE);
        cardPanel.add(panel_Cliente, "Clientes");
        panel_Cliente.setLayout(null);

        JTextArea txtrSkibidiToilet = new JTextArea();
        txtrSkibidiToilet.setBounds(448, 128, 277, 41);
        txtrSkibidiToilet.setFont(new Font("Monospaced", Font.PLAIN, 27));
        txtrSkibidiToilet.setText("Estás en Clientes");
        panel_Cliente.add(txtrSkibidiToilet);

        panel_Cliente.add(scrollPane);

        JPanel panel_Vehiculo = new JPanel();
        panel_Vehiculo.setBackground(Color.WHITE);
        cardPanel.add(panel_Vehiculo, "Vehiculos");
        panel_Vehiculo.setLayout(null);

        JTextArea txtrVehiculos = new JTextArea();
        txtrVehiculos.setBounds(448, 128, 277, 41);
        txtrVehiculos.setFont(new Font("Monospaced", Font.PLAIN, 27));
        txtrVehiculos.setText("Estás en Vehículos");
        panel_Vehiculo.add(txtrVehiculos);

        tablaVehiculos = new JTable();
        scrollPaneVehiculos = new JScrollPane(tablaVehiculos);
        scrollPaneVehiculos.setBounds(393, 229, 415, 291);
        panel_Vehiculo.add(scrollPaneVehiculos);

        JPanel panel_Ordenes = new JPanel();
        panel_Ordenes.setBackground(Color.WHITE);
        cardPanel.add(panel_Ordenes, "Órdenes");
        panel_Ordenes.setLayout(null);

        JTextArea txtrOrdenes = new JTextArea();
        txtrOrdenes.setBounds(448, 128, 277, 41);
        txtrOrdenes.setFont(new Font("Monospaced", Font.PLAIN, 27));
        txtrOrdenes.setText("Estás en Órdenes");
        panel_Ordenes.add(txtrOrdenes);

        tablaOrdenes = new JTable();
        scrollPaneOrdenes = new JScrollPane(tablaOrdenes);
        scrollPaneOrdenes.setBounds(393, 229, 415, 291);
        panel_Ordenes.add(scrollPaneOrdenes);

    
        JPanel panel_Precio = new JPanel();
        panel_Precio.setBackground(Color.WHITE);
        cardPanel.add(panel_Precio, "Precio");
        panel_Precio.setLayout(null);

        JTextArea txtrPrecio = new JTextArea();
        txtrPrecio.setBounds(448, 128, 277, 41);
        txtrPrecio.setFont(new Font("Monospaced", Font.PLAIN, 27));
        txtrPrecio.setText("Estás en Precio");
        panel_Precio.add(txtrPrecio);

   
        tablaServicios = new JTable();
        scrollPaneServicios = new JScrollPane(tablaServicios);
        scrollPaneServicios.setBounds(393, 229, 415, 291); 
        panel_Precio.add(scrollPaneServicios);

        JPanel panel_Stock = new JPanel();
        panel_Stock.setBackground(Color.WHITE);
        cardPanel.add(panel_Stock, "Stock");
        panel_Stock.setLayout(null);

        JTextArea txtrStock = new JTextArea();
        txtrStock.setBounds(243, 174, 616, 41);
        txtrStock.setFont(new Font("Monospaced", Font.PLAIN, 27));
        txtrStock.setText("Estás en Shock, y también en Stock");
        panel_Stock.add(txtrStock);

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
        panel_Facturacion.setBackground(Color.WHITE);
        cardPanel.add(panel_Facturacion, "Facturación");
        panel_Facturacion.setLayout(null);

        JTextArea txtrFacturacion = new JTextArea();
        txtrFacturacion.setBounds(469, 177, 339, 41);
        txtrFacturacion.setFont(new Font("Monospaced", Font.PLAIN, 27));
        txtrFacturacion.setText("Estás en Facturación");
        panel_Facturacion.add(txtrFacturacion);

        
        tablaFacturas = new JTable();
        scrollPaneFacturas = new JScrollPane(tablaFacturas);
        scrollPaneFacturas.setBounds(393, 229, 415, 291); 
        panel_Facturacion.add(scrollPaneFacturas);

        panel_Empleados = new JPanel();
        panel_Empleados.setBackground(Color.WHITE);
        cardPanel.add(panel_Empleados, "Empleados");
        panel_Empleados.setLayout(null);

        JTextArea txtrEmpleados = new JTextArea();
        txtrEmpleados.setBounds(448, 128, 302, 41);
        txtrEmpleados.setFont(new Font("Monospaced", Font.PLAIN, 27));
        txtrEmpleados.setText("Estás en Empleados");
        panel_Empleados.add(txtrEmpleados);

        tablaEmpleados = new JTable();
        scrollPaneEmpleados = new JScrollPane(tablaEmpleados);
        scrollPaneEmpleados.setBounds(393, 229, 415, 291);
        panel_Empleados.add(scrollPaneEmpleados);

        
        cardLayout.show(cardPanel, "PaginaPrincipal");
    }
}