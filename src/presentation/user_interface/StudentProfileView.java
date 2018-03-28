package presentation.user_interface;

import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import data_access.models.Student;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class StudentProfileView extends JFrame {
	private JPanel content;
	JButton SaveButton = new JButton("Save");
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

	public StudentProfileView(Student s) {
		this.setTitle("Student Profile");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(600, 750);
		content = new JPanel();
		this.setContentPane(content);
		content.setLayout(null);

		SaveButton.setFont(new Font("Calibri", Font.PLAIN, 16));
		SaveButton.setBounds(215, 600, 170, 55);
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

		studentIDTextField = new JTextField();
		studentIDTextField.setBounds(230, 50, 300, 20);
		content.add(studentIDTextField);
		studentIDTextField.setColumns(10);
		studentIDTextField.setText(s.getStudentID());
		studentIDTextField.setEditable(false);

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
		IDCardNumberTextField.setText(s.getidentityCardNumber());
		IDCardNumberTextField.setEditable(false);

		groupTextField = new JTextField();
		groupTextField.setBounds(230, 350, 300, 20);
		content.add(groupTextField);
		groupTextField.setColumns(10);
		groupTextField.setText(String.valueOf(s.getGroup()));
		groupTextField.setEditable(false);

		addressTextField = new JTextField();
		addressTextField.setBounds(230, 400, 300, 150);
		content.add(addressTextField);
		addressTextField.setColumns(10);
		addressTextField.setText(s.getAddress());
		addressTextField.setEditable(true);

		lblIdcardNumber = new JLabel("IDCard Number:");
		lblIdcardNumber.setBounds(100, 300, 100, 14);
		content.add(lblIdcardNumber);

		lblGroup = new JLabel("Group:");
		lblGroup.setBounds(100, 350, 100, 14);
		content.add(lblGroup);

		lblAddress = new JLabel("Address:");
		lblAddress.setBounds(100, 400, 100, 14);
		content.add(lblAddress);

	}

	public void addSaveListener(ActionListener al) {
		SaveButton.addActionListener(al);
	}

	public String getFirstName() {
		return firstNameTextField.getText();
	}

	public String getLastName() {
		return lastNameTextField.getText();
	}

	public String getEmail() {
		return emailTextField.getText();
	}

	public String getAddress() {
		return addressTextField.getText();
	}
}
