import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ConexionBD {

	private static final String CONTROLADOR = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost:3306/derrap";
	private static final String USUARIO = "root";
	private static final String CLAVE = "Luis1234";
	Connection cn = null;
	Statement stm = null;
	ResultSet resultado = null;

	Connection Conexion_Correcta() {
		try {
			cn = DriverManager.getConnection(URL, USUARIO, CLAVE);
			System.out.println("Exito en la conexion");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cn;
	}

	public ArrayList<String> iniciarSesion(String usuario) {
		ArrayList<String> respassword = new ArrayList<>();
		try {
			this.Conexion_Correcta();
			stm = cn.createStatement();
			resultado = stm.executeQuery("Select * from usuario where dni = '" + usuario + "';");
			while (resultado.next()) {
				respassword.add(resultado.getString("password"));
				respassword.add(resultado.getString("perfil"));
				respassword.add(resultado.getString("nombre"));
				System.out.println(respassword);
			}
			stm.close();
			cn.close();
		} catch (Exception e2) {
			e2.printStackTrace();
		}
		return respassword;
	}

	public DefaultTableModel cargarCliente() {
		String[] columnas = { "DNI", "Nombre", "Apellidos", "Teléfono" };
		DefaultTableModel modelo = new DefaultTableModel(columnas, 0);

		this.Conexion_Correcta();
		try {
			stm = cn.createStatement();
			resultado = stm.executeQuery("SELECT * FROM cliente;");
			while (resultado.next()) {
				modelo.addRow(new Object[] { resultado.getString("dni"), resultado.getString("nombre"),
						resultado.getString("apellidos"), resultado.getString("telefono") });
			}
			stm.close();
			cn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return modelo;
	}

	public DefaultTableModel cargarVehiculos() {
		String[] columnas = { "Matrícula", "Marca", "Modelo", "DNI Cliente" };
		DefaultTableModel modelo = new DefaultTableModel(columnas, 0);

		this.Conexion_Correcta();
		try {
			stm = cn.createStatement();
			resultado = stm.executeQuery("SELECT * FROM vehiculo;");
			while (resultado.next()) {
				modelo.addRow(new Object[] { resultado.getString("matricula"), resultado.getString("marca"),
						resultado.getString("modelo"), resultado.getString("cliente_dni") });
			}
			stm.close();
			cn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return modelo;
	}

	public DefaultTableModel cargarOrdenes() {
		String[] columnas = { "Referencia", "Estado", "Proceso", "Fecha Ingreso", "Mecánico DNI", "Servicio",
				"Vehículo Matrícula", "Descripción", "Fecha Salida" };
		DefaultTableModel modelo = new DefaultTableModel(columnas, 0);

		this.Conexion_Correcta();
		try {
			stm = cn.createStatement();
			resultado = stm.executeQuery("SELECT * FROM orden;");
			while (resultado.next()) {
				modelo.addRow(new Object[] { resultado.getString("referencia"), resultado.getString("estado"),
						resultado.getString("proceso"), resultado.getString("fecha_ingreso"),
						resultado.getString("mecanico_dni"), resultado.getString("servicio_nombre"),
						resultado.getString("vehiculo_matricula"), resultado.getString("descripcion"),
						resultado.getString("fecha_salida") });
			}
			stm.close();
			cn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return modelo;
	}

	public DefaultTableModel cargarStock() {
		String[] columnas = { "ID Pieza", "Nombre Pieza", "Stock" };
		DefaultTableModel modelo = new DefaultTableModel(columnas, 0);

		this.Conexion_Correcta();
		try {
			stm = cn.createStatement();
			resultado = stm.executeQuery("SELECT * FROM almacen;");
			while (resultado.next()) {
				modelo.addRow(new Object[] { resultado.getString("id_pieza"), resultado.getString("nombre_pieza"),
						resultado.getString("stock") });
			}
			stm.close();
			cn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return modelo;
	}

	public boolean actualizarStock(int idPieza, String nuevoStock) {
		boolean actualizado = false;
		this.Conexion_Correcta();
		try {
			stm = cn.createStatement();
			String query = "UPDATE almacen SET stock = '" + nuevoStock + "' WHERE id_pieza = " + idPieza + ";";
			int filasAfectadas = stm.executeUpdate(query);
			if (filasAfectadas > 0) {
				actualizado = true;
			}
			stm.close();
			cn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return actualizado;
	}

	public DefaultTableModel cargarFacturas() {
		String[] columnas = { "Referencia", "Orden Referencia", "Fecha", "Total" };
		DefaultTableModel modelo = new DefaultTableModel(columnas, 0);

		this.Conexion_Correcta();
		try {
			stm = cn.createStatement();
			resultado = stm.executeQuery("SELECT * FROM factura;");
			while (resultado.next()) {
				modelo.addRow(new Object[] { resultado.getString("referencia"), resultado.getString("orden_referencia"),
						resultado.getString("fecha"), resultado.getString("total") });
			}
			stm.close();
			cn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return modelo;
	}

	public DefaultTableModel cargarServicios() {
		String[] columnas = { "Nombre", "Precio" };
		DefaultTableModel modelo = new DefaultTableModel(columnas, 0);

		this.Conexion_Correcta();
		try {
			stm = cn.createStatement();
			resultado = stm.executeQuery("SELECT * FROM servicio;");
			while (resultado.next()) {
				modelo.addRow(new Object[] { resultado.getString("nombre"), resultado.getString("precio") });
			}
			stm.close();
			cn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return modelo;
	}

	public DefaultTableModel cargarEmpleados() {
		String[] columnas = { "Nombre", "DNI", "Contraseña", "Perfil" };
		String[] registros = new String[4];

		DefaultTableModel modelo = new DefaultTableModel(null, columnas);

		this.Conexion_Correcta();
		try {
			stm = cn.createStatement();
			resultado = stm.executeQuery("SELECT * FROM usuario;");
			while (resultado.next()) {
				registros[0] = resultado.getString("nombre");
				registros[1] = resultado.getString("dni");
				registros[2] = resultado.getString("password");
				registros[3] = resultado.getString("perfil");
				modelo.addRow(registros);
			}
			stm.close();
			cn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return modelo;
	}

	public boolean actualizarCliente(String dni, String nuevoDni, String nuevoNombre) {
		boolean actualizado = false;
		this.Conexion_Correcta();
		try {
			if(!nuevoDni.isEmpty() || !nuevoNombre.isEmpty()) {
			stm = cn.createStatement();
			String query = "UPDATE cliente SET dni = '" + nuevoDni + "' WHERE dni = '" + dni + "';";
			stm.executeUpdate(query);
			query = "UPDATE cliente SET nombre = '" + nuevoNombre + "' WHERE dni = '" + nuevoDni + "';";
			stm.executeUpdate(query);
			stm.close();
			cn.close();
			}else {
				System.out.println("Introduce algún valor");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return actualizado;
	}

	public boolean actualizarCliente(String idCliente, JTable tabaCliente) {
		boolean actualizado = false;
		this.Conexion_Correcta();
		try {
			stm = cn.createStatement();
			String nuevoDNI = JOptionPane.showInputDialog("Introduce nuevo DNI");
			if (!nuevoDNI.isEmpty()) {
				String query = "UPDATE cliente SET dni = '" + nuevoDNI + "' WHERE dni = '" + idCliente + "';";
				stm.executeUpdate(query);
				String nuevoNombre = JOptionPane.showInputDialog("Introduce nuevo nombre");
				if (!nuevoNombre.isEmpty()) {
					query = "UPDATE cliente SET nombre = '" + nuevoNombre + "' WHERE dni = '" + nuevoDNI + "';";
					stm.executeUpdate(query);
					stm.close();
					cn.close();
				}
			} else {
				System.out.println("Introduce algún valor");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return actualizado;
	}

}
