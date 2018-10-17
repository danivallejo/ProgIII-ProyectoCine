package LN;

import java.util.Date;

public class clsPelicula 
{
	private String nombre, sinopsis, director, comentario;
	private double valoracion;
	private int duracion;
	private Date fecha_estreno;
	
	public clsPelicula(String nombre, String sinopsis, String director, String comentario, double valoracion,
			int duracion, Date fecha_estreno) 
	{
		super();
		this.nombre = nombre;
		this.sinopsis = sinopsis;
		this.director = director;
		this.comentario = comentario;
		this.valoracion = valoracion;
		this.duracion = duracion;
		this.fecha_estreno = fecha_estreno;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getSinopsis() {
		return sinopsis;
	}

	public void setSinopsis(String sinopsis) {
		this.sinopsis = sinopsis;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public double getValoracion() {
		return valoracion;
	}

	public void setValoracion(double valoracion) {
		this.valoracion = valoracion;
	}

	public int getDuracion() {
		return duracion;
	}

	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}

	public Date getFecha_estreno() {
		return fecha_estreno;
	}

	public void setFecha_estreno(Date fecha_estreno) {
		this.fecha_estreno = fecha_estreno;
	}
	
	
	
	
}
