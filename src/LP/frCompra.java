package LP;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.SwingConstants;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JScrollBar;
import javax.swing.JSpinner;
import javax.swing.JScrollPane;

import COMUN.EMAIL;
import LD.BD;
import LD.crearFichero;
import LN.clsUsuario;

public class frCompra extends JFrame {

	private JPanel contentPane;
	DefaultListModel listModel;
	ArrayList<String> peliculas;
	private JOptionPane avisar;
	private JOptionPane gracias;

	/**
	 * Create the frame.
	 */
	public frCompra(clsUsuario user) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 503, 553);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Compra entradas");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblNewLabel.setBounds(12, 13, 461, 40);
		contentPane.add(lblNewLabel);
		
		JLabel lblPelculas = new JLabel("Pel\u00EDculas");
		lblPelculas.setBounds(22, 67, 56, 16);
		contentPane.add(lblPelculas);
		
		JButton bComprar = new JButton("COMPRAR");
		bComprar.setBounds(150, 413, 179, 58);
		contentPane.add(bComprar);
		
		JSpinner tickets = new JSpinner();
		tickets.setBounds(262, 277, 67, 40);
		contentPane.add(tickets);
		
		JLabel lblCantidadTickets = new JLabel("CANTIDAD TICKETS");
		lblCantidadTickets.setBounds(105, 283, 145, 28);
		contentPane.add(lblCantidadTickets);
		
		JButton bVolver = new JButton("Volver");
		bVolver.setBounds(12, 13, 97, 25);
		contentPane.add(bVolver);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(22, 96, 442, 140);
		contentPane.add(scrollPane);
		
		
		listModel=new DefaultListModel ();
		
		JList listPeliculas = new JList();
		scrollPane.setViewportView(listPeliculas);
		listPeliculas.setModel(listModel);
		
		peliculas= new ArrayList<String>();
		peliculas= BD.getnombrePelicula(peliculas);
		
		for (int i=0; i<peliculas.size(); i++)
		{
			listModel.add(i, peliculas.get(i));
		}
		
		scrollPane.setViewportView(listPeliculas);
		
		
		
		bVolver.addActionListener( new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				frPrincipal ventana = new frPrincipal(user);
				ventana.setVisible(true);
				dispose();
			}
		});
		
		
		bComprar.addActionListener( new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				int id;
				int numpelicula;
				int cantidadfinal;
				String usuario;
				String cantidad;
				String email;
				String nombre;
				int monederousu;
				int gastado;
				int nuevomonedero;
				String ruta=null;
			
				
			try {
						
				numpelicula=listPeliculas.getSelectedIndex();
				nombre=peliculas.get(numpelicula);
				
				
				cantidad= tickets.getValue().toString();
				cantidadfinal=Integer.parseInt(cantidad);
				
				id=BD.getIdCompra(); 
				id ++;
				
				ruta="Compra"+id+".txt";
				
				usuario=user.getNickUsuario();
				monederousu=user.getMonedero();
				
				gastado=cantidadfinal*5;
				
				nuevomonedero=monederousu-gastado;
				
				
				
				if(monederousu-gastado>=0)
				{
					
					BD.registrarCompra(id, usuario, cantidadfinal, nombre);
					
					BD.editarMonedero(usuario, nuevomonedero);
					
					JOptionPane.showMessageDialog(null, "Gracias por comprar " + cantidadfinal + " tickets para la película "+ nombre + " . ");
					
					crearFichero.Escribir(ruta, gastado, cantidadfinal);
					
					
					
					email=user.getEmail();
					EMAIL.enviarEmail(email, ruta);
					
					
					frPrincipal ventana = new frPrincipal (user);
					ventana.setVisible(true);
					dispose();
					
				}else
				{
					
					
					
					avisar.showInputDialog("No dispone de suficientes fondos, porfavor introduzca dinero en su monedero. Gracias!");
				}
							
				
							
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
				
				
				
				
				
			
		});
		
		this.addWindowListener(new WindowListener()
		{
			public void windowClosing(WindowEvent arg0)
			{
				BD.close();
				
			}

			@Override
			public void windowActivated(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowClosed(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowDeactivated(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowDeiconified(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowIconified(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowOpened(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		}
				
				
				
				
				
				
				
				
				
				
				
				
				);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
