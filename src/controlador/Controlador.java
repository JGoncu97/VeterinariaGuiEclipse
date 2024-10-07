package controlador;

import java.util.ArrayList;
import java.util.List;

import dao.MascotaDAO;
import dao.PersonaDAO;
import logica.ModeloDatos;
import logica.Procesos;
import vista.VentanaMascotas;
import vista.VentanaPersonas;
import vista.VentanaPrincipal;
import vo.MascotaVO;
import vo.PersonaVO;

public class Controlador {

	private VentanaPrincipal miVentanaPrincipal;
	private VentanaPersonas miVentanaPersonas;
	private VentanaMascotas miVentanaMascotas;
	private ModeloDatos miModeloDatos;
	private Procesos miProcesos;
	private PersonaDAO miPersonaDAO;
	private MascotaDAO miMascotaDAO;

	public void setVentanaPrincipal(VentanaPrincipal miVentanaPrincipal) {
		this.miVentanaPrincipal = miVentanaPrincipal;
		
	}

	public void setVentanaPersonas(VentanaPersonas miVentanaPersonas) {
		this.miVentanaPersonas = miVentanaPersonas;
		
	}

	public void setVentanaMascotas(VentanaMascotas miVentanaMascotas) {
		this.miVentanaMascotas = miVentanaMascotas;
		
	}
	
	public void setPersonaDAO(PersonaDAO miPersonaDAO) {
		this.miPersonaDAO = miPersonaDAO;
		
	}
	
	public void setMascotaDAO(MascotaDAO miMascotaDAO) {
		this.miMascotaDAO= miMascotaDAO;
	}

	public void setmiModeloDatos(ModeloDatos miModeloDatos) {
		this.miModeloDatos = miModeloDatos;
		
	}

	public void setProcesos(Procesos miProcesos) {
		this.miProcesos = miProcesos;
		
	}

	
	
	public void mostrarVentanaPersonas() {
		miVentanaPersonas.setVisible(true);
		
	}
	
	public void mostrarVentanaMascotas() {
		miVentanaMascotas.setVisible(true);
		
	}
	
	public String registrarPersona(PersonaVO miPersonaVO) {
		return miPersonaDAO.registrarPersona(miPersonaVO);
		
	}
	
	public PersonaVO consultarPersona(String documento) {
		return miPersonaDAO.consultarPersona(documento);
		
	}
	
	public String actualizarPersona(PersonaVO miPersonaVO) {
		return miPersonaDAO.actualizarPersona(miPersonaVO);
		
	}
	
	public String eliminarPersona(String documento) {
		return miPersonaDAO.eliminarPersona(documento);
	}

	public List<PersonaVO> consultarListaPersonas() {
		
		return miPersonaDAO.consultarPersonas();
	}

	public String registrarMascota(MascotaVO miMascota) {
		return miMascotaDAO.registrarMascota(miMascota);
	}

	public String actualizarMascota(MascotaVO miMascota) {
		return miMascotaDAO.actualizarMascota(miMascota);
	}

	public MascotaVO consultarMascota(String id) {
		
		return miMascotaDAO.consultarMascota(id);
	}

	public String eliminarMascota(String id) {
	
		return miMascotaDAO.eliminarMascota(id);
	}

	public List<MascotaVO> consultarListaMascota() {
		
		return miMascotaDAO.consultarMascotas();
	}

	
	

	

}
