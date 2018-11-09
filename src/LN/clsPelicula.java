package LN;

import java.util.ArrayList;



public class clsPelicula 
{
	private String nombre, sinopsis, director;
	private ArrayList<clsValoracion> valoracion;
	private int duracion;
	
	public clsPelicula(String nombre, String sinopsis, String director,  ArrayList<clsValoracion> valoracion,
			int duracion) 
	{
		super();
		this.nombre = nombre;
		this.sinopsis = sinopsis;
		this.director = director;
		this.valoracion = valoracion;
		this.duracion = duracion;
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

	public ArrayList<clsValoracion> getValoracion() {
		return valoracion;
	}

	public void setValoracion(ArrayList<clsValoracion> valoracion) {
		this.valoracion = valoracion;
	}

	public int getDuracion() {
		return duracion;
	}

	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}

}
