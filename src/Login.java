import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JPasswordField;
import javax.swing.JFormattedTextField;
import javax.swing.JTextField;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JButton;
import java.awt.SystemColor;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.awt.event.ActionEvent;

/*
 * * Users login within this class */

public class Login extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPasswordField passwordField;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 229, 245));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("LOG-IN");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(250, 103, 100, 60);
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Username:");
		lblNewLabel_1.setBounds(178, 190, 75, 16);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Password:");
		lblNewLabel_2.setBounds(178, 237, 75, 16);
		contentPane.add(lblNewLabel_2);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(281, 234, 133, 21);
		contentPane.add(passwordField);
		
		textField = new JTextField();
		textField.setBounds(281, 187, 133, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
        JButton btnNewButton = new JButton("SIGN-IN");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = textField.getText();
                String password = new String(passwordField.getPassword());

                // Call the checkCredentials method from the Register class
                Register register = new Register();
                boolean credentialsValid = register.checkCredentials(username, password);

                if (credentialsValid) {
                    System.out.println("Login successful!");
                    // Add code to handle successful login
                    //loginde user' for loop döndür oradan userı çek gamehomea argument olarak ver
                	register.readUsersFromFile();
                    for (int i = 0; i< register.getUserList().size(); i++) {

                    	if (register.getUserList().get(i).getUsername().equals(username)) {
                    		User user = register.getUserList().get(i);
                    		GameHome game = new GameHome(user);
                            game.setVisible(true);
                    	
                    	
                    }

                    // Optionally, close the login window
                    
                    }} else {
                    System.out.println("Invalid username or password.");
                    JLabel invalid = new JLabel("Username not found or wrong password!!!");
                    invalid.setBounds(178, 280, 400, 16);
                    
                    invalid.setForeground(SystemColor.controlHighlight);
                    contentPane.add(invalid);
                    // Add code to handle unsuccessful login
                    contentPane.repaint();
                }
                
            }
        });
		btnNewButton.setForeground(SystemColor.controlHighlight);
		btnNewButton.setBounds(225, 313, 150, 46);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_3 = new JLabel("I don't have an account");
		lblNewLabel_3.setBounds(225, 452, 191, 16);
		contentPane.add(lblNewLabel_3);
		
		JButton btnNewButton_1 = new JButton("BACK TO SIGN-UP");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Register register = new Register();
				register.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(225, 482, 150, 29);
		contentPane.add(btnNewButton_1);
		

	}
}
