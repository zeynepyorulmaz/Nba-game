import java.awt.EventQueue;

import positions.Player;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
/*
 * * You can view a team's details  */
public class ViewTeam extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	ArrayList<List<Player>> teams = Drafting.getTeams();
	int queue = Drafting.getUserqueue();
	List userTeam = teams.get(queue);
	Player p1 = (Player) (userTeam.get(0));
	Player p2 = (Player) (userTeam.get(1));
	Player p3 = (Player) (userTeam.get(2));
	Player p4 = (Player) (userTeam.get(3));
	Player p5 = (Player) (userTeam.get(4));

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewTeam frame = new ViewTeam();
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
	public ViewTeam() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 600);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.textHighlight);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("YOUR TEAM");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		lblNewLabel.setBounds(216, 80, 200, 72);
		contentPane.add(lblNewLabel);
		
		
		JButton btnNewButton = new JButton(p1.toString());
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewPlayer view = new ViewPlayer(p1);
				view.setVisible(true);
			}
		});
		btnNewButton.setBounds(184, 182, 229, 29);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton(p2.toString());
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewPlayer view = new ViewPlayer(p2);
				view.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(184, 241, 229, 29);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton(p3.toString());
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewPlayer view = new ViewPlayer(p3);
				view.setVisible(true);
			}
		});
		btnNewButton_2.setBounds(184, 301, 229, 29);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton(p4.toString());
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewPlayer view = new ViewPlayer(p4);
				view.setVisible(true);
			}
		});
		btnNewButton_3.setBounds(184, 360, 229, 29);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton(p5.toString());
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewPlayer view = new ViewPlayer(p5);
				view.setVisible(true);
			}
		});
		btnNewButton_4.setBounds(184, 421, 229, 29);
		contentPane.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("BACK");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SimulationHome home = new SimulationHome();
				home.setVisible(true);
			}
		});
		btnNewButton_5.setBounds(461, 34, 117, 29);
		contentPane.add(btnNewButton_5);
	}

}
