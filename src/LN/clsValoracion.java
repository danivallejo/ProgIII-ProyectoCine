package LN;

public class clsValoracion {
	
	private int id;
	private int puntuacion;
	private String comentario;
	private String pelicula;
	
	
	public clsValoracion(int id, int puntucion, String comentario, String pelicula) {
		
		this.id = id;
		this.puntuacion = puntuacion;
		this.comentario = comentario;
		this.pelicula = pelicula;
		
		
	
	}
	
	public clsValoracion ()
	{
		id= 0;
		puntuacion = 0;
		comentario = "";
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


	public String getComentario() {
		return comentario;
	}


	public void setComentario(String comentario) {
		this.comentario = comentario;
	}


	public String getPelicula() {
		return pelicula;
	}


	public void setPelicula(String pelicula) {
		this.pelicula = pelicula;
	}
	
	

}
