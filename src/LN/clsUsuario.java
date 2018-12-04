package LN;

public class clsUsuario extends clsPersona
{
	private String nickUsuario;
	private int monedero;

	public clsUsuario(String nombre, String apellido, String contraseņa, String nickUsuario, int monedero) 
	{
		super(nombre, apellido, contraseņa);
		this.nickUsuario = nickUsuario;
		this.monedero = monedero;
	}
	public clsUsuario()
	{
		super();
		nickUsuario ="";
		monedero= 0;
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
	
	
}
