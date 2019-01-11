package LP;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;

import java.awt.Font;

import javax.swing.SwingConstants;

import LD.BD;
import LN.clsUsuario;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class frMonedero extends JFrame {

	private JPanel contentPane;
	
	

	

	/**
	 * Create the frame.
	 */
	public frMonedero(clsUsuario user) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 503, 553);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JComboBox comboBoxDinero = new JComboBox();
		comboBoxDinero.setModel(new DefaultComboBoxModel(new String[] {"0", "5", "10", "15", "20"}));
		comboBoxDinero.setBounds(30, 148, 187, 43);
		contentPane.add(comboBoxDinero);
		
		JLabel lblDinero = new JLabel("Dinero");
		lblDinero.setBounds(31, 113, 79, 22);
		contentPane.add(lblDinero);
		
		JButton btnAnadir = new JButton("A\u00F1adir al monedero");
		btnAnadir.setBounds(158, 362, 154, 86);
		contentPane.add(btnAnadir);
		
		JLabel lblAadirFondosAl = new JLabel("A\u00F1adir fondos al monedero");
		lblAadirFondosAl.setHorizontalAlignment(SwingConstants.CENTER);
		lblAadirFondosAl.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblAadirFondosAl.setBounds(36, 24, 437, 33);
		contentPane.add(lblAadirFondosAl);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.setBounds(12, 21, 87, 25);
		contentPane.add(btnVolver);
		
		
		btnVolver.addActionListener( new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				frPrincipal ventana = new frPrincipal (user);
				ventana.setVisible(true);
				dispose();
			}
		});
		
		btnAnadir.addActionListener( new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				
				String usuario=user.getNickUsuario();
				
				String dinero=(String) comboBoxDinero.getSelectedItem();
				int dinerofinal=Integer.parseInt(dinero);
				
				int monedero= dinerofinal + user.getMonedero();
				
				
				if (dinero=="-1")
				{
					JOptionPane.showMessageDialog(null, "Por favor, indica la cantidad que quieres añadir al monedero. ");
					
				}else
				{
					BD.editarMonedero(usuario, monedero);
				}
				
				
				JOptionPane.showMessageDialog(null, "Se ha actualizado el monedero de " +usuario+ "en " +dinerofinal+ "€");
				
		
				
				
				
				
				
				
				
				
				
				
				
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
