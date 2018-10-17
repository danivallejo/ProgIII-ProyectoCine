package LN;

public class clsUsuario extends clsPersona
{
	private String nickUsuario;

	public clsUsuario(String nombre, String apellido, String contrase�a, String nickUsuario) {
		super(nombre, apellido, contrase�a);
		this.nickUsuario = nickUsuario;
	}

	public String getNickUsuario() {
		return nickUsuario;
	}

	public void setNickUsuario(String nickUsuario) {
		this.nickUsuario = nickUsuario;
	}
}
