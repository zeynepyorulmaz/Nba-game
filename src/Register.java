import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import exception.AgeException;
import exception.EmailException;
import exception.NameException;
import exception.PasswordException;
import exception.SurnameException;
import exception.UsernameException;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import java.awt.Font;
import java.awt.Image;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
/*
 * * Users register within this class  */
public class Register extends JFrame {

	private static final long serialVersionUID = 1L;
	protected static final String PROFILE_PHOTOS_DIRECTORY = "profile_photos/";
	private JPanel contentPane;
	private static ArrayList<User> userList = new ArrayList<>();
	

	public ArrayList<User> getUserList() {
		return userList;
	}

	public static void setUserList(ArrayList<User> userList) {
		Register.userList = userList;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Register frame = new Register();
					frame.setVisible(true);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/**
	 * 
	 * Create the frame.
	 */
	public Register() {
		setTitle("Register Now!");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 230, 246));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		try {
		    ImageIcon imageIcon = new ImageIcon("src/default.png");
		    Image newimage = imageIcon.getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH);
		    ImageIcon image = new ImageIcon(newimage);
		    JLabel label = new JLabel(image);
		    label.setBounds(150, 83, 71, 71);
		    contentPane.add(label);

		} catch (Exception ex) {
		    ex.printStackTrace();
		}

		

		
		//Labels for getting which input gets which input
		
		JLabel lblNewLabel = new JLabel("Name: ");
		lblNewLabel.setBounds(150, 160, 103, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Surname:");
		lblNewLabel_1.setBounds(150, 188, 61, 16);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Age:");
		lblNewLabel_2.setBounds(150, 216, 61, 16);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("E-mail:");
		lblNewLabel_3.setBounds(150, 244, 61, 16);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Username:");
		lblNewLabel_4.setBounds(150, 272, 77, 16);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Password:");
		lblNewLabel_5.setBounds(150, 300, 91, 16);
		contentPane.add(lblNewLabel_5);
		
		JTextArea txtrTypeName = new JTextArea();
		txtrTypeName.setBounds(266, 160, 151, 16);
		txtrTypeName.setForeground(new Color(100, 93, 99));
		contentPane.add(txtrTypeName);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setBounds(266, 188, 151, 16);
		contentPane.add(textArea_1);
		
		JTextArea textArea_2 = new JTextArea();
		textArea_2.setBounds(266, 216, 151, 16);
		contentPane.add(textArea_2);
		
		JTextArea textArea_3 = new JTextArea();
		textArea_3.setBounds(266, 244, 151, 16);
		contentPane.add(textArea_3);
		
		JTextArea textArea_4 = new JTextArea();
		textArea_4.setBounds(266, 272, 151, 16);
		contentPane.add(textArea_4);
		
		JTextArea textArea_5 = new JTextArea();
		textArea_5.setBounds(266, 300, 151, 16);
		contentPane.add(textArea_5);
        JLabel lblNewLabel_8 = new JLabel("");
        lblNewLabel_8.setBounds(150, 360, 1000, 16);
        lblNewLabel_8.setForeground(new Color(128, 0, 0));
        contentPane.add(lblNewLabel_8);
		
		

		
		JButton btnSgnup = new JButton("SIGN-UP!");
		btnSgnup.setBounds(266, 328, 117, 29);
		btnSgnup.setForeground(new Color(236, 32, 147));
		btnSgnup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String name = txtrTypeName.getText();
				String surname = textArea_1.getText();
				String age = textArea_2.getText();
				String email = textArea_3.getText();
				String username = textArea_4.getText();
				String password = textArea_5.getText();

				
				
		        try {
		            signUp(name, surname, age, email, username, password);
		            JLabel success = new JLabel();
		            success.setText("Successfully registered.");
		            User user = new User(name, surname, age, email, username, password);
		            userList.add(user);
		            GameHome game = new GameHome(user);
		            game.setVisible(true);
		            dispose();
		            

		        } catch (AgeException | EmailException | NameException | PasswordException | SurnameException
		                | UsernameException mesg) {
		        	lblNewLabel_8.setText("");
		            lblNewLabel_8.setText(mesg.getMessage());
			        contentPane.add(lblNewLabel_8);
		        }


		        SwingUtilities.invokeLater(new Runnable() {
		            public void run() {
		                contentPane.revalidate();
		                contentPane.repaint();
		            }
		        });
		    }
		});

		contentPane.setLayout(null);
		contentPane.add(btnSgnup);
		
		JLabel lblNewLabel_6 = new JLabel("Already have an account?");
		lblNewLabel_6.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		lblNewLabel_6.setForeground(SystemColor.controlHighlight);
		lblNewLabel_6.setBounds(266, 422, 221, 16);
		contentPane.add(lblNewLabel_6);
		
		JButton btnNewButton = new JButton("LOG-IN");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login login = new Login();
				login.setVisible(true);
			}
		});
		btnNewButton.setBounds(266, 454, 117, 29);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_7 = new JLabel("REGISTER!!!");
		lblNewLabel_7.setFont(new Font("Lucida Grande", Font.PLAIN, 23));
		lblNewLabel_7.setBounds(251, 68, 144, 34);
		
		contentPane.add(lblNewLabel_7);
		
		JButton pictureSelectionButton = new JButton("Change Profile Photo");
		pictureSelectionButton.setBounds(109, 22, 144, 34);
		contentPane.add(pictureSelectionButton);
		
		JLabel lblNewLabel_9 = new JLabel("Default Photo");
		lblNewLabel_9.setBounds(160, 55, 117, 16);
		contentPane.add(lblNewLabel_9);

		
        pictureSelectionButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                int result = fileChooser.showOpenDialog(Register.this);
                if (result == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser.getSelectedFile();
                    String profilePicturePath = selectedFile.getAbsolutePath();

                    File profilePhotosDir = new File(PROFILE_PHOTOS_DIRECTORY);
                    if (!profilePhotosDir.exists()) {
                        profilePhotosDir.mkdir();
                    }

                    try {
                        File destination = new File(PROFILE_PHOTOS_DIRECTORY + textArea_4.getText()+ ".png" ); //username
                        Files.copy(selectedFile.toPath(), destination.toPath(), StandardCopyOption.REPLACE_EXISTING);
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }

                    ImageIcon imageIcon = new ImageIcon(profilePicturePath);
                    Image newImage = imageIcon.getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH);
                    ImageIcon selectedImage = new ImageIcon(newImage);

                    JLabel label = (JLabel) contentPane.getComponent(0); 
                    if (label == null) {
                        label = new JLabel(selectedImage);
                        label.setBounds(312, 11, 100, 100);
                        label.setBackground(new Color(240, 240, 240));
                        label.setForeground(new Color(255, 128, 128));
                        contentPane.add(label);
                    } else {
                        label.setIcon(selectedImage);
                    }
                }
            }
        });

		

	}
	/** @param password Is a password
	 * Checks if the password is valid */
	
	private boolean isPasswordValid(String password) {
		if (password.length()>7 && password.matches(".*[a-zA-Z]+.*")&& password.matches(".*\\d+.*") && password.matches(".*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>/?]+.*") ) {
			return true;
		}
		else {
			return false;
		}

	}
	
	/** @param name Is a name
	 * Checks if the name is valid */
	
	private boolean isNameValid(String name) {
		if (name.length()>2 && isAllLetters(name)) {
			return true;
		}
		else {
			return false;
		}

	}
	/** @param str Is a string
	 * Checks if the string only contains letters */
    private static boolean isAllLetters(String str) {
        for (char c : str.toCharArray()) {
            if (!Character.isLetter(c)) {
                return false;
            }
        }
        return true;
    }
	/** @param surname Is a surname
	 * Checks if the surname is valid */
	private boolean isSurnameValid(String surname) {
		if (surname.length()>2 && isAllLetters(surname)) {
			return true;
		}
		else {
			return false;
		}

		
	}
	
    private static final String USERNAME_PATTERN = "^[a-zA-Z0-9]+$";

    private static final Pattern pattern1 = Pattern.compile(USERNAME_PATTERN);


	/** @param username Is a username
	 * Checks if the usernamed is valid */
	private boolean isUsernameValid(String username) {
		Matcher matcher = pattern1.matcher(username);
        return matcher.matches();
	
	}
	
	/** @param age Is a age
	 * Checks if the age is valid */
	
	private boolean isAgeValid(String age) {
		if (Integer.parseInt(age)>11) {
			return true;
		}
		else {
			return false;
		}

	}
	/** @param username Is a username
	 * Checks if the username is taken */
    private boolean isUsernameTaken(String username) {
        for (User user : userList) {
            if (user.getUsername().equals(username)) {
                return true;
            }
        }
        return false;

}
    private static final String EMAIL_PATTERN =
            "^\\b[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Z|a-z]{2,}\\b";

    private static final Pattern pattern = Pattern.compile(EMAIL_PATTERN);
	/** @param email Is a email
	 * Checks if the email is valid */
    public static boolean isValidEmail(String email) {
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
    
	/**@param password Is a password
	 * @param email Is a email
	 * @param age Is a age
	 * @param username Is a username
	 * @param surname Is a surname
	 * @param name Is a name
	 * signs up the user */
    private void signUp(String name, String surname, String age, String email, String username, String password) 
        	throws AgeException, EmailException, NameException, PasswordException, SurnameException, UsernameException{
        		
        if (!isNameValid(name)) {
        	throw new NameException("Name must be all letters and at least 3 letters long");
        }
        
        if (!isSurnameValid(surname)) {
        	throw new SurnameException("Surname must be all letters and at least 3 letters long");
        }
        
        if (!isAgeValid(age)) {
        	throw new AgeException("You must be at least 12 years old to register.");
        }
        
        if (!isValidEmail(email)) {
        	throw new EmailException("Please type a valid e-mail.");
        }
        
        if (!isUsernameValid(username)) {
        	throw new UsernameException("Username must only contain letters and numbers.");
        }
        if (!isPasswordValid(password)) {
        	throw new PasswordException("Password must at least 8 characters and contain at least one letter, number and a special character");
        }
        if (isUsernameTaken(username)) {
            throw new UsernameException("Username already exists. Please choose a different username.");
        }

        if (readUsersFromFile().containsKey(username)) {
            throw new UsernameException("Username already exists. Please choose a different username.");
        }

        try {
            // Append the user information to the "users.txt" file
            File file = new File("users.txt");
            FileWriter fileWriter = new FileWriter(file, true); // true to append to the file
            BufferedWriter writer = new BufferedWriter(fileWriter);

            // Format the user information as needed
            String userInfo = String.format("%s, %s, %s, %s, %s, %s%n", name, surname, age, email, username, password);

            // Write the user information to the file
            writer.write(userInfo);
            writer.close();

            JLabel success = new JLabel();
            success.setText("Successfully registered.");
            Login login = new Login();

        } catch (IOException e) {
            e.printStackTrace();
        }
        }
    /** Reads the users from the csv file and adds them to userlist
     * @return userMap hashmap of usernames and passwords*/
    HashMap<String, String> readUsersFromFile() {
        HashMap<String, String> userMap = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader("users.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(", ");
                String username = parts[4];
                String password = parts[5];
                String name = parts[0];
                String surname = parts[1];
                String age = parts[2];
                String email = parts[3];

                User user = new User(name, surname, age, email, username, password);
                userList.add(user);

                userMap.put(username, password);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return userMap;
    }




    /** @param username Is a username
     * @param password Is a password
     *  checks if the login info is true
     * @return boolean of truthness of login info*/
	public boolean checkCredentials(String username, String password) {
        try (BufferedReader br = new BufferedReader(new FileReader("users.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(", ");
                String storedUsername = parts[4];
                String storedPassword = parts[5];

                if (storedUsername.equals(username) && storedPassword.equals(password)) {
                    return true;
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return false;
    }

}