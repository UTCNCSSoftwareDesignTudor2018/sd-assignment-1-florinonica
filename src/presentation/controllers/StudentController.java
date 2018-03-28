package presentation.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import business_logic.blls.CourseBLL;
import business_logic.blls.StudentBLL;
import data_access.models.Student;
import presentation.user_interface.CourseEnrollmentView;
import presentation.user_interface.GradeView;
import presentation.user_interface.StudentMenuView;
import presentation.user_interface.StudentProfileView;

public class StudentController {
	private StudentBLL sbll;
	private CourseBLL cbll;
	private StudentMenuView smv;
	private StudentProfileView spv;
	private CourseEnrollmentView cev;
	private GradeView gv;
	public StudentController() {
		this.sbll = new StudentBLL();
		this.cbll = new CourseBLL();
		this.smv = new StudentMenuView();
		this.smv.setVisible(false);
		smv.addViewProfileListener(new ViewProfileListener());
		smv.addEnrollListener(new EnrollListener());
	}
	public void openMenu() {
		this.smv.setVisible(true);
	}
	public List<Student> login(String username, String password) {
		ArrayList<String> fd = new ArrayList<String>();
		fd.add("username");
		fd.add("password");
		ArrayList<String> val = new ArrayList<String>();
		val.add(username);
		val.add(password);
		List<Student> l = sbll.findStudent(fd, val);
		if(!l.isEmpty()) {
			this.smv.setVisible(true);
			this.spv = new StudentProfileView(l.get(0));
			this.spv.setVisible(false);
		}
		return l;
	}
	class ViewProfileListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			spv.setVisible(true);
			spv.addSaveListener(new SaveListener());
		}
	}
	
	class EnrollListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			List<String> courses = cbll.getCourseNames();
			cev = new CourseEnrollmentView(courses);
			cev.setVisible(true);
			cev.addEnrollListener(new EnrollmentListener());
		}
	}
	
	class EnrollmentListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
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
			val.add(spv.getFirstName());
			val.add(spv.getLastName());
			val.add(spv.getEmail());
			val.add(spv.getAddress());
			try {
				sbll.updateStudentInformation(val, fd);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
	}
}
