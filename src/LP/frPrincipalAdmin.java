package LP;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.Font;

public class frPrincipalAdmin extends JFrame {

	private JPanel contentPane;

	
	/**
	 * Create the frame.
	 */
	public frPrincipalAdmin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 503, 553);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton bAgregar = new JButton("Agregar Pelicula");
		bAgregar.setBounds(161, 68, 157, 119);
		contentPane.add(bAgregar);
		
		JLabel lblMenuPrincipalAdminitrador = new JLabel("Menu Principal Admin.");
		lblMenuPrincipalAdminitrador.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblMenuPrincipalAdminitrador.setHorizontalAlignment(SwingConstants.CENTER);
		lblMenuPrincipalAdminitrador.setBounds(32, 13, 441, 30);
		contentPane.add(lblMenuPrincipalAdminitrador);
		
		JButton bCerrarSesion = new JButton("Cerrar Sesion");
		bCerrarSesion.setBounds(12, 20, 111, 25);
		contentPane.add(bCerrarSesion);
		
		JButton bBorrarPelicula = new JButton("Borrar Pelicula");
		bBorrarPelicula.setBounds(159, 202, 159, 119);
		contentPane.add(bBorrarPelicula);
		
		
		
		bAgregar.addActionListener( new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				frAgregarP ventana = new frAgregarP ();
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
		
		bBorrarPelicula.addActionListener( new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				frBorrarP ventana = new frBorrarP();
				ventana.setVisible(true);
				dispose();
			}
		});
	}
}
