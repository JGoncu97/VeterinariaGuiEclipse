package dao;

import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.management.RuntimeErrorException;
import javax.swing.JOptionPane;
import conexion.Conexion;
import controlador.Controlador;
import vo.MascotaVO;
import vo.PersonaVO;

public class MascotaDAO {
		
	private Controlador miControlador;
	
	public String registrarMascota(MascotaVO miMascota) {
		String resultado ="";
				
				Connection connection = null;
				Conexion conexion = new Conexion();
				PreparedStatement preStatement = null;
				
				connection = conexion.getConnection();
				String consulta = "INSERT INTO mascota (propietario, nombre, sexo, raza) VALUES (?,?,?,?)"; 
				
				try {
					preStatement = connection.prepareStatement(consulta);
					preStatement.setString(1, miMascota.getIdDueño());
					preStatement.setString(2, miMascota.getNombre());
					preStatement.setString(3, miMascota.getSexo());
					preStatement.setString(4, miMascota.getRaza());
					
					preStatement.execute();
					
					resultado = "Registro de Mascota exitoso";
					
				} catch (SQLException e) {
					resultado = "Error, No se pudo registrar la mascota " + e.getMessage();
					
				}
				
				conexion.desconectar();		
				
				return resultado;
	}

	public String actualizarMascota(MascotaVO miMascota) {
		String resultado = "";
				
				Connection connection = null;
				Conexion conexion = new Conexion();
				PreparedStatement preStatement = null;
				connection = conexion.getConnection();
				
				try {
					String consulta = "UPDATE mascota SET propietario = ?, nombre = ?, sexo = ?, raza = ? WHERE propietario = ?";
					preStatement = connection.prepareStatement(consulta);
					preStatement.setString(1, miMascota.getIdDueño());
					preStatement.setString(2, miMascota.getNombre());
					preStatement.setString(3, miMascota.getSexo());
					preStatement.setString(4, miMascota.getRaza());
					preStatement.setString(5, miMascota.getIdDueño());
					preStatement.executeUpdate();
					
					resultado = "La mascota " + miMascota.getNombre() + " Ha sido actualizada";
					
				} catch (SQLException e) {
					resultado = "Error: " + e.getMessage();
					
				} finally {
					try {
						if (preStatement != null) preStatement.close();
						conexion.desconectar();
						
					} catch (SQLException e) {
						throw new RuntimeException("Error al cerrar los recursos: " + e.getMessage());
						
					}
					
				}
				
				return resultado;
	}

	public MascotaVO consultarMascota(String id) {
		Connection connection = null;
		Conexion conexion = new Conexion();
		PreparedStatement preStatement = null;
		ResultSet result = null;
		MascotaVO miMascota = null;
		
		connection = conexion.getConnection();
		String consulta = "SELECT * FROM mascota WHERE propietario = ?";
		
		try {
			if (connection != null) {
				preStatement = connection.prepareStatement(consulta);
				preStatement.setString(1, id);
				result = preStatement.executeQuery();
				
				if (result.next()) {
					miMascota = new MascotaVO();
					miMascota.setIdDueño(result.getString("propietario"));
					miMascota.setNombre(result.getString("nombre"));
					miMascota.setSexo(result.getString("sexo"));
					miMascota.setRaza(result.getString("raza"));
					
				}
				
			}			
				
		} catch (SQLException e) {
			throw new RuntimeException("Error en la consulta de la mascota" + e.getMessage());
			
		} finally {
			
			try {
				if (result != null) result.close();
				if (preStatement != null) preStatement.close();
				conexion.desconectar();
				
			} catch (SQLException e) {
				throw new RuntimeException("Error al cerrar los recursos: " + e.getMessage());
				
			}
			
		}
		return miMascota;
		
	}

	public String eliminarMascota(String id) {
		String resultado = "";
				
				Connection connection = null;
				Conexion conexion = new Conexion();
				PreparedStatement preStatement = null;
				connection = conexion.getConnection();
				
				try {
					String consulta = "DELETE FROM mascota WHERE propietario = ?";
					preStatement = connection.prepareStatement(consulta);
					preStatement.setString(1, id);
					preStatement.executeUpdate();
					resultado = "La mascota del ID: "+ id +" ha sido eliminada satisfactoriamente";
					preStatement.close();
					conexion.desconectar();			
					
				} catch (SQLException e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
					resultado = "Error";
					
				}
				return resultado;
	}

	public List<MascotaVO> consultarMascotas() {
		Connection connection = null;
		Conexion conexion = new Conexion();
		PreparedStatement preStatement = null;
		ResultSet result = null;
		MascotaVO miMascota = null;
		
		ArrayList<MascotaVO> listaMascotas = new ArrayList<MascotaVO>();
		connection = conexion.getConnection();
		String consulta = "SELECT * FROM mascota";
		
		try {
			preStatement = connection.prepareStatement(consulta);
			result = preStatement.executeQuery();
			
			while(result.next()) {
				miMascota= new MascotaVO();
				miMascota.setIdDueño(result.getString("propietario"));
				miMascota.setNombre(result.getString("nombre"));
				miMascota.setSexo(result.getString("sexo"));
				miMascota.setRaza(result.getString("raza"));
				listaMascotas.add(miMascota);
			}
			
		}catch (SQLException e) {
			throw new RuntimeException("Error en la consulta de la mascota" + e.getMessage());
			
		} finally {
			
			try {
				if (result != null) result.close();
				if (preStatement != null) preStatement.close();
				conexion.desconectar();
				
			} catch (SQLException e) {
				throw new RuntimeException("Error al cerrar los recursos: " + e.getMessage());
				
			}
		}
		
			return listaMascotas;
	}
	
	public void setControlador(Controlador miControlador) {
		this.miControlador = miControlador;
		
	}

}
