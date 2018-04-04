package business_logic.blls;

import java.util.List;
import java.util.NoSuchElementException;

import data_access.daos.TeacherDAO;
import data_access.models.Teacher;

public class TeacherBLL {
	private TeacherDAO teacherDAO;

	public TeacherBLL() {
		teacherDAO = new TeacherDAO();
	}

	public List<Teacher> findTeacherByID(String id) {
		List<Teacher> l = teacherDAO.findByID(id);
		if (l.isEmpty()) {
			throw new NoSuchElementException("The Teacher with these attributes was not found!");
		}
		return l;
	}

	public List<Teacher> findTeacherByLoginCredentials(String username, String password) {
		List<Teacher> l = teacherDAO.findByLoginCredentials(username, password);
		if (l.isEmpty()) {
			throw new NoSuchElementException("The Teacher with these attributes was not found!");
		}
		return l;
	}

	public List<Teacher> listAllTeachers() {
		List<Teacher> l = teacherDAO.findAll();
		if (l.isEmpty()) {
			throw new NoSuchElementException("There are no Teachers in the database!");
		}
		return l;
	}

	public void updateTeacherInformation(String id, String username, String password, String email, String address) {
		teacherDAO.updateTeacher(id, username, password, email, address);
	}

}