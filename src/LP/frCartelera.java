package LP;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JTextPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.image.BufferedImage;

import javax.swing.SwingConstants;
import javax.swing.JButton;

import LD.BD;
import LN.clsPelicula;
import LN.clsUsuario;

import java.awt.Color;
import java.io.File;
import java.util.ArrayList;

import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

public class frCartelera extends JFrame {

	private JPanel contentPane;
	DefaultListModel listModel;
	ArrayList<String> peliculas;
	private JOptionPane aviso;
	


	/**
	 * Create the frame.
	 */
	public frCartelera(clsUsuario user) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 511, 557);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNombre = new JLabel("T\u00EDtulo");
		lblNombre.setBounds(12, 247, 56, 16);
		contentPane.add(lblNombre);
		
		JLabel lblDuracin = new JLabel("Duraci\u00F3n");
		lblDuracin.setBounds(12, 309, 56, 16);
		contentPane.add(lblDuracin);
		
		JLabel lblDescripcin = new JLabel("Descripci\u00F3n");
		lblDescripcin.setBounds(12, 374, 70, 16);
		contentPane.add(lblDescripcin);
		
		JLabel lblVotacin = new JLabel("Votaci\u00F3n");
		lblVotacin.setBounds(234, 309, 56, 16);
		contentPane.add(lblVotacin);
		
		JTextPane textDescripcion = new JTextPane();
		textDescripcion.setBounds(12, 403, 461, 90);
		contentPane.add(textDescripcion);
		
		JTextPane textTitulo = new JTextPane();
		textTitulo.setBounds(12, 276, 191, 27);
		contentPane.add(textTitulo);
		
		JTextPane textDuracion = new JTextPane();
		textDuracion.setBounds(12, 338, 191, 27);
		contentPane.add(textDuracion);
		
		JLabel lblNewLabel = new JLabel("Cartelera");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblNewLabel.setBounds(12, 13, 461, 37);
		contentPane.add(lblNewLabel);
		
		JLabel lblDirector = new JLabel("Director");
		lblDirector.setBounds(234, 247, 56, 16);
		contentPane.add(lblDirector);
		
		JTextPane textDirector = new JTextPane();
		textDirector.setBounds(234, 276, 190, 27);
		contentPane.add(textDirector);
		
		JButton bVolver = new JButton("Volver");
		bVolver.setBounds(12, 13, 97, 25);
		contentPane.add(bVolver);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 51, 304, 179);
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
		
		JLabel lbl0star = new JLabel("New label");
		lbl0star.setIcon(new ImageIcon(frCartelera.class.getResource("/images/0starsfinal.jpg")));
		lbl0star.setBounds(223, 338, 48, 44);
		contentPane.add(lbl0star);
		
		JLabel lbl1star = new JLabel("New label");
		lbl1star.setIcon(new ImageIcon(frCartelera.class.getResource("/images/0starsfinal.jpg")));
		lbl1star.setBounds(272, 338, 48, 44);
		contentPane.add(lbl1star);
		
		JLabel lbl2star = new JLabel("New label");
		lbl2star.setIcon(new ImageIcon(frCartelera.class.getResource("/images/0starsfinal.jpg")));
		lbl2star.setBounds(321, 338, 48, 44);
		contentPane.add(lbl2star);
		
		JLabel lbl3star = new JLabel("New label");
		lbl3star.setIcon(new ImageIcon(frCartelera.class.getResource("/images/0starsfinal.jpg")));
		lbl3star.setBounds(370, 338, 48, 44);
		contentPane.add(lbl3star);
		
		JLabel lbl4star = new JLabel("New label");
		lbl4star.setIcon(new ImageIcon(frCartelera.class.getResource("/images/0starsfinal.jpg")));
		lbl4star.setBounds(419, 338, 48, 44);
		contentPane.add(lbl4star);
		
		JButton bVer = new JButton("Ver");
		bVer.setBounds(356, 125, 97, 44);
		contentPane.add(bVer);
		
		
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
		
		bVer.addActionListener( new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				try{
					int numpelicula;
					String nombre;
					double valoracion;
					
				
				numpelicula=listPeliculas.getSelectedIndex();
				if(numpelicula!=-1)
				{
				nombre=peliculas.get(numpelicula);
				
				clsPelicula peliculaVer =new clsPelicula ();
				peliculaVer=BD.getPelicula(nombre);
				
				textTitulo.setText(peliculaVer.getNombre());
				textDuracion.setText(String.valueOf(peliculaVer.getDuracion()));
				textDescripcion.setText(peliculaVer.getSinopsis());
				textDirector.setText(peliculaVer.getDirector());
				
				

			    
				
				valoracion= peliculaVer.getValoracionM();
				
					if(valoracion < 0.4)
					{
						
						lbl0star.setIcon(new ImageIcon(frCartelera.class.getResource("/images/0starsfinal.jpg")));
						lbl1star.setIcon(new ImageIcon(frCartelera.class.getResource("/images/0starsfinal.jpg")));
						lbl2star.setIcon(new ImageIcon(frCartelera.class.getResource("/images/0starsfinal.jpg")));
						lbl3star.setIcon(new ImageIcon(frCartelera.class.getResource("/images/0starsfinal.jpg")));
						lbl4star.setIcon(new ImageIcon(frCartelera.class.getResource("/images/0starsfinal.jpg")));
						
					} 
					else if (valoracion >= 0.4 && valoracion < 1.0)
						{
						
						lbl0star.setIcon(new ImageIcon(frCartelera.class.getResource("/images/halffinal.jpg")));
						lbl1star.setIcon(new ImageIcon(frCartelera.class.getResource("/images/0starsfinal.jpg")));
						lbl2star.setIcon(new ImageIcon(frCartelera.class.getResource("/images/0starsfinal.jpg")));
						lbl3star.setIcon(new ImageIcon(frCartelera.class.getResource("/images/0starsfinal.jpg")));
						lbl4star.setIcon(new ImageIcon(frCartelera.class.getResource("/images/0starsfinal.jpg")));
						
						
						}else if ( valoracion < 1.5)
							{
							
							
							
						lbl0star.setIcon(new ImageIcon(frCartelera.class.getResource("/images/Starsfinal.jpg")));
						lbl1star.setIcon(new ImageIcon(frCartelera.class.getResource("/images/0starsfinal.jpg")));
						lbl2star.setIcon(new ImageIcon(frCartelera.class.getResource("/images/0starsfinal.jpg")));
						lbl3star.setIcon(new ImageIcon(frCartelera.class.getResource("/images/0starsfinal.jpg")));
						lbl4star.setIcon(new ImageIcon(frCartelera.class.getResource("/images/0starsfinal.jpg")));
						

							
						
							}else if (valoracion >= 1.5 && valoracion < 2.0)
								{
							
								lbl0star.setIcon(new ImageIcon(frCartelera.class.getResource("/images/Starsfinal.jpg")));
								lbl1star.setIcon(new ImageIcon(frCartelera.class.getResource("/images/halffinal.jpg")));
								lbl2star.setIcon(new ImageIcon(frCartelera.class.getResource("/images/0starsfinal.jpg")));
								lbl3star.setIcon(new ImageIcon(frCartelera.class.getResource("/images/0starsfinal.jpg")));
								lbl4star.setIcon(new ImageIcon(frCartelera.class.getResource("/images/0starsfinal.jpg")));
							
								} else if (valoracion < 2.5)
									{
									
									lbl0star.setIcon(new ImageIcon(frCartelera.class.getResource("/images/Starsfinal.jpg")));
									lbl1star.setIcon(new ImageIcon(frCartelera.class.getResource("/images/Starsfinal.jpg")));
									lbl2star.setIcon(new ImageIcon(frCartelera.class.getResource("/images/0starsfinal.jpg")));
									lbl3star.setIcon(new ImageIcon(frCartelera.class.getResource("/images/0starsfinal.jpg")));
									lbl4star.setIcon(new ImageIcon(frCartelera.class.getResource("/images/0starsfinal.jpg")));
									
									}else if (valoracion >= 2.5 && valoracion < 3.0)
										{
										
										lbl0star.setIcon(new ImageIcon(frCartelera.class.getResource("/images/Starsfinal.jpg")));
										lbl1star.setIcon(new ImageIcon(frCartelera.class.getResource("/images/Starsfinal.jpg")));
										lbl2star.setIcon(new ImageIcon(frCartelera.class.getResource("/images/halffinal.jpg")));
										lbl3star.setIcon(new ImageIcon(frCartelera.class.getResource("/images/0starsfinal.jpg")));
										lbl4star.setIcon(new ImageIcon(frCartelera.class.getResource("/images/0starsfinal.jpg")));
										
										contentPane.add(lbl3star);
										
										}else if ( valoracion < 3.5)
											{
											
											lbl0star.setIcon(new ImageIcon(frCartelera.class.getResource("/images/Starsfinal.jpg")));
											lbl1star.setIcon(new ImageIcon(frCartelera.class.getResource("/images/Starsfinal.jpg")));
											lbl2star.setIcon(new ImageIcon(frCartelera.class.getResource("/images/Starsfinal.jpg")));
											lbl3star.setIcon(new ImageIcon(frCartelera.class.getResource("/images/0starsfinal.jpg")));
											lbl4star.setIcon(new ImageIcon(frCartelera.class.getResource("/images/0starsfinal.jpg")));
											
											}else if (valoracion >= 3.5 && valoracion < 4.0)
												{
												
												lbl0star.setIcon(new ImageIcon(frCartelera.class.getResource("/images/Starsfinal.jpg")));
												lbl1star.setIcon(new ImageIcon(frCartelera.class.getResource("/images/Starsfinal.jpg")));
												lbl2star.setIcon(new ImageIcon(frCartelera.class.getResource("/images/Starsfinal.jpg")));
												lbl3star.setIcon(new ImageIcon(frCartelera.class.getResource("/images/halffinal.jpg")));
												lbl4star.setIcon(new ImageIcon(frCartelera.class.getResource("/images/0starsfinal.jpg")));
												
												}else if (valoracion < 4.5)
													{
													
													lbl0star.setIcon(new ImageIcon(frCartelera.class.getResource("/images/Starsfinal.jpg")));
													lbl1star.setIcon(new ImageIcon(frCartelera.class.getResource("/images/Starsfinal.jpg")));
													lbl2star.setIcon(new ImageIcon(frCartelera.class.getResource("/images/Starsfinal.jpg")));
													lbl3star.setIcon(new ImageIcon(frCartelera.class.getResource("/images/Starsfinal.jpg")));
													lbl4star.setIcon(new ImageIcon(frCartelera.class.getResource("/images/0starsfinal.jpg")));
													
													}else if (valoracion >= 4.5 && valoracion < 5.0)
														{
														
														lbl0star.setIcon(new ImageIcon(frCartelera.class.getResource("/images/Starsfinal.jpg")));
														lbl1star.setIcon(new ImageIcon(frCartelera.class.getResource("/images/Starsfinal.jpg")));
														lbl2star.setIcon(new ImageIcon(frCartelera.class.getResource("/images/Starsfinal.jpg")));
														lbl3star.setIcon(new ImageIcon(frCartelera.class.getResource("/images/Starsfinal.jpg")));
														lbl4star.setIcon(new ImageIcon(frCartelera.class.getResource("/images/halffinal.jpg")));
														
														}else 
														{
															lbl0star.setIcon(new ImageIcon(frCartelera.class.getResource("/images/Starsfinal.jpg")));
															lbl1star.setIcon(new ImageIcon(frCartelera.class.getResource("/images/Starsfinal.jpg")));
															lbl2star.setIcon(new ImageIcon(frCartelera.class.getResource("/images/Starsfinal.jpg")));
															lbl3star.setIcon(new ImageIcon(frCartelera.class.getResource("/images/Starsfinal.jpg")));
															lbl4star.setIcon(new ImageIcon(frCartelera.class.getResource("/images/Starsfinal.jpg")));
														}
				
				
				
				
				
				}else
				{
					aviso.showInputDialog(" Por favor seleccione una pelicula. Gracias. ");
					
					
					
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
