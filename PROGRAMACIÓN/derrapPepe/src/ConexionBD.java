
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class ConexionBD {

	private static final String CONTROLADOR = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost:3306/mydb";

	// Nosotros tenemos que poner el nombre de nuestra base de datos

	private static final String USUARIO = "root";
	private static final String CLAVE = "Luis1234";
	Connection cn = null; // permite almacenar el estado de la conexion, saber si esta o no conectao
	Statement stm = null;
	ResultSet resultado = null;

	Connection Conexion_Correcta() {

		try {

			cn = DriverManager.getConnection(URL, USUARIO, CLAVE);

			System.out.println("Exito en la conexion");

		} catch (Exception e) {

		}
		return cn;

	}

	public ArrayList<String> iniciarSesion(String usuario) {
		ArrayList<String> respassword = new ArrayList();
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
			// TODO: handle exception
		}
		return respassword;
	}

}
