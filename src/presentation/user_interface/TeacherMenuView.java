package presentation.user_interface;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class TeacherMenuView extends JFrame {

	private JPanel content;
	JButton viewProfileButton = new JButton("View Profile");
	JButton openStudentTabButton = new JButton("Open Student Tab");

	public TeacherMenuView() {
		this.setTitle("Teacher Menu");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(300, 300);
		content = new JPanel();
		this.setContentPane(content);
		content.setLayout(null);

		viewProfileButton.setFont(new Font("Calibri", Font.PLAIN, 16));
		viewProfileButton.setBounds(65, 70, 170, 55);
		content.add(viewProfileButton);

		openStudentTabButton.setFont(new Font("Calibri", Font.PLAIN, 16));
		openStudentTabButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		openStudentTabButton.setBounds(65, 140, 170, 55);
		content.add(openStudentTabButton);
	}

	public void addViewProfileListener(ActionListener al) {
		viewProfileButton.addActionListener(al);
	}

	public void addOpenStudentTabListener(ActionListener al) {
		openStudentTabButton.addActionListener(al);
	}

}
