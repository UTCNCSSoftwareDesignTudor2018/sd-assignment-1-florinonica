package business_logic.blls;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import business_logic.validators.TeacherEmailValidator;
import business_logic.validators.Validator;
import data_access.daos.TeacherDAO;
import data_access.models.Teacher;

public class TeacherBLL {
	private List<Validator<Teacher>> validators;
	private TeacherDAO TeacherDAO;

	public TeacherBLL() {
		validators = new ArrayList<Validator<Teacher>>();
		validators.add(new TeacherEmailValidator());
		TeacherDAO = new TeacherDAO();
	  }

	public List<Teacher> findTeacher(ArrayList<String> fd, ArrayList<String> val) {
		List<Teacher> l = TeacherDAO.findOne(fd, val);
		if (l.isEmpty()) {
			throw new NoSuchElementException("The Teacher with these attributes was not found!");
		}
		return l;
	}

	public List<Teacher> listAllTeachers() {
		List<Teacher> l = TeacherDAO.findAll();
		if (l.isEmpty()) {
			throw new NoSuchElementException("There are no Teachers in the database!");
		}
		return l;
	}

	public void insertTeacher(Teacher t) throws Exception {
		for (Validator<Teacher> v : validators) {
			v.validate(t);
		}
		int i = TeacherDAO.insert(t);
		if (i == 0) {
			throw new Exception("Insert failed");
		}
	}

	public void updateTeacherInformation(ArrayList<String> val, ArrayList<String> fd) throws Exception {
		int i = TeacherDAO.update(val, fd);
		if (i == 0) {
			throw new Exception("Update failed!");
		}
	}

	public void deleteTeacher(ArrayList<String> fd, ArrayList<String> val) throws Exception {
		int i = TeacherDAO.delete(fd, val);
		if (i == 0) {
			throw new Exception("Delete failed");
		}
	}
}