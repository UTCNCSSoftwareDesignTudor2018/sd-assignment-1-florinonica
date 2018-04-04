package presentation.user_interface;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import business_logic.blls.StudentBLL;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class AddStudentView extends JFrame {
	private JPanel content;
	JButton saveButton = new JButton("Save");
	private JTextField firstNameTextField;
	private JTextField lastNameTextField;
	private JTextField emailTextField;
	private JTextField CNPTextField;
	private JLabel lblNewLabel;
	private JTextField studentIDTextField;
	private JLabel lblStudentId;
	private JLabel lblCnp;
	private JTextField IDCardNumberTextField;
	private JTextField groupTextField;
	private JTextField addressTextField;
	private JLabel lblIdcardNumber;
	private JLabel lblGroup;
	private JLabel lblAddress;
	private JTextField passwordTextField;
	private JTextField usernameTextField;
	private StudentBLL sbll;

	public AddStudentView() {
		this.setTitle("Student Profile");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setSize(600, 900);
		content = new JPanel();
		this.setContentPane(content);
		content.setLayout(null);
		sbll = new StudentBLL();
		saveButton.setFont(new Font("Calibri", Font.PLAIN, 16));
		saveButton.setBounds(215, 750, 170, 55);
		content.add(saveButton);

		firstNameTextField = new JTextField();
		firstNameTextField.setBounds(230, 100, 300, 20);
		content.add(firstNameTextField);
		firstNameTextField.setColumns(10);
		firstNameTextField.setEditable(true);

		JLabel lblFirstName = new JLabel("First Name:");
		lblFirstName.setBounds(100, 100, 100, 20);
		content.add(lblFirstName);

		lastNameTextField = new JTextField();
		lastNameTextField.setBounds(230, 150, 300, 20);
		content.add(lastNameTextField);
		lastNameTextField.setColumns(10);
		lastNameTextField.setEditable(true);

		emailTextField = new JTextField();
		emailTextField.setBounds(230, 200, 300, 20);
		content.add(emailTextField);
		emailTextField.setColumns(10);
		emailTextField.setEditable(true);

		CNPTextField = new JTextField();
		CNPTextField.setBounds(230, 250, 300, 20);
		content.add(CNPTextField);
		CNPTextField.setColumns(10);
		CNPTextField.setEditable(true);

		JLabel lblLastName = new JLabel("Last Name:");
		lblLastName.setBounds(100, 150, 100, 20);
		content.add(lblLastName);

		lblNewLabel = new JLabel("Email:");
		lblNewLabel.setBounds(100, 200, 100, 20);
		content.add(lblNewLabel);

		studentIDTextField = new JTextField();
		studentIDTextField.setBounds(230, 50, 300, 20);
		content.add(studentIDTextField);
		studentIDTextField.setColumns(10);
		studentIDTextField.setEditable(true);

		lblStudentId = new JLabel("Student ID:");
		lblStudentId.setBounds(100, 50, 100, 20);
		content.add(lblStudentId);

		lblCnp = new JLabel("CNP:");
		lblCnp.setBounds(100, 250, 100, 20);
		content.add(lblCnp);

		IDCardNumberTextField = new JTextField();
		IDCardNumberTextField.setBounds(230, 300, 300, 20);
		content.add(IDCardNumberTextField);
		IDCardNumberTextField.setColumns(10);
		IDCardNumberTextField.setEditable(true);

		groupTextField = new JTextField();
		groupTextField.setBounds(230, 350, 300, 20);
		content.add(groupTextField);
		groupTextField.setColumns(10);
		groupTextField.setEditable(true);

		addressTextField = new JTextField();
		addressTextField.setBounds(230, 400, 300, 150);
		content.add(addressTextField);
		addressTextField.setColumns(10);
		addressTextField.setEditable(true);

		lblIdcardNumber = new JLabel("IDCard Number:");
		lblIdcardNumber.setBounds(100, 300, 100, 20);
		content.add(lblIdcardNumber);

		lblGroup = new JLabel("Group:");
		lblGroup.setBounds(100, 350, 100, 20);
		content.add(lblGroup);

		lblAddress = new JLabel("Address:");
		lblAddress.setBounds(100, 400, 100, 20);
		content.add(lblAddress);

		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(100, 600, 100, 20);
		content.add(lblUsername);

		passwordTextField = new JTextField();
		passwordTextField.setBounds(230, 650, 300, 20);
		content.add(passwordTextField);
		passwordTextField.setColumns(10);

		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(100, 650, 100, 20);
		content.add(lblPassword);

		usernameTextField = new JTextField();
		usernameTextField.setBounds(230, 600, 300, 20);
		content.add(usernameTextField);
		usernameTextField.setColumns(10);

		saveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sbll.insertStudent(studentIDTextField.getText(), usernameTextField.getText(),
						passwordTextField.getText(), firstNameTextField.getText(), lastNameTextField.getText(),
						CNPTextField.getText(), IDCardNumberTextField.getText(), emailTextField.getText(),
						addressTextField.getText(), Integer.valueOf(groupTextField.getText()));
			}
		});
	}

}
