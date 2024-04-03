import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
/*
 * * gui class before the drafting process  */
public class GameHome extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application. 
	 */
	public static void main(String[] args, User user) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GameHome frame = new GameHome(user);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * 
	 * Create the frame for before drafting.
	 */
	public GameHome(User user) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 600);
		contentPane = new JPanel();
		contentPane.setForeground(SystemColor.controlHighlight);
		contentPane.setBackground(new Color(255, 235, 244));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Play Basketball!");
		lblNewLabel.setForeground(SystemColor.controlHighlight);
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 29));
		lblNewLabel.setBounds(200, 6, 233, 127);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Settings");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Settings settings = new Settings(user);
				settings.setVisible(true);
			}
		});
		btnNewButton.setBounds(457, 17, 117, 29);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("New Game");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Drafting draft = new Drafting();
				draft.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(250, 218, 117, 29);
		contentPane.add(btnNewButton_1);
	}
}
