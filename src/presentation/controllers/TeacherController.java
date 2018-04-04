package presentation.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import business_logic.blls.GradeBLL;
import business_logic.blls.StudentBLL;
import business_logic.blls.StudentEnrollmentBLL;
import business_logic.blls.TeacherBLL;
import data_access.models.Student;
import data_access.models.Teacher;
import presentation.user_interface.TeacherMenuView;
import presentation.user_interface.TeacherProfileView;
import presentation.user_interface.AddStudentView;
import presentation.user_interface.EnrollmentsView;
import presentation.user_interface.GradeView;
import presentation.user_interface.StudentTableView;

public class TeacherController {
	private TeacherBLL tbll;
	private StudentBLL sbll;
	private GradeBLL gbll;
	private TeacherMenuView tmv;
	private StudentEnrollmentBLL ebll;
	public TeacherProfileView tpv;
	private StudentTableView stv;

	public TeacherController() {
		this.tbll = new TeacherBLL();
		this.sbll = new StudentBLL();
		this.tmv = new TeacherMenuView();
		this.gbll = new GradeBLL();
		this.ebll = new StudentEnrollmentBLL();
		this.tmv.setVisible(false);
		this.stv = new StudentTableView();
		this.stv.setVisible(false);
		tmv.addViewProfileListener(new ViewProfileListener());
		tmv.addOpenStudentTabListener(new OpenStudentTabListener());
	}

	public void openMenu() {
		this.tmv.setVisible(true);
	}

	public List<Teacher> login(String username, String password) {
		List<Teacher> l = tbll.findTeacherByLoginCredentials(username, password);
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
	
	class OpenStudentTabListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			stv.setVisible(true);
			stv.addViewStudentsListener(new ViewStudentListener());
			stv.addDeleteStudentListener(new DeleteStudentListener());
			stv.addSaveListener(new SaveStudentListener());
			stv.addAddStudentListener(new AddAddStudentListener());
			stv.addViewGradesListener(new ViewStudentGradesListener());
			stv.addViewEnrollmentsListener(new ViewStudentEnrollmentsListener());
		}
	}
	
	class ViewStudentListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			List<Student> l = sbll.listAllStudents();
			stv.setTableContents(l);
		}
	}
	
	class DeleteStudentListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String id = stv.getData(0);
			sbll.deleteStudent(id);
			List<Student> l = sbll.listAllStudents();
			stv.setTableContents(l);
		}
	}
	
	class ViewStudentGradesListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String id = stv.getData(0);
			GradeView gv = new GradeView();
			gv.setTableContents(gbll.findByID(id));
			gv.setVisible(true);
		}
	}
	
	class ViewStudentEnrollmentsListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String id = stv.getData(0);
			EnrollmentsView ev = new EnrollmentsView();
			ev.setTableContents(ebll.findByStudent(id));
			ev.setVisible(true);
		}
	}
	
	class AddAddStudentListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			AddStudentView asv = new AddStudentView();
			asv.setVisible(true);
		}
	}
	
	class SaveStudentListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			try {
				tbll.updateTeacherInformation(tpv.getTeacherID(), tpv.getUsername(), tpv.getPassword(), 
						tpv.getEmail(), tpv.getAddress());
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
	}
	
	class SaveListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			try {
				tbll.updateTeacherInformation(tpv.getTeacherID(), tpv.getUsername(), tpv.getPassword(), 
						tpv.getEmail(), tpv.getAddress());
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
	}
	
}
