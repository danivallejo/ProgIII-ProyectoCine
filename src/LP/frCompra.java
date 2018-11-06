package LP;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JList;
import javax.swing.JButton;
import javax.swing.JScrollBar;
import javax.swing.JSpinner;

public class frCompra extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frCompra frame = new frCompra();
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
	public frCompra() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 503, 553);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Compra entradas");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblNewLabel.setBounds(12, 13, 442, 40);
		contentPane.add(lblNewLabel);
		
		JList list = new JList();
		list.setBounds(22, 96, 442, 140);
		contentPane.add(list);
		
		JLabel lblPelculas = new JLabel("Pel\u00EDculas");
		lblPelculas.setBounds(22, 67, 56, 16);
		contentPane.add(lblPelculas);
		
		JButton btnNewButton = new JButton("COMPRAR");
		btnNewButton.setBounds(150, 413, 179, 58);
		contentPane.add(btnNewButton);
		
		JSpinner spinner = new JSpinner();
		spinner.setBounds(262, 277, 67, 40);
		contentPane.add(spinner);
		
		JLabel lblCantidadTickets = new JLabel("CANTIDAD TICKETS");
		lblCantidadTickets.setBounds(105, 283, 145, 28);
		contentPane.add(lblCantidadTickets);
	}
}
