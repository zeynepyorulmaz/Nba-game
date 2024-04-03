import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import exception.AgeException;
import exception.EmailException;
import exception.NameException;
import exception.PasswordException;
import exception.SurnameException;
import exception.UsernameException;
import java.awt.SystemColor;
/*
 * * Users can change their info within this class */
public class Settings extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	protected static final String PROFILE_PHOTOS_DIRECTORY = "profile_photos/";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args, User user) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Settings frame = new Settings(user);
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
	public Settings(User user) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);



		

		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 230, 246));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setBounds(100, 100, 600, 600);
		setContentPane(contentPane);
	    try {
	        String profilePhotoPath = PROFILE_PHOTOS_DIRECTORY + user.getUsername() + ".png";
	        ImageIcon imageIcon = new ImageIcon(profilePhotoPath);
	        Image newImage = imageIcon.getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH);
	        ImageIcon profilePhoto = new ImageIcon(newImage);
	        JLabel profilePhotoLabel = new JLabel(profilePhoto);
	        profilePhotoLabel.setBounds(312, 11, 100, 100);
	        profilePhotoLabel.setBackground(new Color(240, 240, 240));
	        profilePhotoLabel.setForeground(new Color(255, 128, 128));
	        contentPane.add(profilePhotoLabel);
	    } catch (Exception ex) {
	        ex.printStackTrace();
	    }



		JButton pictureSelectionButton = new JButton("Change Profile Photo");
		pictureSelectionButton.setBounds(109, 22, 144, 34);
		contentPane.add(pictureSelectionButton);

		
		
		pictureSelectionButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                int result = fileChooser.showOpenDialog(Settings.this);
                if (result == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser.getSelectedFile();
                    String profilePicturePath = selectedFile.getAbsolutePath();

                    // Create the profile_photos directory if it doesn't exist
                    File profilePhotosDir = new File(PROFILE_PHOTOS_DIRECTORY);
                    if (!profilePhotosDir.exists()) {
                        profilePhotosDir.mkdir();
                    }

                    // Copy the selected file to the profile_photos directory
                    try {
                        File destination = new File(PROFILE_PHOTOS_DIRECTORY + user.getUsername()+ ".png" ); //username
                        Files.copy(selectedFile.toPath(), destination.toPath(), StandardCopyOption.REPLACE_EXISTING);
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }

                    // Update the image label with the selected image
                    ImageIcon imageIcon = new ImageIcon(profilePicturePath);
                    Image newImage = imageIcon.getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH);
                    ImageIcon selectedImage = new ImageIcon(newImage);

                    // Check if the label already exists, if not, create a new one
                    JLabel label = (JLabel) contentPane.getComponent(0); // Assuming it's the first component
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
		
		JLabel nameLabel = new JLabel(user.getName()+" (You can't change your name)");
		nameLabel.setBounds(265, 160, 296, 16);
		nameLabel.setForeground(new Color(100, 93, 99));
		contentPane.add(nameLabel);
		
		JTextArea textArea_1 = new JTextArea(user.getSurname());
		textArea_1.setBounds(266, 188, 151, 16);
		contentPane.add(textArea_1);
		
		JTextArea textArea_2 = new JTextArea(user.getAge());
		textArea_2.setBounds(266, 216, 151, 16);
		contentPane.add(textArea_2);
		
		JTextArea textArea_3 = new JTextArea(user.getEmail());
		textArea_3.setBounds(266, 244, 151, 16);
		contentPane.add(textArea_3);
		
		JTextArea textArea_5 = new JTextArea(user.getPassword());
		textArea_5.setBounds(266, 300, 151, 16);
		contentPane.add(textArea_5);
		
		JButton btnSgnup = new JButton("SAVE CHANGES");
		btnSgnup.setBounds(266, 328, 151, 29);
		btnSgnup.setForeground(new Color(236, 32, 147));
		btnSgnup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String surname1 = textArea_1.getText();
				String age1 = textArea_2.getText();
				String email1 = textArea_3.getText();
				String password1 = textArea_5.getText();
				
				
				try {
					setEverything(user, surname1, age1, email1, password1);
					GameHome gamehome = new GameHome(user);
					System.out.println("done!!");
				}
				
				
				
				catch (AgeException| EmailException | PasswordException| SurnameException mesg){
					
					
					JLabel lblNewLabel_8 = new JLabel(mesg.getMessage());
					lblNewLabel_8.setBounds(150, 360, 1000, 16);
					lblNewLabel_8.setForeground(new Color(128, 0, 0));
					
		            contentPane.add(lblNewLabel_8);
		            contentPane.revalidate();  // Refresh the content pane
		            contentPane.repaint();     // Repaint the content pane

				}
				
				
			}
		});

		

		contentPane.setLayout(null);
		contentPane.add(btnSgnup);
		
		JLabel lblNewLabel_7 = new JLabel(user.getUsername() +" (You can't change your username)");
		lblNewLabel_7.setForeground(SystemColor.inactiveCaptionBorder);
		lblNewLabel_7.setBounds(266, 272, 311, 16);
		contentPane.add(lblNewLabel_7);
		
		JButton btnNewButton = new JButton("BACK");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GameHome gamehome = new GameHome(user);
				gamehome.setVisible(true);
			}
		});
		btnNewButton.setBounds(429, 49, 117, 29);
		contentPane.add(btnNewButton);
		

	}
	
	private boolean isPasswordValid(String password) {
		if (password.length()>7 && password.matches(".*[a-zA-Z]+.*")&& password.matches(".*\\d+.*") && password.matches(".*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>/?]+.*") ) {
			return true;
		}
		else {
			return false;
		}

	}
	
	private boolean isNameValid(String name) {
		if (name.length()>2 && isAllLetters(name)) {
			return true;
		}
		else {
			return false;
		}

	}
    private static boolean isAllLetters(String str) {
        for (char c : str.toCharArray()) {
            if (!Character.isLetter(c)) {
                return false;
            }
        }
        return true;
    }
	
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


	
	private boolean isUsernameValid(String username) {
		Matcher matcher = pattern1.matcher(username);
        return matcher.matches();
	
	}
	
	private boolean isAgeValid(String age) {
		if (Integer.parseInt(age)>11) {
			return true;
		}
		else {
			return false;
		}

	}
    private static final String EMAIL_PATTERN =
            "^\\b[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Z|a-z]{2,}\\b";

    private static final Pattern pattern = Pattern.compile(EMAIL_PATTERN);

    public static boolean isValidEmail(String email) {
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
    
	/*
	 * private HashMap<String, String> readUsersFromFile() { HashMap<String, String>
	 * userMap = new HashMap<>();
	 * 
	 * try { File file = new File("users.txt"); FileReader fileReader = new
	 * FileReader(file); BufferedReader bufferedReader = new
	 * BufferedReader(fileReader);
	 * 
	 * String line; while ((line = bufferedReader.readLine()) != null) { // Split
	 * the line into individual components String[] userInfo = line.split(", ");
	 * 
	 * // Ensure the array has the expected number of components if (userInfo.length
	 * == 6) { String username = userInfo[4]; String password = userInfo[5];
	 * 
	 * // Add the username and password to the HashMap userMap.put(username,
	 * password); } }
	 * 
	 * bufferedReader.close(); } catch (IOException e) { e.printStackTrace(); }
	 * 
	 * return userMap; }
	 */
    // Modify your existing signUp method to use this HashMap if needed
/*
    private void signUp(String name, String surname, String age, String email, String username, String password)
            throws AgeException, EmailException, NameException, PasswordException, SurnameException, UsernameException {

        // ... (your existing validation code)

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
            HashMap<String, String> userMap = readUsersFromFile();
            Login login = new Login();

        } catch (IOException e) {
            e.printStackTrace();
        }


    }*/
 // Add a method in the User class to get user information as a formatted string
    public String getUserInfoString(User user) {
        return String.format("%s, %s, %s, %s, %s, %s",
                user.getName(), user.getSurname(), user.getAge(), user.getEmail(), user.getUsername(), user.getPassword());
    }

    private void setEverything(User user, String surname, String age, String email, String password)
            throws AgeException, EmailException, PasswordException, SurnameException {

        if (!isSurnameValid(surname)) {
            throw new SurnameException("Surname must be all letters and at least 3 letters long");
        }

        if (!isAgeValid(age)) {
            throw new AgeException("You must be at least 12 years old to register.");
        }

        if (!isValidEmail(email)) {
            throw new EmailException("Please type a valid e-mail.");
        }

        if (!isPasswordValid(password)) {
            throw new PasswordException("Password must at least 8 characters and contain at least one letter, number, and a special character");
        }

        // Update the User object with the new information
        user.setSurname(surname);
        user.setAge(age);
        user.setEmail(email);
        user.setPassword(password);

        try {
            // Specify the username of the user whose information you want to update
            String targetUsername = user.getUsername();

            // Read existing content from the file
            File file = new File("users.txt");
            BufferedReader reader = new BufferedReader(new FileReader(file));
            StringBuilder content = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                // Split the line into individual fields
                String[] fields = line.split(", ");

                // Check if the current line corresponds to the target user
                if (fields.length > 4 && fields[4].equals(targetUsername)) {
                    // Update the information for the target user
                    fields[1] = user.getSurname();
                    fields[2] = String.valueOf(user.getAge());
                    fields[3] = user.getEmail();
                    fields[5] = user.getPassword();
                }

                // Reconstruct the line with updated information
                content.append(String.join(", ", fields)).append("\n");
            }

            reader.close();

            // Write the updated content back to the file
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            writer.write(content.toString());
            writer.close();

            System.out.println("User information updated successfully.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
