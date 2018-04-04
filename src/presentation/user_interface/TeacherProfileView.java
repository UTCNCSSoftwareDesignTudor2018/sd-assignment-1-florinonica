package presentation.user_interface;

import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import data_access.models.Teacher;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class TeacherProfileView extends JFrame{
	private JPanel content;
	JButton SaveButton = new JButton("Save");
	private JTextField firstNameTextField;
	private JTextField lastNameTextField;
	private JTextField emailTextField;
	private JTextField CNPTextField;
	private JLabel lblNewLabel;
	private JTextField teacherIDTextField;
	private JLabel lblTeacherId;
	private JLabel lblCnp;
	private JTextField IDCardNumberTextField;
	private JTextField addressTextField;
	private JLabel lblIdcardNumber;
	private JLabel lblAddress;
	private JTextField passwordTextField;
	private JTextField usernameTextField;

	public TeacherProfileView(Teacher s) {
		this.setTitle("Teacher Profile");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setSize(600, 850);
		content = new JPanel();
		this.setContentPane(content);
		content.setLayout(null);

		SaveButton.setFont(new Font("Calibri", Font.PLAIN, 16));
		SaveButton.setBounds(215, 700, 170, 55);
		content.add(SaveButton);

		firstNameTextField = new JTextField();
		firstNameTextField.setBounds(230, 100, 300, 20);
		content.add(firstNameTextField);
		firstNameTextField.setColumns(10);
		firstNameTextField.setText(s.getFirstName());
		firstNameTextField.setEditable(true);

		JLabel lblFirstName = new JLabel("First Name:");
		lblFirstName.setBounds(100, 100, 100, 20);
		content.add(lblFirstName);

		lastNameTextField = new JTextField();
		lastNameTextField.setBounds(230, 150, 300, 20);
		content.add(lastNameTextField);
		lastNameTextField.setColumns(10);
		lastNameTextField.setText(s.getLastName());
		lastNameTextField.setEditable(true);

		emailTextField = new JTextField();
		emailTextField.setBounds(230, 200, 300, 20);
		content.add(emailTextField);
		emailTextField.setColumns(10);
		emailTextField.setText(s.getEmail());
		emailTextField.setEditable(true);

		CNPTextField = new JTextField();
		CNPTextField.setBounds(230, 250, 300, 20);
		content.add(CNPTextField);
		CNPTextField.setColumns(10);
		CNPTextField.setText(s.getCNP());
		CNPTextField.setEditable(false);

		JLabel lblLastName = new JLabel("Last Name:");
		lblLastName.setBounds(100, 150, 100, 20);
		content.add(lblLastName);

		lblNewLabel = new JLabel("Email:");
		lblNewLabel.setBounds(100, 200, 100, 20);
		content.add(lblNewLabel);

		teacherIDTextField = new JTextField();
		teacherIDTextField.setBounds(230, 50, 300, 20);
		content.add(teacherIDTextField);
		teacherIDTextField.setColumns(10);
		teacherIDTextField.setText(s.getTeacherID());
		teacherIDTextField.setEditable(false);

		lblTeacherId = new JLabel("Teacher ID:");
		lblTeacherId.setBounds(100, 50, 100, 20);
		content.add(lblTeacherId);

		lblCnp = new JLabel("CNP:");
		lblCnp.setBounds(100, 250, 100, 20);
		content.add(lblCnp);

		IDCardNumberTextField = new JTextField();
		IDCardNumberTextField.setBounds(230, 300, 300, 20);
		content.add(IDCardNumberTextField);
		IDCardNumberTextField.setColumns(10);
		IDCardNumberTextField.setText(s.getIdentityCardNumber());
		IDCardNumberTextField.setEditable(false);

		addressTextField = new JTextField();
		addressTextField.setBounds(230, 350, 300, 150);
		content.add(addressTextField);
		addressTextField.setColumns(10);
		addressTextField.setText(s.getAddress());
		addressTextField.setEditable(true);

		lblIdcardNumber = new JLabel("IDCard Number:");
		lblIdcardNumber.setBounds(100, 300, 100, 14);
		content.add(lblIdcardNumber);

		lblAddress = new JLabel("Address:");
		lblAddress.setBounds(100, 350, 100, 14);
		content.add(lblAddress);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(100, 550, 100, 20);
		content.add(lblUsername);
		
		passwordTextField = new JTextField();
		passwordTextField.setBounds(230, 600, 300, 20);
		passwordTextField.setText(s.getPassword());
		content.add(passwordTextField);
		passwordTextField.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(100, 600, 100, 20);
		content.add(lblPassword);
		
		usernameTextField = new JTextField();
		usernameTextField.setBounds(230, 550, 300, 20);
		usernameTextField.setText(s.getUsername());
		content.add(usernameTextField);
		usernameTextField.setColumns(10);

	}

	public void addSaveListener(ActionListener al) {
		SaveButton.addActionListener(al);
	}
	
	public String getTeacherID() {
		return teacherIDTextField.getText();
	}

	public String getEmail() {
		return emailTextField.getText();
	}

	public String getAddress() {
		return addressTextField.getText();
	}
	
	public String getUsername() {
		return usernameTextField.getText();
	}

	public String getPassword() {
		return passwordTextField.getText();
	}

}
