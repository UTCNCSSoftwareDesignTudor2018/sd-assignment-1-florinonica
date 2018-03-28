package presentation.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import presentation.user_interface.LoginView;

public class LoginController {
	private LoginView view;
	private String userType = "Student";
	private StudentController sc;
	private TeacherController tc;
	public LoginController(LoginView view) {
		this.view = view;
		view.addLoginListener(new LoginListener());
	}

	class LoginListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			userType = view.getUserType();
			String username = view.getUsername();
			String password = view.getPassword();
			if (userType.equals("Student")) {
				view.setVisible(false);
			} else {
				view.setVisible(false);
			}
		}
	}

}
