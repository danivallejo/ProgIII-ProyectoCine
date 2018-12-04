package LP;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JScrollPane;

import LD.BD;

public class frValorar extends JFrame {

	private JPanel contentPane;
	
	private javax.swing.JLabel lblNewLabel;
	private javax.swing.JComboBox puntuacion;
	private javax.swing.JButton btnNewButton;
	
	private int calificacion;
	
	private DefaultListModel listModel;
	private JOptionPane agradecer;
	private ArrayList<String> peliculas;
	


	/**
	 * Create the frame.
	 */
	public frValorar() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 503, 553);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Valoraci\u00F3n pel\u00EDculas");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblNewLabel.setBounds(12, 13, 461, 42);
		contentPane.add(lblNewLabel);
		
		puntuacion = new JComboBox();
		puntuacion.setModel(new DefaultComboBoxModel(new String[] {"0", "1", "2", "3", "4", "5"}));
		puntuacion.setMaximumRowCount(11);
		puntuacion.setBounds(39, 333, 167, 31);
		contentPane.add(puntuacion);
		
		JLabel lblPuntuacin = new JLabel("Puntuaci\u00F3n");
		lblPuntuacin.setBounds(40, 304, 96, 16);
		contentPane.add(lblPuntuacin);
		
		JButton bPuntuar = new JButton("Puntuar");
		bPuntuar.setBounds(278, 333, 167, 53);
		contentPane.add(bPuntuar);
		
		JButton bVolver = new JButton("Volver");
		bVolver.setBounds(12, 13, 97, 25);
		contentPane.add(bVolver);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(39, 68, 417, 200);
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
				frPrincipal ventana = new frPrincipal();
				ventana.setVisible(true);
				dispose();
			}
		});
		

		bPuntuar.addActionListener( new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
					int id;
					int numpelicula;
					int valoracionfinal;
					String valoracion;
					String nombre;
					int i;
					int x;
					double p;
					double pu=0.0;
					double resultado;
					int a=0;
					
					ArrayList<Integer> puntuaciones;
					
				try {
							
					numpelicula=listPeliculas.getSelectedIndex();
					nombre=peliculas.get(numpelicula);
					
					
					valoracion=(String) puntuacion.getSelectedItem();
					valoracionfinal=Integer.parseInt(valoracion);
					
					id=BD.getIdValoracion();
					id ++;
					
					BD.registrarValoracion(id, valoracionfinal, nombre);
					
					puntuaciones=BD.getPuntuaciones(nombre);
					
					for( x=0;x<puntuaciones.size();x++)
					{
						p=puntuaciones.get(x);
						pu=p+pu;
						a++;
						System.out.println(p);																	
					}
					
					
					resultado=pu/a;
					
				
					
					BD.actualizarPelicula(nombre, resultado);
					
					
					
					agradecer.showMessageDialog(null, "Gracias por valorar la película "+ nombre + ". Te lo agradecemos.");
					
					
					
					
					
					
								
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		
	}
}
