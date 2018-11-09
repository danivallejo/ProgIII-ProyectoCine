package LN;

public class clsUsuario extends clsPersona
{
	private String nickUsuario;

	public clsUsuario(String nombre, String apellido, String contraseņa, String nickUsuario) 
	{
		super(nombre, apellido, contraseņa);
		this.nickUsuario = nickUsuario;
	}
	public clsUsuario()
	{
		super();
		nickUsuario ="";
	}

	public String getNickUsuario() 
	{
		return nickUsuario;
	}

	public void setNickUsuario(String nickUsuario) {
		this.nickUsuario = nickUsuario;
	}
}
