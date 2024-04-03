

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JButton;
/*
 * * Shows tree for the tournament  */
public class Tree extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private List<JLabel> jlblArr;
	private List<JLabel> jlblArr2;
	private List<JLabel> jlblArr3;
	JLabel championLabel;

	public JLabel getChampionLabel() {
		return championLabel;
	}

	public void setChampionLabel(JLabel championLabel) {
		this.championLabel = championLabel;
	}

	public List<JLabel> getJlblArr2() {
		return jlblArr2;
	}

	public void setJlblArr2(List<JLabel> jlblArr2) {
		this.jlblArr2 = jlblArr2;
	}

	public List<JLabel> getJlblArr3() {
		return jlblArr3;
	}

	public void setJlblArr3(List<JLabel> jlblArr3) {
		this.jlblArr3 = jlblArr3;
	}

	public List<JLabel> getJlblArr() {
		return jlblArr;
	}

	public void setJlblArr(List<JLabel> jlblArr) {
		this.jlblArr = jlblArr;
		getContentPane().revalidate();
		getContentPane().repaint();
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tree frame = new Tree();
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
	public Tree() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 600);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.textHighlight);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		jlblArr = new ArrayList<JLabel>();
		jlblArr2 = new ArrayList<JLabel>();
		jlblArr3 = new ArrayList<JLabel>();
		
		JLabel lblNewLabel = new JLabel("New label");
		
		
		
		lblNewLabel.setBounds(24, 66, 61, 16);
		contentPane.add(lblNewLabel);
		jlblArr.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(24, 117, 61, 16);
		contentPane.add(lblNewLabel_1);
		jlblArr.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setBounds(24, 187, 61, 16);
		contentPane.add(lblNewLabel_2);
		jlblArr.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setBounds(24, 236, 61, 16);
		contentPane.add(lblNewLabel_3);
		jlblArr.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("New label");
		lblNewLabel_4.setBounds(24, 314, 61, 16);
		contentPane.add(lblNewLabel_4);
		jlblArr.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("New label");
		lblNewLabel_5.setBounds(24, 354, 61, 16);
		contentPane.add(lblNewLabel_5);
		jlblArr.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("New label");
		lblNewLabel_6.setBounds(24, 425, 61, 16);
		contentPane.add(lblNewLabel_6);
		jlblArr.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("New label");
		lblNewLabel_7.setBounds(24, 470, 61, 16);
		contentPane.add(lblNewLabel_7);
		jlblArr.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("New label");
		lblNewLabel_8.setBounds(177, 135, 61, 16);
		contentPane.add(lblNewLabel_8);
		jlblArr2.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("New label");
		lblNewLabel_9.setBounds(177, 163, 61, 16);
		contentPane.add(lblNewLabel_9);
		jlblArr2.add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("New label");
		lblNewLabel_10.setBounds(177, 376, 61, 16);
		contentPane.add(lblNewLabel_10);
		jlblArr2.add(lblNewLabel_10);
		
		JLabel lblNewLabel_11 = new JLabel("New label");
		lblNewLabel_11.setBounds(177, 404, 61, 16);
		contentPane.add(lblNewLabel_11);
		jlblArr2.add(lblNewLabel_11);
		
		JLabel lblNewLabel_12 = new JLabel("New label");
		lblNewLabel_12.setBounds(327, 236, 61, 16);
		contentPane.add(lblNewLabel_12);
		jlblArr3.add(lblNewLabel_12);
		
		JLabel lblNewLabel_13 = new JLabel("New label");
		lblNewLabel_13.setBounds(327, 314, 61, 16);
		contentPane.add(lblNewLabel_13);
		jlblArr3.add(lblNewLabel_13);
		
		championLabel = new JLabel("New label");
		championLabel.setBounds(474, 274, 61, 16);
		contentPane.add(championLabel);
		
		JButton btnNewButton = new JButton("Show Champion!");
		btnNewButton.setBounds(418, 465, 149, 29);
		contentPane.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ShowWinner showWinner = new ShowWinner();
				showWinner.setVisible(true);
			}
		});
	}
}
