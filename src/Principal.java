import controlador.Controlador;
import dao.MascotaDAO;
import dao.PersonaDAO;
import logica.ModeloDatos;
import logica.Procesos;
import vista.VentanaMascotas;
import vista.VentanaPersonas;
import vista.VentanaPrincipal;

public class Principal {

	public static void main(String[] args) {
		Controlador miControlador = new Controlador();
		
		VentanaPrincipal miVentanaPpal = new VentanaPrincipal();
		VentanaPersonas miVentanaP = new VentanaPersonas();
		VentanaMascotas miVentanaM = new VentanaMascotas();
		
		PersonaDAO miPersonaDAO = new PersonaDAO();
		MascotaDAO miMascotaDAO = new MascotaDAO();
		
		ModeloDatos miModeloDatos = new ModeloDatos();
		
		Procesos miProcesos = new Procesos();
		
		miVentanaPpal.setControlador(miControlador);
		miVentanaP.setControlador(miControlador);
		miVentanaM.setControlador(miControlador);
		miPersonaDAO.setControlador(miControlador);
		miMascotaDAO.setControlador(miControlador);
		miModeloDatos.setControlador(miControlador);
		miProcesos.setControlador(miControlador);
		
		miControlador.setVentanaPrincipal(miVentanaPpal);
		miControlador.setVentanaPersonas(miVentanaP);
		miControlador.setVentanaMascotas(miVentanaM);
		miControlador.setPersonaDAO(miPersonaDAO);
		miControlador.setMascotaDAO(miMascotaDAO);
		miControlador.setmiModeloDatos(miModeloDatos);
		miControlador.setProcesos(miProcesos);
		
		miVentanaPpal.setVisible(true);

	}

}
