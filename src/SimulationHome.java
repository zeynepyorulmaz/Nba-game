import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
/*
 * * creates gui before the simulation starts  */
public class SimulationHome extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SimulationHome frame = new SimulationHome();
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
	public SimulationHome() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 600);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.textHighlight);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("VIEW TEAM");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewTeam view = new ViewTeam();
				view.setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Lucida Grande", Font.PLAIN, 23));
		btnNewButton.setBounds(184, 151, 228, 90);
		contentPane.add(btnNewButton);
		
		JButton btnStartSmulaton = new JButton("START SIMULATION");
		btnStartSmulaton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TournamentSimulationGUI gui = new TournamentSimulationGUI();
				gui.setVisible(true);
			}
		});
		btnStartSmulaton.setFont(new Font("Lucida Grande", Font.PLAIN, 21));
		btnStartSmulaton.setBounds(184, 283, 228, 90);
		contentPane.add(btnStartSmulaton);
		
		JLabel lblNewLabel = new JLabel("ARE YOU READY?");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		lblNewLabel.setBounds(230, 29, 195, 90);
		contentPane.add(lblNewLabel);
	}
}
