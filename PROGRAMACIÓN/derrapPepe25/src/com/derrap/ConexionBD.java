package com.derrap;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ConexionBD {

    private static final String CONTROLADOR = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/derrap";
    private static final String USUARIO = "root";
    private static final String CLAVE = "root";
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
                respassword.add(resultado.getString("dni"));
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
        DefaultTableModel modelo = new DefaultTableModel(null, columnas);

        this.Conexion_Correcta();
        try {
            stm = cn.createStatement();
            resultado = stm.executeQuery("SELECT * FROM usuario;");
            while (resultado.next()) {
                modelo.addRow(new Object[] { resultado.getString("nombre"), resultado.getString("dni"),
                        resultado.getString("password"), resultado.getString("perfil") });
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
            stm = cn.createStatement();
            if (!nuevoDni.isEmpty()) {
                String query = "UPDATE cliente SET dni = '" + nuevoDni + "' WHERE dni = '" + dni + "';";
                stm.executeUpdate(query);
            }
            if (!nuevoNombre.isEmpty()) {
                String query = "UPDATE cliente SET nombre = '" + nuevoNombre + "' WHERE dni = '" + nuevoDni + "';";
                stm.executeUpdate(query);
            }
            actualizado = true;
            stm.close();
            cn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return actualizado;
    }

    public boolean crearCliente(String dni, String nombre, String apellidos, int telefono) {
        boolean creado = false;
        this.Conexion_Correcta();
        try {
            stm = cn.createStatement();
            String query = "INSERT INTO cliente (dni, nombre, apellidos, telefono) VALUES ('" + dni + "', '" + nombre
                    + "', '" + apellidos + "', '" + telefono + "');";
            int filasAfectadas = stm.executeUpdate(query);
            if (filasAfectadas > 0) {
                creado = true;
            }
            stm.close();
            cn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return creado;
    }
    public boolean actualizarVehiculo(String matricula, String marca, String modelo, String clienteDNI) {
        boolean actualizado = false;
        this.Conexion_Correcta();
        try {
            stm = cn.createStatement();

            // Actualizar marca
            if (marca != null && !marca.isEmpty()) {
                String queryMarca = "UPDATE vehiculo SET marca = '" + marca + "' WHERE matricula = '" + matricula + "';";
                stm.executeUpdate(queryMarca);
            }

            // Actualizar modelo
            if (modelo != null && !modelo.isEmpty()) {
                String queryModelo = "UPDATE vehiculo SET modelo = '" + modelo + "' WHERE matricula = '" + matricula + "';";
                stm.executeUpdate(queryModelo);
            }

            // Actualizar DNI del cliente (si no es nulo)
            if (clienteDNI != null && !clienteDNI.isEmpty()) {
                String queryClienteDNI = "UPDATE vehiculo SET cliente_dni = '" + clienteDNI + "' WHERE matricula = '" + matricula + "';";
                stm.executeUpdate(queryClienteDNI);
            }

            actualizado = true;
            stm.close();
            cn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return actualizado;
    }
    public boolean crearVehiculo(String matricula, String marca, String modelo, String clienteDNI) {
        boolean creado = false;
        this.Conexion_Correcta();  // Establece la conexión a la base de datos
        try {
            stm = cn.createStatement();

            // Consulta para verificar si el cliente con el DNI existe
            String checkClienteQuery = "SELECT COUNT(*) FROM cliente WHERE dni = '" + clienteDNI + "';";
            ResultSet rs = stm.executeQuery(checkClienteQuery);
            
            if (rs.next() && rs.getInt(1) > 0) {
                // Si el cliente existe, se procede a insertar el vehículo
                String query = "INSERT INTO vehiculo (matricula, marca, modelo, cliente_dni) VALUES ('"
                        + matricula + "', '" + marca + "', '" + modelo + "', '" + clienteDNI + "');";
                
                int filasAfectadas = stm.executeUpdate(query);
                
                // Si la inserción es exitosa, filasAfectadas debe ser mayor que 0
                if (filasAfectadas > 0) {
                    creado = true;
                }
            } else {
                // Si el cliente no existe, retorna false
                System.out.println("El cliente con DNI " + clienteDNI + " no existe.");
            }
            
            // Cierra la declaración y la conexión
            rs.close();
            stm.close();
            cn.close();
            
        } catch (SQLException e) {
            e.printStackTrace();  // Maneja posibles errores de SQL
        }
        
        return creado;  // Retorna true si se insertó el vehículo correctamente, false en caso de error o cliente inexistente
    }

    public void eliminarVehiculo(String matricula) {
        // Establecer la conexión a la base de datos
        this.Conexion_Correcta();  // Establece la conexión a la base de datos

        try {
            // Crear una sentencia SQL para eliminar el vehículo
            String query = "DELETE FROM vehiculo WHERE matricula = ?"; // Usar parámetros para evitar SQL Injection

            // Preparar la sentencia SQL
            PreparedStatement pstmt = cn.prepareStatement(query);
            
            // Establecer el valor del parámetro (la matrícula)
            pstmt.setString(1, matricula);

            // Ejecutar la consulta de eliminación
            int filasAfectadas = pstmt.executeUpdate();

            // Verificar si la eliminación fue exitosa
            if (filasAfectadas > 0) {
                System.out.println("Vehículo con matrícula " + matricula + " eliminado correctamente.");
            } else {
                System.out.println("No se encontró el vehículo con matrícula " + matricula);
            }

            // Cerrar la declaración y la conexión
            pstmt.close();
            cn.close();

        } catch (SQLException e) {
            e.printStackTrace();  // Manejo de excepciones de SQL
        }
    }

	public boolean crearEmpleado(String dni, String nombre, String password) {
		 boolean creado = false;
		    this.Conexion_Correcta();  // Establece la conexión a la base de datos

		    try {
		        // Consulta SQL para insertar el nuevo empleado
		        String query = "INSERT INTO usuario (dni, nombre, password,perfil,estado) VALUES (?, ?, ?,?,?)";

		        // Preparar la sentencia SQL
		        PreparedStatement pstmt = cn.prepareStatement(query);
		        
		        // Establecer los parámetros de la consulta
		        pstmt.setString(1, dni);
		        pstmt.setString(2, nombre);
		        pstmt.setString(3, password);
		        pstmt.setString(4, "Mecanico");
		        pstmt.setInt(5, 1);

		        // Ejecutar la consulta de inserción
		        int filasAfectadas = pstmt.executeUpdate();

		        // Verificar si la inserción fue exitosa
		        if (filasAfectadas > 0) {
		            creado = true;
		        }

		        // Cerrar recursos
		        pstmt.close();
		        cn.close();

		    } catch (SQLException e) {
		        e.printStackTrace();  // Manejo de excepciones de SQL
		    }

		    return creado;  // Retorna true si se insertó el empleado correctamente, false en caso de error
		}

	 // Método para actualizar el empleado en la base de datos
    public boolean actualizarEmpleado(ConexionBD conexion, String dni, String nombre, String password, String estado) {
        boolean actualizado = false;

        // Establecer la conexión a la base de datos
        try {
            this.Conexion_Correcta(); // Obtener la conexión desde la clase ConexionBD
            String consulta = "UPDATE usuario SET nombre = ?, password = ?, estado = ? WHERE dni = ?";

            // Preparar la consulta con parámetros para evitar SQL injection
            PreparedStatement pstmt = cn.prepareStatement(consulta);
            
            // Establecer los valores de los parámetros
            pstmt.setString(1, nombre);
            pstmt.setString(2, password);
            pstmt.setString(3, estado); 
            pstmt.setString(4, dni); 

            // El DNI se usa para identificar el registro a actualizar

            // Ejecutar la consulta
            int filasAfectadas = pstmt.executeUpdate();

            // Verificar si la actualización fue exitosa
            if (filasAfectadas > 0) {
                actualizado = true;
            }

            // Cerrar los recursos
            pstmt.close();
            cn.close();

        } catch (SQLException e) {
            e.printStackTrace();  // Manejo de errores SQL
        }

        return actualizado;
    }
	
	public void eliminarEmpleado(String dni) {
	    this.Conexion_Correcta();  // Establece la conexión a la base de datos

	    try {
	        // Consulta SQL para eliminar el empleado con el DNI proporcionado
	        String consulta = "DELETE FROM usuario WHERE dni = ?";

	        // Preparar la sentencia SQL con un parámetro para evitar SQL injection
	        PreparedStatement pstmt = cn.prepareStatement(consulta);
	        
	        // Establecer el parámetro en la consulta
	        pstmt.setString(1, dni);

	        // Ejecutar la consulta de eliminación
	        int filasAfectadas = pstmt.executeUpdate();

	        // Verificar si se eliminó el empleado
	        if (filasAfectadas > 0) {
	            System.out.println("Empleado con DNI " + dni + " eliminado correctamente.");
	        } else {
	            System.out.println("No se encontró ningún empleado con el DNI proporcionado.");
	        }

	        // Cerrar la sentencia y la conexión
	        pstmt.close();
	        cn.close();

	    } catch (SQLException e) {
	        e.printStackTrace();  // Manejo de excepciones de SQL
	    }
	}
	

	public DefaultTableModel cargarOrdenes(String perfil) {
		String[] columnas = { "Referencia", "Vehículo Matrícula", "Servicio", "Descripción", "Estado", "Proceso",
				"Fecha Ingreso" };
		DefaultTableModel modelo = new DefaultTableModel(columnas, 0);
		int ordenes = 0;
		this.Conexion_Correcta();
		try {
			stm = cn.createStatement();
			resultado = stm
					.executeQuery("SELECT * FROM orden where mecanico_dni = (SELECT dni FROM usuario WHERE nombre = '"
							+ perfil + "') order by fecha_ingreso;");
			while (resultado.next() && ordenes < 3) {
				modelo.addRow(new Object[] { resultado.getString("referencia"),
						resultado.getString("vehiculo_matricula"), resultado.getString("servicio_nombre"),
						resultado.getString("descripcion"), resultado.getString("estado"),
						resultado.getString("proceso"), resultado.getString("fecha_ingreso") });
				ordenes++;
			}
			resultado = stm.executeQuery("SELECT * FROM orden WHERE estado = 'Pendiente' ORDER BY fecha_ingreso;");
			while (resultado.next()) {
				modelo.addRow(new Object[] { resultado.getString("referencia"),
						resultado.getString("vehiculo_matricula"), resultado.getString("servicio_nombre"),
						resultado.getString("descripcion"), resultado.getString("estado"),
						resultado.getString("proceso"), resultado.getString("fecha_ingreso") });
			}
			stm.close();
			cn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return modelo;
	}

	public void asignarOrden(String referencia, String mecanico) {
		this.Conexion_Correcta();
		try {
			stm = cn.createStatement();
			String consulta = "SELECT COUNT(referencia) FROM orden WHERE mecanico_dni ='" + mecanico + "';";
			resultado = stm.executeQuery(consulta);
			while (resultado.next()) {
				if (resultado.getInt("COUNT(referencia)") <= 3) {
					String actualizar = "UPDATE orden SET estado = 'Asignada', mecanico_dni = '" + mecanico
							+ "' WHERE referencia = '" + referencia + "';";
					int filas = stm.executeUpdate(actualizar);
					switch (filas) {
					case 0:
						JOptionPane.showConfirmDialog(null, "No se actualizó");
						break;
					case 1:
						JOptionPane.showMessageDialog(null, "Orden asignada correctamente");
						break;
					}
				} else {
					JOptionPane.showMessageDialog(null, "Ya tienes 3 órdenes asignadas");
				}
			}
			stm.close();
			cn.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void desasignarOrden(String referencia) {
		this.Conexion_Correcta();
		try {
			stm = cn.createStatement();
			String actualizar = "UPDATE orden SET estado = 'Pendiente', mecanico_dni = null WHERE referencia = '"
					+ referencia + "';";
			int filas = stm.executeUpdate(actualizar);
			switch (filas) {
			case 0:
				JOptionPane.showConfirmDialog(null, "No se actualizó");
				break;
			case 1:
				JOptionPane.showMessageDialog(null, "Orden desasignada correctamente");
				break;
			}
			stm.close();
			cn.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public boolean crearOrden(String referencia, String estado, String proceso, String fechaIngreso, String servicioNombre, String vehiculoMatricula, String descripcion) {
	    boolean creado = false;
	    this.Conexion_Correcta();
	    try {
	        String query = "INSERT INTO orden (referencia, estado, proceso, fecha_ingreso, servicio_nombre, vehiculo_matricula, descripcion) VALUES (?, ?, ?, ?, ?, ?, ?)";
	        PreparedStatement pstmt = cn.prepareStatement(query);
	        pstmt.setString(1, referencia);
	        pstmt.setString(2, estado);
	        pstmt.setString(3, proceso);
	        pstmt.setString(4, fechaIngreso);
	        pstmt.setString(5, servicioNombre);
	        pstmt.setString(6, vehiculoMatricula);
	        pstmt.setString(7, descripcion);
	        int filasAfectadas = pstmt.executeUpdate();
	        if (filasAfectadas > 0) {
	            creado = true;
	        }
	        pstmt.close();
	        cn.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return creado;
	}
	public boolean eliminarOrden(String referencia) {
	    boolean eliminado = false;
	    this.Conexion_Correcta();
	    try {
	        String query = "DELETE FROM orden WHERE referencia = ?";
	        PreparedStatement pstmt = cn.prepareStatement(query);
	        pstmt.setString(1, referencia);
	        int filasAfectadas = pstmt.executeUpdate();
	        if (filasAfectadas > 0) {
	            eliminado = true;
	        }
	        pstmt.close();
	        cn.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return eliminado;
	}
	public boolean crearPieza(int id, String nombre, String stock) {
	    boolean creado = false;
	    this.Conexion_Correcta();
	    try {
	        String query = "INSERT INTO almacen (id_pieza, nombre_pieza, stock) VALUES (?, ?, ?)";
	        PreparedStatement pstmt = cn.prepareStatement(query);
	        pstmt.setInt(1, id);
	        pstmt.setString(2, nombre);
	        pstmt.setString(3, stock);
	        int filasAfectadas = pstmt.executeUpdate();
	        if (filasAfectadas > 0) {
	            creado = true;
	        }
	        pstmt.close();
	        cn.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return creado;
	}


}
