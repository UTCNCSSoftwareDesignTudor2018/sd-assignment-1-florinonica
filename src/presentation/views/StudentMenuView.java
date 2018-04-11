package presentation.views;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.Font;

@SuppressWarnings("serial")
public class StudentMenuView extends JFrame {
	private JPanel content;
	JButton viewProfileButton = new JButton("View profile");
	JButton enrollButton = new JButton("Enroll to a course");
	JButton viewGradesButton = new JButton("View grades");
	JButton viewEnrollmentsButton = new JButton("View enrollments");

	public StudentMenuView() {
		this.setTitle("Student Menu");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setSize(300, 400);
		content = new JPanel();
		this.setContentPane(content);
		content.setLayout(null);

		viewProfileButton.setFont(new Font("Calibri", Font.PLAIN, 16));
		viewProfileButton.setBounds(65, 20, 170, 55);
		content.add(viewProfileButton);

		enrollButton.setFont(new Font("Calibri", Font.PLAIN, 16));
		enrollButton.setBounds(65, 100, 170, 55);
		content.add(enrollButton);
		
		viewGradesButton.setFont(new Font("Calibri", Font.PLAIN, 16));
		viewGradesButton.setBounds(65, 180, 170, 55);
		content.add(viewGradesButton);
		
		viewEnrollmentsButton.setFont(new Font("Calibri", Font.PLAIN, 16));
		viewEnrollmentsButton.setBounds(65, 260, 170, 55);
		content.add(viewEnrollmentsButton);
	}

	public void addViewProfileListener(ActionListener al) {
		viewProfileButton.addActionListener(al);
	}
	
	public void addEnrollListener(ActionListener al) {
		enrollButton.addActionListener(al);
	}
	
	public void addViewGradesListener(ActionListener al) {
		viewGradesButton.addActionListener(al);
	}
	
	public void addViewEnrollmentsListener(ActionListener al) {
		viewEnrollmentsButton.addActionListener(al);
	}

}
