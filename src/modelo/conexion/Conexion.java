package modelo.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
	private String entregable_mascotas = "guiveterinaria";
	private String usuario = "root";
	private String password = "pipe123.";
	private String url = "jdbc:mysql://localhost:3306/"+entregable_mascotas+"?useUnicode=true&use"
			+ "JDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&"
			+ "serverTimezone=UTC";

	Connection conn = null;
	//constructor de la clase
	public Conexion() {
		try {
			//obtener el driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			//obtener la conexion
			conn = DriverManager.getConnection(url,usuario,password);
			if (conn != null) {
				System.out.println("Conexion Exitosa a la BD: " + entregable_mascotas);
			} else {
				System.out.println("******************NO SE PUDO CONECTAR " + entregable_mascotas);
			}
		}
		catch (ClassNotFoundException e) {
			System.out.println("ocurre una ClassNotFoundException : " + e.getMessage());
		} catch (SQLException e) {
			System.out.println("ocurre una SQLException: " + e.getMessage());
			System.out.println("Verifique que Mysql esté encendido...");
		}
	}
	public Connection getConnection(){
		return conn;
	}
	public void desconectar(){
		conn=null;
		System.out.println("la base de datos: " + entregable_mascotas + " ha sido desconectada");
	}
	
}
