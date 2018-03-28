package presentation.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import business_logic.blls.TeacherBLL;
import data_access.models.Teacher;
import presentation.user_interface.TeacherMenuView;
import presentation.user_interface.TeacherProfileView;
import presentation.user_interface.StudentTableView;

public class TeacherController {
	private TeacherBLL tbll;
	private TeacherMenuView tmv;
	public TeacherProfileView tpv;
	private StudentTableView stv;

	public TeacherController() {
		this.tbll = new TeacherBLL();
		this.tmv = new TeacherMenuView();
		this.tmv.setVisible(false);
		this.stv = new StudentTableView();
		this.stv.setVisible(false);
		tmv.addViewProfileListener(new ViewProfileListener());
	}

	public void openMenu() {
		this.tmv.setVisible(true);
	}

	public List<Teacher> login(String username, String password) {
		ArrayList<String> fd = new ArrayList<String>();
		fd.add("username");
		fd.add("password");
		ArrayList<String> val = new ArrayList<String>();
		val.add(username);
		val.add(password);
		List<Teacher> l = tbll.findTeacher(fd, val);
		if (!l.isEmpty()) {
			this.tmv.setVisible(true);
			this.tpv = new TeacherProfileView(l.get(0));
			this.tpv.setVisible(false);
		}
		return l;
	}
	class ViewProfileListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			tpv.setVisible(true);
			tpv.addSaveListener(new SaveListener());
		}
	}
	class SaveListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			ArrayList<String> fd = new ArrayList<String>();
			fd.add("firsname");
			fd.add("lastname");
			fd.add("email");
			fd.add("address");
			ArrayList<String> val = new ArrayList<String>();
			val.add(tpv.getFirstName());
			val.add(tpv.getLastName());
			val.add(tpv.getEmail());
			val.add(tpv.getAddress());
			try {
				tbll.updateTeacherInformation(val, fd);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
	}
}
