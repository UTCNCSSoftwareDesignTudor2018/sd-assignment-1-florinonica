package business_logic.blls;

import java.util.List;
import java.util.NoSuchElementException;

import data_access.daos.ExamDAO;
import data_access.models.Exam;

public class ExamBLL {
	private ExamDAO examDAO;

	public ExamBLL() {
		examDAO = new ExamDAO();
	  }

	public List<Exam> findByID(String id) {
		List<Exam> l = examDAO.findByID(id);
		if (l.isEmpty()) {
			throw new NoSuchElementException("The  with these attributes was not found!");
		}
		return l;
	}
	
	public List<Exam> findByCourse(String id) {
		List<Exam> l = examDAO.findByCourseID(id);
		if (l.isEmpty()) {
			throw new NoSuchElementException("The  with these attributes was not found!");
		}
		return l;
	}
	
	public List<Exam> listAllExams() {
		List<Exam> l = examDAO.findAll();
		if (l.isEmpty()) {
			throw new NoSuchElementException("There are no Exams in the database!");
		}
		return l;
	}

}
