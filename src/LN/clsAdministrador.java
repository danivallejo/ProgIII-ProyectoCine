package LN;

public class clsAdministrador extends clsPersona 
{
	private String nickAdministrador, email;
	private long telefono;
	
	public clsAdministrador(String nombre, String apellido, String contraseña, String nickAdministrador, String email,
			long telefono) {
		super(nombre, apellido, contraseña);
		this.nickAdministrador = nickAdministrador;
		this.email = email;
		this.telefono = telefono;
	}

	public String getNickAdministrador() {
		return nickAdministrador;
	}

	public void setNickAdministrador(String nickAdministrador) {
		this.nickAdministrador = nickAdministrador;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getTelefono() {
		return telefono;
	}

	public void setTelefono(long telefono) {
		this.telefono = telefono;
	}
	
	
	
	

}
