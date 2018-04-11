package presentation.views;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import java.awt.Color;

@SuppressWarnings("serial")
public class CourseEnrollmentView extends JFrame {
	private JPanel content;
	JButton enrollButton = new JButton("Enroll");
	JComboBox<String> courseSelector = new JComboBox<String>();
	private JLabel lblEnrollmentFailed = new JLabel("Enrollment failed!");
	private JLabel lblEnrollmentSuccess = new JLabel("Enrollment success!");

	public CourseEnrollmentView(List<String> courses) {
		this.setTitle("CourseEnrollment");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setSize(441, 201);
		content = new JPanel();
		this.setContentPane(content);
		content.setLayout(null);

		enrollButton.setFont(new Font("Calibri", Font.PLAIN, 16));
		enrollButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		enrollButton.setBounds(268, 50, 117, 55);
		content.add(enrollButton);
		DefaultComboBoxModel<String> dcm = new DefaultComboBoxModel<String>();
		for (String c : courses) {
			dcm.addElement(c);
		}
		courseSelector.setModel(dcm);
		courseSelector.setBounds(65, 67, 170, 20);
		content.add(courseSelector);
		courseSelector.setEditable(false);
		JLabel lblSelectCourse = new JLabel("Select Course");
		lblSelectCourse.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblSelectCourse.setBounds(65, 42, 170, 14);
		content.add(lblSelectCourse);
		lblEnrollmentFailed.setForeground(Color.RED);
		lblEnrollmentFailed.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblEnrollmentFailed.setBounds(75, 108, 130, 14);
		content.add(lblEnrollmentFailed);
		lblEnrollmentFailed.setVisible(false);
		lblEnrollmentSuccess.setForeground(Color.GREEN);
		lblEnrollmentSuccess.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblEnrollmentSuccess.setBounds(75, 108, 130, 14);
		content.add(lblEnrollmentSuccess);
		lblEnrollmentSuccess.setVisible(false);
	}

	public void addEnrollListener(ActionListener al) {
		enrollButton.addActionListener(al);
	}

	public String getSelectedCourse() {
		return String.valueOf(courseSelector.getSelectedItem());
	}
	
	public void enrollFail() {
		lblEnrollmentSuccess.setVisible(false);
		lblEnrollmentFailed.setVisible(true);
	}
	
	public void enrollSuccess() {
		lblEnrollmentFailed.setVisible(false);
		lblEnrollmentSuccess.setVisible(true);
	}
}
