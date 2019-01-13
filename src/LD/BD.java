package LD;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import COMUN.clsUsuarioRepetido;
import LN.clsCompra;
import LN.clsValoracion;
import LN.clsPelicula;
import LN.clsUsuario;

public class BD 
{
	private static Logger logger = Logger.getLogger( BD.class.getName() );
	private static Connection connection = null;
	private static Statement statement = null;
	//private static ArrayList <clsOpcEntrenamiento> lista;
	private static ArrayList <clsPelicula> listaPeliculas;
	
	//init BD y crear tabla juntos 
	
	/** Inicializa una BD SQLITE y devuelve una conexión con ella. Debe llamarse a este 
	 * método antes que ningún otro, y debe devolver no null para poder seguir trabajando con la BD.
	 * @param nombreBD	Nombre de fichero de la base de datos
	 * @return	Conexión con la base de datos indicada. Si hay algún error, se devuelve null
	 */
	public static Connection initBD( String nombreBD ) 
	{
		try 
		{
		    Class.forName("org.sqlite.JDBC");
		    connection = DriverManager.getConnection("jdbc:sqlite:" + nombreBD );
			statement = connection.createStatement();
			statement.setQueryTimeout(30);  // poner timeout 30 msg
		    return connection;
		} 
		catch (ClassNotFoundException | SQLException e) 
		{
			return null;
		}
	}
	
	/** Cierra la conexión con la Base de Datos
	 */
	public static void close() {
		try {
			statement.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/** Devuelve la conexión si ha sido establecida previamente (#initBD()).
	 * @return	Conexión con la BD, null si no se ha establecido correctamente.
	 */
	public static Connection getConnection() {
		return connection;
	}
	
	/** Devuelve una sentencia para trabajar con la BD,
	 * si la conexión si ha sido establecida previamente (#initBD()).
	 * @return	Sentencia de trabajo con la BD, null si no se ha establecido correctamente.
	 */
	public static Statement getStatement() {
		return statement;
	}
	
	/**
	 * Crea la tabla usuarios
	 */
	public static void crearTablaUsuarios ()
	{
		if (statement==null) return;
		try 
		{
			statement.executeUpdate("create table if not exists usuarios " +
				"(usuario string, contraseña string, nombre string, apellido string, monedero int, email string, primary key (usuario))");
			
		} 
		catch (SQLException e) 
		{
			logger.log(Level.SEVERE, e.getMessage());
		}
	}
	
	/**
	 * Crea la tabla peliculas
	 */
	public static void crearTablaPeliculas ()
	{
		if (statement==null) return;
		try 
		{
			statement.executeUpdate("create table if not exists peliculas " +
				"(nombre string, sinopsis string, director string, valoracion double, duracion int, primary key (nombre))");
		} 
		catch (SQLException e) 
		{
			logger.log(Level.SEVERE, e.getMessage());
		}
	}
	
	/**
	 * Crea la tabla Valoracion
	 */
	public static void crearTablaValoraciones ()
	{
		if (statement==null) return;
		try 
		{
			statement.executeUpdate("create table if not exists valoraciones " +
				"(id int, puntuacion int, pelicula string, foreign key (pelicula) references pelicula (nombre), primary key (id))");
		} 
		catch (SQLException e) 
		{
			logger.log(Level.SEVERE, e.getMessage());
		}
	}
	
	/**
	 * Crea la tabla compras
	 */
	public static void crearTablaCompras ()
	{
		if (statement==null) return;
		try 
		{
			statement.executeUpdate("create table if not exists compras " +
				"(id int, usuario string, cantidad int, nombre string, primary key (id))");
			
		} 
		catch (SQLException e) 
		{
			logger.log(Level.SEVERE, e.getMessage());
		}
	}
	
	
	/**
	 * Guarda los datos del usuario en la tabla Usuarios
	 * @param usuario
	 * @param contraseña
	 * @param nombre
	 * @param apellido
	 * @throws ClassNotFoundException
	 * @throws clsUsuarioRepetido
	 */
	public static void altaUsuario (String usuario, String contraseña, String nombre, String apellido, int monedero, String email) throws ClassNotFoundException, clsUsuarioRepetido
	{
		try
		{		    
			statement.executeUpdate("insert into usuarios values('"+usuario+"', '"+contraseña+"', '"+nombre+"', '"+apellido+"', "+monedero+",'"+email+"' )");
		}	 
		catch(SQLException e)
		{
			logger.log(Level.WARNING, e.getMessage());
			throw new clsUsuarioRepetido();
			
		} 
	}
	
	/**
	 * Elimina el statement identificado con la nickname de la tabla usuario
	 * @param fecha
	 */
	public static void borrarUsuario (String nickusuario)
	{
		try
		{	
			statement.executeUpdate("delete from usuarios where usuario = '"+nickusuario+"';");
		}	 
		catch(SQLException e)
		{
			logger.log(Level.WARNING, e.getMessage());
		} 
	}
	
	
	/**
	 * Actualiza los atributos del usuario (nombre y apellido)
	 * usando como identificativo el nombre de usuario
	 * @param usuario
	 * @param nombre
	 * @param apellido
	 */
	public static void editarUsuario (String usuario, String nombre, String apellido, String email)
	{
		try
		{		    
			statement.executeUpdate("update usuarios set nombre = '"+nombre+"', apellido = '"+apellido+"', email = '"+email+"' where (usuario = '"+usuario+"');");
		}	 
		catch(SQLException e)
		{
			logger.log(Level.WARNING, e.getMessage());
		} 
	}
	
	/**
	 * Actualiza el monedero del usuario 
	 * usando como identificativo el nombre de usuario
	 * @param usuario
	 * @param monedero
	 */
	public static void editarMonedero (String usuario, int monedero)
	{
		try
		{		    
			statement.executeUpdate("update usuarios set monedero = "+monedero+" where (usuario = '"+usuario+"');");
		}	 
		catch(SQLException e)
		{
			logger.log(Level.WARNING, e.getMessage());
		} 
	}
	
	

	 /**
	  * Comprueba que el usuario y la contraseña son correctas
	  * @param usuario
	  * @param contraseña
	  * @return true si es correcto, false si no coinciden
	  * @throws ClassNotFoundException 
	  */
	public static boolean inicioSesion (String usuario, String contraseña) throws ClassNotFoundException
	{
		try
		{
			statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("select * from usuarios");
		    	
			while(rs.next())
			{
				if (rs.getString("usuario").equals(usuario))
		       	{
					if (rs.getString("contraseña").equals(contraseña))
		       		{
		       			return true;
		       		}
		       	}
			}
		}	 
		catch(SQLException e)
		{
			logger.log(Level.WARNING, e.getMessage());
		}
		return false;
	}
	 
	/**
	 * Método que devuelve el objeto usuario con todos sus atributos
	 * identificandolo mediante el nombre de usuario
	 * @param usuario
	 * @return el objeto usuario
	 */
	public static clsUsuario getUser (String usuario)
	{
		clsUsuario user = new clsUsuario();
		try
		{
			statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("select * from usuarios ");
			while(rs.next())
			{
				if (rs.getString("usuario").equals(usuario))
		       	{
					user.setNickUsuario(usuario);
					user.setContraseña(rs.getString("contraseña"));
					user.setNombre(rs.getString("nombre"));
					user.setApellido(rs.getString("apellido"));
					user.setMonedero(rs.getInt("monedero"));
					user.setEmail(rs.getString("email"));
					
		       	}
			}
		}	 
		catch(SQLException e)
		{
			logger.log(Level.WARNING, e.getMessage());
		}
		return user;
	}
	
	/**
	 * Método para conseguir una valoracion con todos sus atributos
	 * identificandolo meidante la pelicula que valora
	 * @param pelicula
	 * @return la puntuacion
	 */
	public static ArrayList<clsValoracion> getValoracion (String pelicula)
	{
		ArrayList<clsValoracion> listaValoracion =  new ArrayList<clsValoracion>() ;
		clsValoracion valoracion = new clsValoracion();
		try
		{
			statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("select * from valoraciones");
			while(rs.next())
			{
				if (rs.getString("pelicula").equals(pelicula))
		       	{
					valoracion.setId(rs.getInt("id"));
					valoracion.setPuntuacion(rs.getInt("puntuacion"));
					valoracion.setPelicula(rs.getString("pelicula"));
				
					listaValoracion.add(valoracion);
		       	}
			}
		}	 
		catch(SQLException e)
		{
			logger.log(Level.WARNING, e.getMessage());
		}
		return listaValoracion;
	}
	
	
	
	/**
	 * Método para conseguir una valoracion con todos sus atributos
	 * identificandolo meidante la pelicula que valora
	 * @param pelicula
	 * @return la puntuacion
	 */
	public static int getIdValoracion ()
	{
		
		
		int ultimoid=0 ;
		try
		{
			statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("select id from valoraciones");
			while(rs.next())
			{
					ultimoid=rs.getInt("id");
					
					
		    }
			
		}	 
		catch(SQLException e)
		{
			logger.log(Level.WARNING, e.getMessage());
		}
		return ultimoid;
	}
	
	/**
	 * Método que devuelve el objeto usuario con todos sus atributos
	 * identificandolo mediante el nombre de usuario
	 * @param usuario
	 * @return el objeto usuario
	 */
	public static ArrayList<String> getnombrePelicula (ArrayList<String> pelicula)
	{
			
		try
		{
			statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("select nombre from peliculas");
			while(rs.next())
			{
				int i = 0;
		       pelicula.add(i, rs.getString("nombre")); 
		       i++;
					
					
		       	
			}
		}	 
		catch(SQLException e)
		{
			logger.log(Level.WARNING, e.getMessage());
		}
		return pelicula;
	}
	
	public static clsPelicula getPelicula (String nombre)
	{
			clsPelicula pelicula = new clsPelicula ();
		try
		{
			statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("select * from peliculas");
			while(rs.next())
				
			{
				if (rs.getString("nombre").equals(nombre))
				{
					pelicula.setNombre(rs.getString("nombre"));
					pelicula.setSinopsis(rs.getString("sinopsis"));
					pelicula.setDirector(rs.getString("director"));
					pelicula.setDuracion(rs.getInt("duracion"));
					pelicula.setValoracionM(rs.getDouble("valoracion"));
					
					
				}
				
					
					
		       	
			}
		}	 
		catch(SQLException e)
		{
			logger.log(Level.WARNING, e.getMessage());
		}
		return pelicula;
	}
	
	
	
	
	
	
	/**
	 * Guarda los datos de la carrera en la tabla Carrera
	 * @param fecha
	 * @param duracion
	 * @param calorias
	 * @param km
	 * @param ritmo
	 * @param usuario
	 * @throws ClassNotFoundException
	 */
	public static void registrarPelicula (String nombre, String sinopsis, String director, double valoracion, int duracion) throws ClassNotFoundException
	{
		try
		{	
			statement.executeUpdate("insert into peliculas values('"+nombre+"', '"+sinopsis+"', '"+director+"', '"+valoracion+"', "+duracion+")");
		}	 
		catch(SQLException e)
		{
			logger.log(Level.WARNING, e.getMessage());
		} 
	}
	
	/**
	 * Elimina el statement identificado con la nombre de la tabla pelicula
	 * @param fecha
	 */
	public static void borrarpelicula (String nombre)
	{
		try
		{	
			statement.executeUpdate("delete from peliculas where nombre = '"+nombre+"';");
		}	 
		catch(SQLException e)
		{
			logger.log(Level.WARNING, e.getMessage());
		} 
	}
	
	public static void actualizarPelicula (String pelicula, double puntuacion)
	{
		
		try
		{	
			statement.executeUpdate("update peliculas set valoracion = '"+puntuacion+"' where nombre = '"+pelicula+"';");
		}	 
		catch(SQLException e)
		{
			logger.log(Level.WARNING, e.getMessage());
		} 
			
	}
	
	public static ArrayList<Integer> getPuntuaciones (String nombre)
	{
		ArrayList<Integer> puntuaciones=new ArrayList<Integer>();
		int i=0;;
		
		try
		{
			statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("select puntuacion from valoraciones where pelicula = '"+nombre+"';");
			while(rs.next())
				
			{
					
					puntuaciones.add(i, rs.getInt("puntuacion"));
					i++;
				
			}
			
		}catch(SQLException e)
		{
			logger.log(Level.WARNING, e.getMessage());
		} 
		
				
		return puntuaciones;
		
	}
	
	/**
	 * Guarda los datos de la valoracion en la tabla valoracion
	 * @param id
	 * @param puntuacion
	 * @param comentario
	 * @param pelicula
	 * @throws ClassNotFoundException
	 */
	public static void registrarValoracion (int id,int puntuacion, String pelicula) throws ClassNotFoundException
	{
		try
		{	
			statement.executeUpdate("insert into valoraciones values("+id+", "+puntuacion+", '"+pelicula+"')");
		}	 
		catch(SQLException e)
		{
			logger.log(Level.WARNING, e.getMessage());
		} 
	}
	
	/**
	 * Elimina el statement identificado con la fecha de la tabla entrenamiento 
	 * @param fecha
	 */
	public static void borrarValoracion (String pelicula)
	{
		try
		{	
			statement.executeUpdate("delete from valoraciones where pelicula = '"+pelicula+"';");
		}	 
		catch(SQLException e)
		{
			logger.log(Level.WARNING, e.getMessage());
		} 
	}
	
	/**
	 * Guarda los datos de la compra en la tabla compras
	 * @param id
	 * @param usuario
	 * @param cantidad
	 * @param nombre
	 * @throws ClassNotFoundException
	 */
	public static void registrarCompra (int id,String usuario, int cantidad, String nombre) throws ClassNotFoundException
	{
		try
		{	
			statement.executeUpdate("insert into compras values("+id+", '"+usuario+"', "+cantidad+", '"+nombre+"')");
		}	 
		catch(SQLException e)
		{
			logger.log(Level.WARNING, e.getMessage());
		} 
	}
	
	public static int getIdCompra ()
	{
		
		
		int ultimoid=0 ;
		try
		{
			statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("select id from compras");
			while(rs.next())
			{
					ultimoid=rs.getInt("id");
					
					
		    }
			
		}	 
		catch(SQLException e)
		{
			logger.log(Level.WARNING, e.getMessage());
		}
		return ultimoid;
	}
	
	/**
	 * Método que devuelve el objeto Compra con todos sus atributos
	 * identificandolo mediante el id
	 * @param id
	 * @return el objeto Compra
	 */
	public static clsCompra getCompra (int id)
	{
		clsCompra compra = new clsCompra();
		try
		{
			statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("select * from compras ");
			while(rs.next())
			{
				if (rs.getInt("id") == id)
		       	{
					compra.setId(id);
					compra.setUsuario(rs.getString("usuario"));
					compra.setCantidad(rs.getInt("cantidad"));
					compra.setNombre(rs.getString("nombre"));

					
		       	}
			}
		}	 
		catch(SQLException e)
		{
			logger.log(Level.WARNING, e.getMessage());
		}
		return compra;
	}
	
	/**
	 * Elimina el statement identificado con el id de la tabla Compras
	 */
	public static void borrarCompra (int id)
	{
		try
		{	
			statement.executeUpdate("delete from compras where id = "+id+";");
		}	 
		catch(SQLException e)
		{
			logger.log(Level.WARNING, e.getMessage());
		} 
	}
	
	
		
	/**
	 * Método para eliminar todas las tablas de la base de datos
	 */
	public static void Borrar()
	{
		try
		{
			statement = connection.createStatement();
			statement.executeQuery("drop table if exists usuarios");
			statement.executeQuery("drop table if exists peliculas");
			statement.executeQuery("drop table if exists valoraciones");
			statement.executeQuery("drop table if exists compras");
		
		}	 
		catch(SQLException e)
		{
			logger.log(Level.WARNING, e.getMessage());
		}
	}
}