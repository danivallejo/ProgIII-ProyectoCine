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

//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					frRegistro frame = new frRegistro();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

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
							
							if (rdbtnAceptoLosTrminos.isSelected())	
							{
								BD.altaUsuario(usuario,contrasenya,nombre,apellido, dinerofinal);
							
							clsUsuario user = BD.getUser(usuario);
				
							frPrincipal ventana = new frPrincipal ();
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

