package LP;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JButton;

import COMUN.clsUsuarioRepetido;
import LD.BD;
import LN.clsUsuario;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.logging.Logger;
import java.awt.Font;

import javax.swing.SwingConstants;
import javax.swing.JComboBox;

public class frRegistro extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	
	private Logger logger = Logger.getLogger(this.getClass().getName());
	private JTextField textField_4;


	/**
	 * Create the frame.
	 */
	public frRegistro() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 503, 553);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(43, 69, 56, 16);
		contentPane.add(lblNombre);
		
		textField = new JTextField();
		textField.setBounds(43, 98, 116, 22);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setBounds(43, 133, 56, 16);
		contentPane.add(lblApellido);
		
		textField_1 = new JTextField();
		textField_1.setBounds(43, 162, 116, 22);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setBounds(43, 197, 56, 16);
		contentPane.add(lblUsuario);
		
		textField_2 = new JTextField();
		textField_2.setBounds(43, 226, 116, 22);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a");
		lblContrasea.setBounds(43, 263, 79, 16);
		contentPane.add(lblContrasea);
		
		textField_3 = new JTextField();
		textField_3.setBounds(43, 292, 116, 22);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JButton bVolver = new JButton("Volver");
		bVolver.setBounds(12, 13, 98, 25);
		contentPane.add(bVolver);
		
		JRadioButton rdbtnAceptoLosTrminos = new JRadioButton("Acepto los t\u00E9rminos de uso de pol\u00EDtica y privacidad de la plataforma");
		rdbtnAceptoLosTrminos.setBackground(Color.LIGHT_GRAY);
		rdbtnAceptoLosTrminos.setBounds(43, 375, 420, 53);
		contentPane.add(rdbtnAceptoLosTrminos);
		
		JButton bAceptar = new JButton("Registrar");
		bAceptar.setBounds(257, 197, 152, 114);
		contentPane.add(bAceptar);
		
		JLabel lblRegistro = new JLabel("Registro");
		lblRegistro.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegistro.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblRegistro.setBounds(12, 13, 461, 43);
		contentPane.add(lblRegistro);
		
		JLabel lblDebeDeAceptar = new JLabel("Debe de aceptar los t\u00E9rminos de uso y la pol\u00EDtica de privacidad");
		lblDebeDeAceptar.setForeground(Color.RED);
		lblDebeDeAceptar.setBounds(65, 422, 420, 22);
		contentPane.add(lblDebeDeAceptar);
		
		JLabel lblMonedero = new JLabel("Monedero");
		lblMonedero.setBounds(257, 69, 70, 16);
		contentPane.add(lblMonedero);
		
		JComboBox monedero = new JComboBox();
		monedero.setModel(new DefaultComboBoxModel(new String[] {"0", "5", "10", "15", "20"}));
		monedero.setBounds(257, 98, 105, 22);
		contentPane.add(monedero);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(257, 133, 56, 16);
		contentPane.add(lblEmail);
		
		textField_4 = new JTextField();
		textField_4.setBounds(257, 162, 116, 22);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		lblDebeDeAceptar.setVisible(false);
		
		// Escuchadores de botones
				bAceptar.addActionListener( new ActionListener() 
				{
					@Override
					public void actionPerformed(ActionEvent e) 
					{
						try
						{
							String usuario = textField_2.getText();
							usuario = usuario.toUpperCase();
							String contrasenya = textField_3.getText();
							contrasenya = contrasenya.toUpperCase();
							String nombre = textField.getText();
							nombre = nombre.toUpperCase();
							String apellido = textField_1.getText();
							apellido = apellido.toUpperCase();
							String dinero=(String) monedero.getSelectedItem();
							int dinerofinal=Integer.parseInt(dinero);
							String email = textField_4.getText();
							
							if (rdbtnAceptoLosTrminos.isSelected())	
							{
								BD.altaUsuario(usuario,contrasenya,nombre,apellido, dinerofinal, email);
							
							clsUsuario user = BD.getUser(usuario);
				
							frPrincipal ventana = new frPrincipal (user);
							ventana.setVisible(true);
							dispose();
							}else 
							{
								lblDebeDeAceptar.setVisible(true);
							}
							
							
						} 
						catch (clsUsuarioRepetido a)
						{
							errorUsuario(a);
						}
						catch (Exception b)
						{
							error(b);
						}
					}
				});
				
				bVolver.addActionListener( new ActionListener() 
				{
					@Override
					public void actionPerformed(ActionEvent e) 
					{
						frInicio ventana = new frInicio ();
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
			
				protected void errorUsuario(clsUsuarioRepetido a)
				{
					JOptionPane.showMessageDialog(this, a.getMessage());
				}
				
				protected void error(Exception b)
				{
					JOptionPane.showMessageDialog(this, b.getStackTrace());
				}

				public Logger getLogger() {
					return logger;
				}

				public void setLogger(Logger logger) {
					this.logger = logger;
				}
	}

