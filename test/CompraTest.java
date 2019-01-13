import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import LD.BD;
import LN.clsCompra;

public class CompraTest {
	
	clsCompra compraPelicula;

	@Before
	public void setUp() throws Exception {
	
	compraPelicula = new clsCompra();
	compraPelicula.setId(100);
	compraPelicula.setUsuario("mikel");
	compraPelicula.setNombre("Nemo");
	compraPelicula.setCantidad(3);
	
	BD.initBD("CINESA");
		
	}

	@After
	public void tearDown() throws Exception {
		
		BD.borrarCompra(compraPelicula.getId());
	}

	@Test
	public void test() {
	
	clsCompra compraPelicula2 = new clsCompra();
	
	try {
		BD.registrarCompra(compraPelicula.getId(), compraPelicula.getUsuario(), compraPelicula.getCantidad(), compraPelicula.getNombre());
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	compraPelicula2 = BD.getCompra(compraPelicula.getId());
	
	assertEquals(compraPelicula2.getId(), compraPelicula.getId());
	
	}

}
