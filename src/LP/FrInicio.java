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
import java.awt.Color;

public class FrInicio extends JFrame {

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
					FrInicio frame = new FrInicio();
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
	public FrInicio() {
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
		lblPassword.setBounds(173, 300, 56, 16);
		contentPane.add(lblPassword);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(FrInicio.class.getResource("/images/images.jpg")));
		lblNewLabel.setBounds(137, 28, 217, 130);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Registrarse");
		btnNewButton.setBounds(173, 449, 132, 25);
		contentPane.add(btnNewButton);
		
		JLabel lblElUsuarioO = new JLabel("El usuario o la contrase\u00F1a son erroneos");
		lblElUsuarioO.setVisible(false);
		lblElUsuarioO.setForeground(new Color(204, 0, 0));
		lblElUsuarioO.setBounds(118, 413, 258, 16);
		contentPane.add(lblElUsuarioO);
	}
}
