package LN;

public class clsUsuario extends clsPersona
{
	private String nickUsuario;
	private int monedero;
	private String email;

	public clsUsuario(String nombre, String apellido, String contraseña, String nickUsuario, int monedero, String email) 
	{
		super(nombre, apellido, contraseña);
		this.nickUsuario = nickUsuario;
		this.monedero = monedero;
		this.email = email;
	}
	public clsUsuario()
	{
		super();
		nickUsuario ="";
		monedero= 0;
		email="";
	}

	public String getNickUsuario() 
	{
		return nickUsuario;
	}

	public void setNickUsuario(String nickUsuario) {
		this.nickUsuario = nickUsuario;
	}
	public int getMonedero() {
		return monedero;
	}
	public void setMonedero(int monedero) {
		this.monedero = monedero;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
