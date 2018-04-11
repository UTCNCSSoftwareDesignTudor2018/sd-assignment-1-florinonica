package business_logic.blls;

import java.util.List;
import java.util.NoSuchElementException;

import data_access.daos.StudentEnrollmentDAO;
import data_access.entities.StudentEnrollment;

public class StudentEnrollmentBLL {
	private StudentEnrollmentDAO studentEnrollmentDAO;

	public StudentEnrollmentBLL() {
		studentEnrollmentDAO = new StudentEnrollmentDAO();
	}

	public List<StudentEnrollment> findByStudent(String id) {
		List<StudentEnrollment> l = studentEnrollmentDAO.findByStudentID(id);
		if (l.isEmpty()) {
			throw new NoSuchElementException("The  with these attributes was not found!");
		}
		return l;
	}

	public List<StudentEnrollment> findByCourse(String id) {
		List<StudentEnrollment> l = studentEnrollmentDAO.findByCourseID(id);
		if (l.isEmpty()) {
			throw new NoSuchElementException("The  with these attributes was not found!");
		}
		return l;
	}
	
	public List<StudentEnrollment> findByBoth(String cid, String sid) {
		List<StudentEnrollment> l = studentEnrollmentDAO.findByBothID(cid, sid);
		return l;
	}
	
	public void createEnrollment(String id, String studentid, String courseid) {
		studentEnrollmentDAO.createEnrollment(id, studentid, courseid);
	}
	
	public void updateEnrollmentInformation(String id, String studentid, String courseid) {
		studentEnrollmentDAO.updateEnrollment(id, studentid, courseid);
	}
	
	public void deleteGrade(String id){
		studentEnrollmentDAO.deleteByID(id);
	}
}
