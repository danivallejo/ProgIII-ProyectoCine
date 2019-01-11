package COMUN;

import javax.swing.JOptionPane;

import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
	
public class EMAIL 
{

	
	private static JOptionPane confirmacion;
	
	    public static void enviarEmail (String email, String ruta){

	           try
	           {
	             // se obtiene el objeto Session. La configuración es para
	             // una cuenta de gmail.
	               Properties props = new Properties();
	               props.put("mail.smtp.host", "smtp.gmail.com");
	               props.setProperty("mail.smtp.starttls.enable", "true");
	               props.setProperty("mail.smtp.port", "587");
	               props.setProperty("mail.smtp.user", "cinesainfo@gmail.com");
	               props.setProperty("mail.smtp.auth", "true");

	               Session session = Session.getDefaultInstance(props, null);
	               // session.setDebug(true);

	               // Se compone la parte del texto
	               BodyPart texto = new MimeBodyPart();
	               texto.setText("Texto del mensaje");

	               // Se compone el adjunto con el archivo
	               BodyPart adjunto = new MimeBodyPart();
	               adjunto.setDataHandler(
	                   new DataHandler(new FileDataSource(ruta))); //Tenemos que poner la ruta
	               adjunto.setFileName(ruta); //dependera del nombre, todo esto variables que hay que pasar por parametro
	               
	               BodyPart adjunto2 = new MimeBodyPart();
	               adjunto2.setDataHandler(
	                   new DataHandler(new FileDataSource("src\\images\\codigo.jpg"))); //ruta de la imagen que está en images
	               adjunto2.setFileName("entradas.jpg");

	               // Una MultiParte para agrupar texto e imagen.
	               MimeMultipart multiParte = new MimeMultipart();
	               multiParte.addBodyPart(texto);
	               multiParte.addBodyPart(adjunto);
	               multiParte.addBodyPart(adjunto2);

	               // Se compone el correo, dando to, from, subject y el
	               // contenido.
	               MimeMessage message = new MimeMessage(session);
	               message.setFrom(new InternetAddress("cinesainfo@gmail.com"));
	               message.addRecipient(
	                   Message.RecipientType.TO,
	                   new InternetAddress(email)); //cambiar el destino al usuario que nos haya hecho la compra
	               message.setSubject("Gracias por tu compra, le enviamos los detalles de su compra:");
	               message.setContent(multiParte);

	               // Se envia el correo.
	               Transport t = session.getTransport("smtp");
	               t.connect("cinesainfo@gmail.com", "MM1997real");
	               t.sendMessage(message, message.getAllRecipients());
	               t.close();
	           }
	           catch (Exception e)
	           {
	               e.printStackTrace();
	           }

	    }
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

