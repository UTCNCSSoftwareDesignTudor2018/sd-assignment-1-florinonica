package presentation.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import business_logic.blls.CourseBLL;
import business_logic.blls.GradeBLL;
import business_logic.blls.StudentBLL;
import business_logic.blls.StudentEnrollmentBLL;
import data_access.entities.Course;
import data_access.entities.Student;
import data_access.entities.StudentEnrollment;
import presentation.views.CourseEnrollmentView;
import presentation.views.EnrollmentsView;
import presentation.views.GradeView;
import presentation.views.StudentMenuView;
import presentation.views.StudentProfileView;

public class StudentController {
	private StudentBLL sbll;
	private CourseBLL cbll;
	private GradeBLL gbll;
	private StudentEnrollmentBLL sebll;
	private StudentMenuView smv;
	private StudentProfileView spv;
	private CourseEnrollmentView cev;
	private GradeView gv;
	private Student s;
	public StudentController() {
		this.sbll = new StudentBLL();
		this.cbll = new CourseBLL();
		this.gbll = new GradeBLL();
		this.sebll = new StudentEnrollmentBLL();
		this.smv = new StudentMenuView();
		this.gv = new GradeView();
		this.smv.setVisible(false);
		smv.addViewProfileListener(new ViewProfileListener());
		smv.addEnrollListener(new EnrollListener());
		smv.addViewGradesListener(new GradeViewListener());
		smv.addViewEnrollmentsListener(new ViewStudentEnrollmentsListener());
	}
	public void openMenu() {
		this.smv.setVisible(true);
	}
	public List<Student> login(String username, String password) {
		List<Student> l = sbll.findStudentByLoginCredentials(username, password);
		if(!l.isEmpty()) {
			this.smv.setVisible(true);
			this.spv = new StudentProfileView(l.get(0));
			this.spv.setVisible(false);
			this.s = l.get(0);
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
			String course = cev.getSelectedCourse();
			List<Course> courses = cbll.findByName(course);
			if(!course.isEmpty()) {
				String id = courses.get(0).getCourseID();
				List<StudentEnrollment> se = sebll.findByBoth(id, s.getStudentID());
				if(!se.isEmpty()) {
					cev.enrollFail();
				}
				else {
					sebll.createEnrollment(UUID.randomUUID().toString().substring(0, 3), s.getStudentID(), id);
					cev.enrollSuccess();
				}
			}
		}
	}
	class SaveListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			try {
				sbll.updateStudentInformation(spv.getStudentID(), spv.getUsername(), spv.getPassword(), 
						spv.getEmail(), spv.getAddress());
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
	}
	
	class GradeViewListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			gv.setTableContents(gbll.findByID(s.getStudentID()));
			gv.setVisible(true);
		}
	}
	
	class ViewStudentEnrollmentsListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			EnrollmentsView ev = new EnrollmentsView();
			List<StudentEnrollment> se = sebll.findByStudent(s.getStudentID());
			List<Course> c = new ArrayList<Course>();
			for(StudentEnrollment s: se) {
				c.addAll(cbll.findByID(s.getCourseID()));
			}
			
			ev.setTableContents(c);
			ev.setVisible(true);
		}
	}
}
