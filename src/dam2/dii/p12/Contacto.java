package dam2.dii.p12;

public class Contacto {

	private static int idGlobal = 0;
	private String nombre;
	private String apellidos;
	private String email;
	private int telefono;
	private String comentarios;	
	private int id;
	
	public Contacto(String nombre, String apellidos, String email, int telefono, String comentarios) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.email = email;
		this.telefono = telefono;
		this.comentarios = comentarios;
		idGlobal++;
		this.id = idGlobal;
		
	}
	
	public int getId() {
		return id;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getTelefono() {
		return telefono;
	}
	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}
	public String getComentarios() {
		return comentarios;
	}
	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}
	
}
