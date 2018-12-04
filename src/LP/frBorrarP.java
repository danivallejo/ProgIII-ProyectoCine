package LP;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JLabel;

import java.awt.Color;

import javax.swing.SwingConstants;

import LD.BD;

import java.awt.Font;
import java.util.ArrayList;

public class frBorrarP extends JFrame {

	private JPanel contentPane;
	DefaultListModel listModel;
	JOptionPane confirmacion;
	ArrayList<String> peliculas;
	
	/**
	 * Create the frame.
	 */
	public frBorrarP() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 503, 553);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(29, 101, 413, 181);
		contentPane.add(scrollPane);
		
		JButton bBorrar = new JButton("Borrar");
		bBorrar.setBounds(180, 376, 106, 51);
		contentPane.add(bBorrar);
		
		JButton bVolver = new JButton("Volver");
		bVolver.setBounds(12, 23, 97, 25);
		contentPane.add(bVolver);
		
		JLabel lblBorrarPelicula = new JLabel("Borrar Pelicula");
		lblBorrarPelicula.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblBorrarPelicula.setHorizontalAlignment(SwingConstants.CENTER);
		lblBorrarPelicula.setBackground(Color.BLACK);
		lblBorrarPelicula.setBounds(12, 13, 461, 44);
		contentPane.add(lblBorrarPelicula);
				
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
				frPrincipalAdmin ventana = new frPrincipalAdmin ();
				ventana.setVisible(true);
				dispose();
			}
		});
		
		bBorrar.addActionListener( new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				
				try {
					int i;
					String nombre;
					
					
					
					i=listPeliculas.getSelectedIndex();
					nombre=peliculas.get(i);
					
					confirmacion.showConfirmDialog(null, "Estas seguro que quieres borrar la película "+ nombre + "de la base de datos?");
					
					BD.borrarpelicula(nombre);
					
					listModel.remove(listPeliculas.getSelectedIndex());
					
					
								
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				
				
				
					
				
				
				
				
			}
		});

	}
}
