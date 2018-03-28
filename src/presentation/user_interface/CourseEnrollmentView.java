package presentation.user_interface;

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

@SuppressWarnings("serial")
public class CourseEnrollmentView extends JFrame {
	private JPanel content;
	JButton enrollButton = new JButton("Enroll");
	JComboBox<String> courseSelector = new JComboBox<String>();

	public CourseEnrollmentView(List<String> courses) {
		this.setTitle("CourseEnrollment");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
	}

	void EnrollListener(ActionListener al) {
		enrollButton.addActionListener(al);
	}

	public String getSelectedCourse() {
		return String.valueOf(courseSelector.getSelectedItem());
	}
}
