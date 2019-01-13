import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import LD.BD;
import LN.clsCompra;
import LN.clsValoracion;

public class ValoracionTest {
	
	clsValoracion valoracion;

	@Before
	public void setUp() throws Exception {
		
	valoracion = new clsValoracion();
	valoracion.setId(50);
	valoracion.setPelicula("Nemo");
	valoracion.setPuntuacion(4);
	
	BD.initBD("CINESA");
	}

	@After
	public void tearDown() throws Exception {
		
		BD.borrarValoracion(valoracion.getPelicula());
	}

	@Test
	public void test() {
		
		int idValoracion2;
		
		try {
			BD.registrarValoracion(valoracion.getId(), valoracion.getPuntucion(), valoracion.getPelicula());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		idValoracion2 = BD.getIdValoracion();
		
		assertEquals(valoracion.getId(), idValoracion2);
	}

}
