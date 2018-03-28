package business_logic.blls;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import business_logic.validators.StudentEmailValidator;
import business_logic.validators.Validator;
import data_access.daos.StudentDAO;
import data_access.models.Student;

public class StudentBLL {
	private List<Validator<Student>> validators;
	private StudentDAO StudentDAO;

	public StudentBLL() {
		validators = new ArrayList<Validator<Student>>();
		validators.add(new StudentEmailValidator());
		StudentDAO = new StudentDAO();
	  }

	public List<Student> findStudent(ArrayList<String> fd, ArrayList<String> val) {
		List<Student> l = StudentDAO.findOne(fd, val);
		if (l.isEmpty()) {
			throw new NoSuchElementException("The Student with these attributes was not found!");
		}
		return l;
	}

	public List<Student> listAllStudents() {
		List<Student> l = StudentDAO.findAll();
		if (l.isEmpty()) {
			throw new NoSuchElementException("There are no Students in the database!");
		}
		return l;
	}

	public void insertStudent(Student t) throws Exception {
		for (Validator<Student> v : validators) {
			v.validate(t);
		}
		int i = StudentDAO.insert(t);
		if (i == 0) {
			throw new Exception("Insert failed");
		}
	}

	public void updateStudentInformation(ArrayList<String> val, ArrayList<String> fd) throws Exception {
		int i = StudentDAO.update(val, fd);
		if (i == 0) {
			throw new Exception("Update failed!");
		}
	}

	public void deleteStudent(ArrayList<String> fd, ArrayList<String> val) throws Exception {
		int i = StudentDAO.delete(fd, val);
		if (i == 0) {
			throw new Exception("Delete failed");
		}
	}
}
