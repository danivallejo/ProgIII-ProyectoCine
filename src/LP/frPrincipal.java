package LP;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;

public class frPrincipal extends JFrame {

	private JPanel contentPane;


	/**
	 * Create the frame.
	 */
	public frPrincipal() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 503, 553);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton bCartelera = new JButton("Cartelera");
		bCartelera.setBounds(145, 76, 192, 108);
		contentPane.add(bCartelera);
		
		JButton bCompra = new JButton("Compra entradas");
		bCompra.setBounds(145, 346, 192, 121);
		contentPane.add(bCompra);
		
		JButton bValorar = new JButton("Valorar peliculas");
		bValorar.setBounds(145, 211, 192, 108);
		contentPane.add(bValorar);
		
		JLabel lblMenuPrincipal = new JLabel("Menu Principal");
		lblMenuPrincipal.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblMenuPrincipal.setHorizontalAlignment(SwingConstants.CENTER);
		lblMenuPrincipal.setBounds(12, 13, 461, 29);
		contentPane.add(lblMenuPrincipal);
		
		JButton bCerrarSesion = new JButton("Cerrar Sesion");
		bCerrarSesion.setBounds(12, 19, 111, 25);
		contentPane.add(bCerrarSesion);
		
		bCartelera.addActionListener( new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				frCartelera ventana = new frCartelera();
				ventana.setVisible(true);
				dispose();
			}
		});
		
		bCompra.addActionListener( new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				frCompra ventana = new frCompra();
				ventana.setVisible(true);
				dispose();
			}
		});
		
		bValorar.addActionListener( new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				frValorar ventana = new frValorar();
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
	}
}
