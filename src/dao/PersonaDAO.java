package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.management.RuntimeErrorException;
import javax.swing.JOptionPane;

import conexion.Conexion;
import controlador.Controlador;
import vo.PersonaVO;

public class PersonaDAO {
	
	private Controlador miControlador;

	public String registrarPersona(PersonaVO miPersonaVO) {
		String resultado ="";
		
		if (existeIdDueño(miPersonaVO.getDocumento())) {
	        return "Error: La persona con el Documento: " + miPersonaVO.getDocumento() + " ya existe.";
	    }
		
		Connection connection = null;
		Conexion conexion = new Conexion();
		PreparedStatement preStatement = null;
		
		connection = conexion.getConnection();
		String consulta = "INSERT INTO persona (documento, nombre, telefono) VALUES (?,?,?)"; 
		
		try {
			preStatement = connection.prepareStatement(consulta);
			preStatement.setString(1, miPersonaVO.getDocumento());
			preStatement.setString(2, miPersonaVO.getNombre());
			preStatement.setString(3, miPersonaVO.getTelefono());
			preStatement.execute();
			
			resultado = "Registro de persona exitoso";
			
		} catch (SQLException e) {
			resultado = "Error, No se pudo registrar el usuario " + e.getMessage();
			
		}
		
		conexion.desconectar();		
		
		return resultado;
		
	}
	
	public PersonaVO consultarPersona(String documento) { 
		Connection connection = null;
		Conexion conexion = new Conexion();
		PreparedStatement preStatement = null;
		ResultSet result = null;
		PersonaVO miPersonaVO = null;
		
		connection = conexion.getConnection();
		String consulta = "SELECT documento, nombre, telefono FROM persona WHERE documento =?";
		
		try {
			if (connection != null) {
				preStatement = connection.prepareStatement(consulta);
				preStatement.setString(1, documento);
				result = preStatement.executeQuery();
				
				if (result.next()) {
					miPersonaVO = new PersonaVO();
					miPersonaVO.setDocumento(result.getString("documento"));
					miPersonaVO.setNombre(result.getString("nombre"));
					miPersonaVO.setTelefono(result.getString("telefono"));
					
				}
				
			}			
				
		} catch (SQLException e) {
			throw new RuntimeException("Error en la consulta del usuario" + e.getMessage());
			
		} finally {
			
			try {
				if (result != null) result.close();
				if (preStatement != null) preStatement.close();
				conexion.desconectar();
				
			} catch (SQLException e) {
				throw new RuntimeException("Error al cerrar los recursos: " + e.getMessage());
				
			}
			
		}
		return miPersonaVO;
		
	}
	
	public String actualizarPersona(PersonaVO miPersonaVO) {
		String resultado = "";
		
		Connection connection = null;
		Conexion conexion = new Conexion();
		PreparedStatement preStatement = null;
		connection = conexion.getConnection();
		
		try {
			String consulta = "UPDATE persona SET documento = ?, nombre = ?, telefono = ? WHERE documento = ?";
			preStatement = connection.prepareStatement(consulta);
			preStatement.setString(1, miPersonaVO.getDocumento());
			preStatement.setString(2, miPersonaVO.getNombre());
			preStatement.setString(3, miPersonaVO.getTelefono());
			preStatement.setString(4, miPersonaVO.getDocumento());
			preStatement.executeUpdate();
			
			resultado = "La persona " + miPersonaVO.getNombre() + " Ha sido actualizada";
			
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
	
	public String eliminarPersona (String documento) {

		String resultado = "";
		
		Connection connection = null;
		Conexion conexion = new Conexion();
		PreparedStatement preStatement = null;
		connection = conexion.getConnection();
		
		try {
			String consulta = "DELETE FROM persona WHERE documento = ?";
			preStatement = connection.prepareStatement(consulta);
			preStatement.setString(1, documento);
			preStatement.executeUpdate();
			resultado = "La persona del documento: "+ documento +" ha sido eliminada satisfactoriamente";
			preStatement.close();
			conexion.desconectar();			
			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			resultado = "Error";
			
		}
		return resultado;
		
	}
	
	public  ArrayList<PersonaVO> consultarPersonas(){
		Connection connection = null;
		Conexion conexion = new Conexion();
		PreparedStatement preStatement = null;
		ResultSet result = null;
		PersonaVO miPersonaVO = null;
		
		ArrayList<PersonaVO> listaPersonas = new ArrayList<PersonaVO>();
		connection = conexion.getConnection();
		String consulta = "SELECT * FROM persona";
		
		try {
			preStatement = connection.prepareStatement(consulta);
			result = preStatement.executeQuery();
			
			while(result.next()) {
				miPersonaVO= new PersonaVO();
				miPersonaVO.setDocumento(result.getString("documento"));
				miPersonaVO.setNombre(result.getString("nombre"));
				miPersonaVO.setTelefono(result.getString("telefono"));
				listaPersonas.add(miPersonaVO);
			}
			
		}catch (SQLException e) {
			throw new RuntimeException("Error en la consulta del usuario" + e.getMessage());
			
		} finally {
			
			try {
				if (result != null) result.close();
				if (preStatement != null) preStatement.close();
				conexion.desconectar();
				
			} catch (SQLException e) {
				throw new RuntimeException("Error al cerrar los recursos: " + e.getMessage());
				
			}
		}
		
			return listaPersonas;
			
	}
	
	public boolean existeIdDueño(String documento) {
	    Connection connection = null;
	    Conexion conexion = new Conexion();
	    PreparedStatement preStatement = null;
	    ResultSet result = null;
	    boolean existe = false;
	    
	    String consulta = "SELECT documento FROM persona WHERE documento = ?";
	    
	    try {
	        connection = conexion.getConnection();
	        preStatement = connection.prepareStatement(consulta);
	        preStatement.setString(1, documento);
	        result = preStatement.executeQuery();
	        
	        if (result.next()) {
	            existe = true; 
	        }
	        
	    } catch (SQLException e) {
	        throw new RuntimeException("Error al validar el documento de la Persona: " + e.getMessage());
	        
	    } finally {
	        try {
	            if (result != null) result.close();
	            if (preStatement != null) preStatement.close();
	            conexion.desconectar();
	            
	        } catch (SQLException e) {
	            throw new RuntimeException("Error al cerrar los recursos: " + e.getMessage());
	        }
	    }
	    
	    return existe;
	}

	public void setControlador(Controlador miControlador) {
		this.miControlador = miControlador;
		
	}

}
