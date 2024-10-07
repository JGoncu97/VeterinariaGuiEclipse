package vo;

public class PersonaVO {
	
	private String documento;
	private String nombre;
	private String telefono;
	
	public PersonaVO(String documento, String nombre, String telefono) {
		this.documento = documento;
		this.nombre = nombre;
		this.telefono = telefono;
		
	}	
	
	public PersonaVO() {
		
	}


	public String getDocumento() {
		return documento;
	}
	
	public void setDocumento(String documento) {
		this.documento = documento;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getTelefono() {
		return telefono;
	}
	
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	@Override
	public String toString() {
		return "Nombre = " + nombre + "\n" +
				"Documento = " + documento + "\n" +
				"Telefono = " + telefono;
		
	}
	

}
