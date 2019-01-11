package LD;

import java.io.*;

import javax.swing.JOptionPane;

public class crearFichero 
{
	public static void Escribir (String ruta, int dinero, int cantidad)
	{
		File f;
		FileWriter w;
		BufferedWriter bw;
		PrintWriter wr;
		
		try{
			
		f= new File(ruta);
		w=new FileWriter(f);
		bw=new BufferedWriter (w);
		wr=new PrintWriter(bw);
		
		
		wr.write("La factura es de " + dinero + "euros.");
		wr.write("\n");
		wr.write("Has comprado " + cantidad + " tickets." );
		wr.write("En la imagen adjunta que se envia en el correo, tienes el código QR con las entradas. Gracias por la compra. ");
		
		wr.close();
		bw.close();
			
		}catch (Exception e){
			JOptionPane.showMessageDialog(null, "Ha ocurrido un problema al crear el archivo de texto.");
		}
	}
	
}
