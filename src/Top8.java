import java.awt.EventQueue;

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
 * * Creates the gui for showing top8  */
public class Top8 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private List<Team> top8 = new ArrayList<>(TournamentSimulationGUI.getPlayoffTeams());

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Top8 frame = new Top8();
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
	public Top8() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 600);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.textHighlight);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("TOP 8 TEAM");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		lblNewLabel.setBounds(250, 87, 170, 22);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel(top8.get(0).getTeamName());
		lblNewLabel_1.setBounds(271, 131, 61, 16);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel(top8.get(1).getTeamName());
		lblNewLabel_2.setBounds(271, 187, 61, 16);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel(top8.get(2).getTeamName());
		lblNewLabel_3.setBounds(271, 240, 61, 16);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel(top8.get(3).getTeamName());
		lblNewLabel_4.setBounds(271, 296, 61, 16);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel(top8.get(4).getTeamName());
		lblNewLabel_5.setBounds(271, 325, 61, 16);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel(top8.get(5).getTeamName());
		lblNewLabel_6.setBounds(271, 212, 61, 16);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel(top8.get(6).getTeamName());
		lblNewLabel_7.setBounds(271, 159, 61, 16);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel(top8.get(7).getTeamName());
		lblNewLabel_8.setBounds(271, 268, 61, 16);
		contentPane.add(lblNewLabel_8);
		
		JButton btnNewButton = new JButton("NEXT");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TournamentSimulationGUI.playPlayoff();
			}
		});
		btnNewButton.setBounds(417, 465, 117, 29);
		contentPane.add(btnNewButton);
	}
}
