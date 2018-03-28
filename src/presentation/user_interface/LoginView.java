package presentation.user_interface;

import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import java.awt.Font;

@SuppressWarnings("serial")
public class LoginView extends JFrame {
	private JPanel content;
	private JTextField usernameTextField;
	private JTextField passwordTextField;
	JButton loginButton = new JButton("Login");
	JCheckBox teacherCheckBox = new JCheckBox("I'm a teacher");

	public LoginView() {
		this.setTitle("Course Management Login");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(300, 300);
		content = new JPanel();
		this.setContentPane(content);
		content.setLayout(null);

		teacherCheckBox.setBounds(100, 210, 100, 25);
		content.add(teacherCheckBox);

		usernameTextField = new JTextField();
		usernameTextField.setFont(new Font("Calibri", Font.PLAIN, 12));
		usernameTextField.setBounds(100, 70, 100, 20);
		content.add(usernameTextField);
		usernameTextField.setColumns(10);

		passwordTextField = new JTextField();
		passwordTextField.setFont(new Font("Calibri", Font.PLAIN, 12));
		passwordTextField.setBounds(100, 120, 100, 20);
		content.add(passwordTextField);
		passwordTextField.setColumns(10);

		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Calibri", Font.BOLD, 16));
		lblUsername.setBounds(110, 50, 80, 15);
		content.add(lblUsername);

		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Calibri", Font.BOLD, 16));
		lblPassword.setBounds(110, 10, 80, 15);
		content.add(lblPassword);

		loginButton.setFont(new Font("Calibri", Font.BOLD, 16));
		loginButton.setBounds(105, 170, 90, 25);
		content.add(loginButton);
	}


	public void addLoginListener(ActionListener al) {
		loginButton.addActionListener(al);
	}
	
	public String getUserType() {
		if(teacherCheckBox.isSelected()) {
			return "Teacher";
		}
		return "Student";
	}

	public String getUsername() {
		return usernameTextField.getText();
	}

	public String getPassword() {
		return passwordTextField.getText();
	}
}
