package business_logic;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import data_access.daos.ExamDAO;
import data_access.models.Exam;

public class ExamBLL {
	private ExamDAO ExamDAO;
	//private ErrView ev;

	public ExamBLL() {
		ExamDAO = new ExamDAO();
		//ev = new ErrView();
	  }

	public List<Exam> findExam(ArrayList<String> fd, ArrayList<String> val) {
		List<Exam> l = ExamDAO.findOne(fd, val);
		if (l.isEmpty()) {
			//ev.setMessage("The Exam with these attributes was not found!");
			throw new NoSuchElementException("The Exam with these attributes was not found!");
		}
		return l;
	}

	public List<Exam> listAllExams() {
		List<Exam> l = ExamDAO.findAll();
		if (l.isEmpty()) {
			//ev.setMessage("There are no Exams in the database!");
			throw new NoSuchElementException("There are no Exams in the database!");
		}
		return l;
	}

	public void insertExam(Exam t) throws Exception {
		int i = ExamDAO.insert(t);
		if (i == 0) {
			throw new Exception("Insert failed");
		}
	}

	public void updateExamInformation(ArrayList<String> val, ArrayList<String> fd) throws Exception {
		int i = ExamDAO.update(val, fd);
		if (i == 0) {
			throw new Exception("Update failed!");
		}
	}

	public void deleteExam(ArrayList<String> fd, ArrayList<String> val) throws Exception {
		int i = ExamDAO.delete(fd, val);
		if (i == 0) {
			throw new Exception("Delete failed");
		}
	}
}
