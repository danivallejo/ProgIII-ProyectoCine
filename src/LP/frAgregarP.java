package LP;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;

import LD.BD;
import LN.clsUsuario;
import LN.clsPelicula;

import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class frAgregarP extends JFrame {

	private JPanel contentPane;
	private JTextField textNombre;
	private JTextField textDuracion;
	private JTextField textSinopsis;
	private JTextField textDirector;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frAgregarP frame = new frAgregarP();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public frAgregarP() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 503, 553);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(26, 88, 56, 16);
		contentPane.add(lblNombre);
		
		textNombre = new JTextField();
		textNombre.setBounds(26, 117, 116, 22);
		contentPane.add(textNombre);
		textNombre.setColumns(10);
		
		JLabel lblDuracin = new JLabel("Duraci\u00F3n");
		lblDuracin.setBounds(26, 152, 56, 16);
		contentPane.add(lblDuracin);
		
		textDuracion = new JTextField();
		textDuracion.setBounds(26, 181, 116, 22);
		contentPane.add(textDuracion);
		textDuracion.setColumns(10);
		
		JLabel lblSinopsis = new JLabel("Sinopsis");
		lblSinopsis.setBounds(211, 88, 56, 16);
		contentPane.add(lblSinopsis);
		
		textSinopsis = new JTextField();
		textSinopsis.setBounds(204, 117, 252, 168);
		contentPane.add(textSinopsis);
		textSinopsis.setColumns(10);
		
		JLabel lblDirector = new JLabel("Director");
		lblDirector.setBounds(26, 220, 56, 16);
		contentPane.add(lblDirector);
		
		textDirector = new JTextField();
		textDirector.setBounds(26, 249, 116, 22);
		contentPane.add(textDirector);
		textDirector.setColumns(10);
		
		JButton bAgregar = new JButton("Agregar");
		bAgregar.setBounds(142, 366, 167, 56);
		contentPane.add(bAgregar);
		
		JButton bVolver = new JButton("Volver");
		bVolver.setBounds(12, 13, 97, 25);
		contentPane.add(bVolver);
		
		JLabel lblAgregarPelcula = new JLabel("AGREGAR PEL\u00CDCULA");
		lblAgregarPelcula.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblAgregarPelcula.setHorizontalAlignment(SwingConstants.CENTER);
		lblAgregarPelcula.setBounds(12, 17, 461, 35);
		contentPane.add(lblAgregarPelcula);
		
		bAgregar.addActionListener( new ActionListener() 
		{
				@Override
				public void actionPerformed(ActionEvent e) 
				{
					String nombre = textNombre.getText();
					nombre = nombre.toUpperCase();
					int duracion= Integer.parseInt(textDuracion.getText());
					String sinopsis = textSinopsis.getText();
					sinopsis = sinopsis.toUpperCase();
					String director = textDirector.getText();
					director = director.toUpperCase();
					
					
					try 
					{
							
						
							
							BD.registrarPelicula(nombre, sinopsis, director, 0.0 ,  duracion);
									
																	
							textNombre.setText("");
							textDuracion.setText("");
							textSinopsis.setText("");
							textDirector.setText("");
							
							JOptionPane.showMessageDialog(null, "La pelicula"+ "" + nombre + "" + "se ha guardado correctamente. ");
						
						}
						
					 
					catch (ClassNotFoundException e1) 
					{
						e1.printStackTrace();
						JOptionPane.showMessageDialog(null, "Lo siento ha habido un problema ");
						
					}
				}
			});
		

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
	}
}
