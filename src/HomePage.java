import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.SystemColor;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
/*
 * * Generates a gui page for the start of the application  */
public class HomePage extends JFrame {

	private static final long serialVersionUID = 1L;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomePage frame = new HomePage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	/**
	 * Create the main home frame.
	 */
	public HomePage() {
		
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 600);
		JPanel contentPane = new JPanel();

		contentPane.setBackground(new Color(255, 229, 245));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Welcome!");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(239, 157, 111, 30);
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("REGISTER!");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Register register = new Register();
				register.setVisible(true);
			}
		});

		btnNewButton.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		btnNewButton.setBounds(222, 217, 153, 44);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("Already have an account?");
		lblNewLabel_1.setForeground(SystemColor.controlHighlight);
		lblNewLabel_1.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		lblNewLabel_1.setBounds(230, 290, 164, 16);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton_1 = new JButton("SIGN IN");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login login = new Login();
				login.setVisible(true);
			}
		});
		btnNewButton_1.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		btnNewButton_1.setBounds(222, 304, 153, 44);
		contentPane.add(btnNewButton_1);
	}
}
