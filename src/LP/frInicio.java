package LP;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.DropMode;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

import LD.BD;
import LN.clsUsuario;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class frInicio extends JFrame {

	private JPanel contentPane;
	private JTextField txtUsuario;
	private JPasswordField pwdPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {

					BD.initBD("CINESA");
					BD.crearTablaPeliculas();
					BD.crearTablaValoraciones();
					BD.crearTablaUsuarios();
					BD.crearTablaCompras();
					
					
					frInicio frame = new frInicio();
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
	public frInicio() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 503, 553);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(173, 265, 132, 22);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		pwdPassword = new JPasswordField();
		pwdPassword.setBounds(173, 329, 132, 22);
		contentPane.add(pwdPassword);
		
		JButton btnIniciarSesin = new JButton("Iniciar sesi\u00F3n");
		btnIniciarSesin.setBounds(173, 375, 132, 25);
		contentPane.add(btnIniciarSesin);
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setBounds(173, 228, 89, 25);
		contentPane.add(lblUsuario);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(173, 300, 113, 16);
		contentPane.add(lblPassword);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(frInicio.class.getResource("/images/images.jpg")));
		lblNewLabel.setBounds(137, 28, 217, 130);
		contentPane.add(lblNewLabel);
		
		JButton bRegistro = new JButton("Registrarse");
		bRegistro.setBounds(173, 449, 132, 25);
		contentPane.add(bRegistro);
		
		JLabel lblElUsuarioO = new JLabel("El usuario o la contrase\u00F1a son erroneos");
		lblElUsuarioO.setVisible(false);
		lblElUsuarioO.setForeground(new Color(204, 0, 0));
		lblElUsuarioO.setBounds(118, 413, 258, 16);
		contentPane.add(lblElUsuarioO);
	
	btnIniciarSesin.addActionListener( new ActionListener() 
	{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				String usuario = txtUsuario.getText();
				usuario = usuario.toUpperCase();
				String contrasenya = String.valueOf(pwdPassword.getPassword());
				contrasenya = contrasenya.toUpperCase();
				try 
				{
					if (usuario.equals("ADMIN") && contrasenya.equals("ADMIN") )
					{
						frPrincipalAdmin ventana1 = new frPrincipalAdmin();
						ventana1.setVisible(true);
						dispose();
					}
					else{
						if (BD.inicioSesion(usuario, contrasenya))
					{
						
						clsUsuario user = BD.getUser(usuario);
						frPrincipal ventana = new frPrincipal (user);
						ventana.setVisible(true);
						dispose();
					}
					else
					{
						lblElUsuarioO.setVisible(true);
						txtUsuario.setText("");
						pwdPassword.setText("");
					}
					}
					
				} 
				catch (ClassNotFoundException e1) 
				{
					e1.printStackTrace();
				}
			}
		});
	
	bRegistro.addActionListener( new ActionListener()
	{
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			frRegistro ventana = new frRegistro();
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

