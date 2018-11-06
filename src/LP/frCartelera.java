package LP;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import java.awt.Font;
import javax.swing.SwingConstants;

public class frCartelera extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frCartelera frame = new frCartelera();
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
	public frCartelera() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 503, 553);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JList list = new JList();
		list.setBounds(12, 62, 461, 172);
		contentPane.add(list);
		
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
		lblVotacin.setBounds(283, 309, 56, 16);
		contentPane.add(lblVotacin);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(12, 403, 461, 90);
		contentPane.add(textPane);
		
		JTextPane textPane_1 = new JTextPane();
		textPane_1.setBounds(12, 276, 191, 27);
		contentPane.add(textPane_1);
		
		JTextPane textPane_2 = new JTextPane();
		textPane_2.setBounds(12, 338, 191, 27);
		contentPane.add(textPane_2);
		
		JLabel lblNewLabel = new JLabel("Cartelera");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblNewLabel.setBounds(12, 13, 461, 37);
		contentPane.add(lblNewLabel);
		
		JLabel lblDirector = new JLabel("Director");
		lblDirector.setBounds(283, 247, 56, 16);
		contentPane.add(lblDirector);
		
		JTextPane textPane_3 = new JTextPane();
		textPane_3.setBounds(283, 276, 190, 27);
		contentPane.add(textPane_3);
	}
}
