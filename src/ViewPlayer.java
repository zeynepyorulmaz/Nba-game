import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import positions.Player;

import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
/*
 * * You can view a player's details  */
public class ViewPlayer extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args, Player player) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewPlayer frame = new ViewPlayer(player);
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
	public ViewPlayer(Player player) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 600);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.textHighlight);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("<html>Name: " + player.getName() + "<br>Position: " + player.getPosition() + "<br>PTS: " + player.getPts() + "<br>TRB: " + player.getTrb() + "<br>AST: " + player.getAst() + "<br>BLK: " + player.getBlk() + "<br>STL: " + player.getStl() + "</html>");

		lblNewLabel.setBounds(145, 122, 295, 324);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("BACK");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewTeam team = new ViewTeam();
				team.setVisible(true);
			}
		});
		btnNewButton.setBounds(457, 36, 117, 29);
		contentPane.add(btnNewButton);
	}

}
