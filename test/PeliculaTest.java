import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import LD.BD;
import LN.clsCompra;
import LN.clsPelicula;

public class PeliculaTest {
	
	clsPelicula peli;

	@Before
	public void setUp() throws Exception {
		
	peli = new clsPelicula();
	peli.setNombre("Nemo");
	peli.setDirector("Dani");
	peli.setDuracion(120);
	peli.setSinopsis("La vida de un pez payaso");
	peli.setValoracionM(4);
	
	BD.initBD("CINESA");
	}

	@After
	public void tearDown() throws Exception {
		
		BD.borrarpelicula(peli.getNombre());
	}

	@Test
	public void test() {
		
		clsPelicula peli2 = new clsPelicula();
		
		try {
			BD.registrarPelicula(peli.getNombre(), peli.getSinopsis(), peli.getDirector(), peli.getValoracionM(), peli.getDuracion());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		peli2 = BD.getPelicula(peli.getNombre());
		
		assertEquals(peli.getNombre(), peli2.getNombre());
	
	}

}
