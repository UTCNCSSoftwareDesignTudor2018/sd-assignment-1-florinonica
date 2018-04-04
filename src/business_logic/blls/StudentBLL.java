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
	private StudentDAO studentDAO;
	public StudentBLL() {
		validators = new ArrayList<Validator<Student>>();
		validators.add(new StudentEmailValidator());
		studentDAO = new StudentDAO();
	  }

	public List<Student> findStudentByID(String id) {
		List<Student> l = studentDAO.findByID(id);
		if (l.isEmpty()) {
			throw new NoSuchElementException("The Student with these attributes was not found!");
		}
		return l;
	}
	
	public List<Student> findStudentByLoginCredentials(String username, String password) {
		List<Student> l = studentDAO.findByLoginCredentials(username, password);
		if (l.isEmpty()) {
			throw new NoSuchElementException("The Student with these attributes was not found!");
		}
		return l;
	}
	
	public List<Student> findStudentByGroup(int group) {
		List<Student> l = studentDAO.findByGroup(group);
		if (l.isEmpty()) {
			throw new NoSuchElementException("The Student with these attributes was not found!");
		}
		return l;
	}

	public List<Student> listAllStudents() {
		List<Student> l = studentDAO.findAll();
		if (l.isEmpty()) {
			throw new NoSuchElementException("There are no Students in the database!");
		}
		return l;
	}

	
	public void insertStudent(String id, String username, String password, String firstname, 
			String lastname, String CNP, String identityCardNumber, 
			String email, String address, int group) {
		studentDAO.createStudent(id, username, password, firstname, lastname,
				CNP, identityCardNumber, email, address, group);
	}

	public void updateStudentInformation(String id, String username, String password, String email, String address) {
		studentDAO.updateStudent(id, username, password, email, address);
	}

	public void deleteStudent(String id) {
		studentDAO.deleteByID(id);
	}
}
