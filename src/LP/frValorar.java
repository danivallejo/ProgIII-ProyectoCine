package LP;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;

public class frValorar extends JFrame {

	private JPanel contentPane;
	
	private javax.swing.JLabel lblNewLabel;
	private javax.swing.JComboBox puntuacion;
	
	private javax.swing.JList list;
	private javax.swing.JButton btnNewButton;
	
	private int calificacion;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frValorar frame = new frValorar();
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
	public frValorar() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 503, 553);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Valoraci\u00F3n pel\u00EDculas");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblNewLabel.setBounds(12, 13, 461, 53);
		contentPane.add(lblNewLabel);
		
		list = new JList();
		list.setBounds(22, 71, 441, 220);
		contentPane.add(list);
		
		puntuacion = new JComboBox();
		puntuacion.setModel(new DefaultComboBoxModel(new String[] {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"}));
		puntuacion.setMaximumRowCount(11);
		puntuacion.setBounds(39, 333, 167, 31);
		contentPane.add(puntuacion);
		
		JLabel lblPuntuacin = new JLabel("Puntuaci\u00F3n");
		lblPuntuacin.setBounds(40, 304, 96, 16);
		contentPane.add(lblPuntuacin);
		
		JButton btnNewButton = new JButton("Puntuar");
		btnNewButton.setBounds(278, 333, 167, 53);
		contentPane.add(btnNewButton);
	}
	
	public void btnPuntuar() 
	
	{
		 calificacion= puntuacion.getSelectedIndex();
		 
		
		
	}
}
