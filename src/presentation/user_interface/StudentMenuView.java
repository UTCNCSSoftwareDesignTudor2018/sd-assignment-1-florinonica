package presentation.user_interface;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

@SuppressWarnings("serial")
public class StudentMenuView extends JFrame {
	private JPanel content;
	JButton viewProfileButton = new JButton("View Profile");
	JButton enrollButton = new JButton("Enroll to a course");

	public StudentMenuView() {
		this.setTitle("Student Menu");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(300, 300);
		content = new JPanel();
		this.setContentPane(content);
		content.setLayout(null);

		viewProfileButton.setFont(new Font("Calibri", Font.PLAIN, 16));
		viewProfileButton.setBounds(65, 70, 170, 55);
		content.add(viewProfileButton);

		enrollButton.setFont(new Font("Calibri", Font.PLAIN, 16));
		enrollButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		enrollButton.setBounds(65, 140, 170, 55);
		content.add(enrollButton);
	}

	public void addViewProfileListener(ActionListener al) {
		viewProfileButton.addActionListener(al);
	}
	
	public void addEnrollListener(ActionListener al) {
		enrollButton.addActionListener(al);
	}

}
