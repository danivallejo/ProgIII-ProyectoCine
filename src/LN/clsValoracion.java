package LN;

public class clsValoracion {
	
	private int id;
	private int puntuacion;
	private String pelicula;
	
	
	public clsValoracion(int id, int puntucion, String pelicula) {
		
		this.id = id;
		this.puntuacion = puntuacion;
		this.pelicula = pelicula;
		
		
	
	}
	
	public clsValoracion ()
	{
		id= 0;
		puntuacion = 0;
		pelicula = "";
		
		
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getPuntucion() {
		return puntuacion;
	}


	public void setPuntuacion(int puntucion) {
		this.puntuacion = puntucion;
	}


	public String getPelicula() {
		return pelicula;
	}


	public void setPelicula(String pelicula) {
		this.pelicula = pelicula;
	}
	
	

}
