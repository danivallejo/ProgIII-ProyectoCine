import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import COMUN.clsUsuarioRepetido;
import LD.BD;
import LN.clsUsuario;


public class Registrotest {
	
	
clsUsuario user ;




	@Before
	public void setUp() throws Exception {
		
		
		user= new clsUsuario();
		user.setNombre("aaaaa");
		user.setApellido("aaaaa");
		user.setNickUsuario("aaaaa");
		user.setContraseña("aaaaa");
		user.setEmail("aaaaa@gmail.com");
		user.setMonedero(5);
		
		BD.initBD("CINESA");
		
		
	}

	@After
	public void tearDown() throws Exception {
		
		
		BD.borrarUsuario(user.getNickUsuario());
		
		
		
		
	}

	
	
	
	
	
	
	
	@Test
	public void test() {
		
		clsUsuario user1=new clsUsuario();
		
		System.out.println(user.getNickUsuario());
		System.out.println(user.getApellido());
		System.out.println(user.getContraseña());
		System.out.println(user.getEmail());
		System.out.println(user.getMonedero());
		System.out.println(user.getNombre());
		
		try {
			try {
				BD.altaUsuario(user.getNickUsuario(), user.getContraseña(), user.getNombre(), user.getApellido(), user.getMonedero(), user.getEmail());
			} catch (clsUsuarioRepetido e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		
		user1=BD.getUser(user.getNickUsuario());
		
		assertEquals(user.getNickUsuario(), user1.getNickUsuario());
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
