package logica;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import controlador.Controlador;
import vo.MascotaVO;
import vo.PersonaVO;

public class ModeloDatos {

	private Controlador miControlador;
	private HashMap<String, PersonaVO> mapaPersonas;
	private HashMap<String, MascotaVO> mapaMascotas;
	
	public ModeloDatos() {
		mapaPersonas = new HashMap<String, PersonaVO>();
		mapaMascotas = new HashMap<String, MascotaVO>();
		
	}
	
	public String registrarPersona(PersonaVO miPersonaVO) {
		if (!mapaPersonas.containsKey(miPersonaVO.getDocumento())) {
			mapaPersonas.put(miPersonaVO.getDocumento(), miPersonaVO);
			return "Registro de persona exitoso";
			
		} else {
			return "La persona que desea registrar ya se encuentra en la base de datos";
					
		}
				
	}
	
	public String registarMascota(MascotaVO miMascotaVO) {
		
		return null;
		
	}
	
	public void consultarPersona(String documento) {
		mapaPersonas.get(documento);
		
	}
	
	public void consultarMascotas() {
		
	}
	
	public String actualizarPersona(PersonaVO miPersonaVO) {
		if (mapaPersonas.containsKey(miPersonaVO.getDocumento())) {
			mapaPersonas.put(miPersonaVO.getDocumento(), miPersonaVO);
			return "La persona " + miPersonaVO.getNombre() + "Ha sido actualizada";
			
		} else {
			return "La persona que intenta actualizar no existe en la base de datos";
			
		}
		
	}
	
	public void actualizarMascota() {
		
	}
	
	public String eliminarPersona(String documento) {
		if (mapaPersonas.containsKey(documento)) {
			mapaPersonas.remove(documento);
			return "La persona ha sido eliminada satisfactoriamente";
			
		} else {
			return "La persona que esta intentando eliminar no se encuentra en la base de datos";
			
		}
		
	}
	
	public void eliminarMascota() {
		
	}	
	
	public void setControlador(Controlador miControlador) {
		this.miControlador = miControlador;
		
	}

}
