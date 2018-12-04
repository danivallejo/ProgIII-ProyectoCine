package LN;

public class clsCompra 
{
	
	private int id;
	private String usuario;
	private int cantidad;
	private String nombre;
	
	
	public clsCompra(int id, String usuario, int cantidad, String nombre) {
		
		this.id = id;
		this.usuario = usuario;
		this.cantidad = cantidad;
		this.nombre=nombre;
		
		
	
	}
	
	public clsCompra ()
	{
		id= 0;
		usuario = "";
		cantidad= 0;
		nombre = "";
		
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
}