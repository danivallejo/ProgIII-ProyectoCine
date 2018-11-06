package LP;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.Color;

public class frRegistro extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frRegistro frame = new frRegistro();
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
	public frRegistro() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 503, 553);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(43, 98, 116, 22);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(43, 69, 56, 16);
		contentPane.add(lblNombre);
		
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
		
		JRadioButton rdbtnAceptoLosTrminos = new JRadioButton("Acepto los t\u00E9rminos de uso de pol\u00EDtica y privacidad de la plataforma");
		rdbtnAceptoLosTrminos.setBackground(Color.LIGHT_GRAY);
		rdbtnAceptoLosTrminos.setBounds(43, 375, 420, 53);
		contentPane.add(rdbtnAceptoLosTrminos);
		
		JButton btnNewButton = new JButton("Registrar");
		btnNewButton.setBounds(287, 161, 105, 80);
		contentPane.add(btnNewButton);
	}
}
