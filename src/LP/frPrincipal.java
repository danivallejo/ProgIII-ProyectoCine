package LP;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

import LD.BD;
import LN.clsUsuario;

import java.awt.Font;

public class frPrincipal extends JFrame {

	private JPanel contentPane;


	/**
	 * Create the frame.
	 */
	public frPrincipal(clsUsuario user) {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 503, 553);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton bCartelera = new JButton("Cartelera");
		bCartelera.setBounds(145, 76, 192, 72);
		contentPane.add(bCartelera);
		
		JButton bCompra = new JButton("Compra entradas");
		bCompra.setBounds(145, 246, 192, 72);
		contentPane.add(bCompra);
		
		JButton bValorar = new JButton("Valorar peliculas");
		bValorar.setBounds(145, 161, 192, 72);
		contentPane.add(bValorar);
		
		JLabel lblMenuPrincipal = new JLabel("Menu Principal");
		lblMenuPrincipal.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblMenuPrincipal.setHorizontalAlignment(SwingConstants.CENTER);
		lblMenuPrincipal.setBounds(12, 13, 461, 29);
		contentPane.add(lblMenuPrincipal);
		
		JButton bCerrarSesion = new JButton("Cerrar Sesion");
		bCerrarSesion.setBounds(12, 19, 126, 25);
		contentPane.add(bCerrarSesion);
		
		JButton bAnadir = new JButton("A\u00F1adir fondos al monedero");
		bAnadir.setBounds(144, 331, 193, 72);
		contentPane.add(bAnadir);
		
		bCartelera.addActionListener( new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				frCartelera ventana = new frCartelera(user);
				ventana.setVisible(true);
				dispose();
			}
		});
		
		bCompra.addActionListener( new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				frCompra ventana = new frCompra(user);
				ventana.setVisible(true);
				dispose();
			}
		});
		
		bValorar.addActionListener( new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				frValorar ventana = new frValorar(user);
				ventana.setVisible(true);
				dispose();
			}
		});
		
		bCerrarSesion.addActionListener( new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				frInicio ventana = new frInicio();
				ventana.setVisible(true);
				dispose();
			}
		});
		
		bAnadir.addActionListener( new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				frMonedero ventana = new frMonedero(user);
				ventana.setVisible(true);
				dispose();
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
