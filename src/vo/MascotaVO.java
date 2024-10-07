package vo;

public class MascotaVO extends AnimalVO{
	
	private String idDueño;
	private String nombre;
	
	
	public MascotaVO (String idDueño, String nombre, String raza, String sexo) {
		this.idDueño = idDueño;
		this.nombre = nombre;
		this.raza = raza;
		this.sexo = sexo;
		
	}
	
	
	public MascotaVO() {
		
	}

	public String getIdDueño() {
		return idDueño;
	}

	public void setIdDueño(String idDueño) {
		this.idDueño = idDueño;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	

	

	@Override
	public String toString() {
		return "Id Dueño = " + idDueño + "\n" +
				"Nombre = " + nombre + "\n" +
				"Raza = " + raza + "\n" +
				"Sexo = " + sexo;
		
	}
	
	

}
