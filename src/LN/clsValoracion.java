package LN;

public class clsValoracion {
	
	private int id;
	private int puntucion;
	private String comentario;
	private String pelicula;
	
	
	public clsValoracion(int id, int puntucion, String comentario, String pelicula) {
		
		this.id = id;
		this.puntucion = puntucion;
		this.comentario = comentario;
		this.pelicula = pelicula;
		
		
	
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getPuntucion() {
		return puntucion;
	}


	public void setPuntucion(int puntucion) {
		this.puntucion = puntucion;
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
