package presentation.controllers;

import presentation.views.LoginView;

public class MainController {
	public static void main(String args[]) {
		LoginView v = new LoginView();
		@SuppressWarnings("unused")
		LoginController ctrl = new LoginController(v);
		v.setVisible(true);
	}
}
