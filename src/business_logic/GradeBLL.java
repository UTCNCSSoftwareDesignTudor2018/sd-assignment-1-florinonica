package business_logic;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import data_access.daos.GradeDAO;
import data_access.models.Grade;

public class GradeBLL {
	private GradeDAO GradeDAO;
	//private ErrView ev;

	public GradeBLL() {
		GradeDAO = new GradeDAO();
		//ev = new ErrView();
	  }

	public List<Grade> findGrade(ArrayList<String> fd, ArrayList<String> val) {
		List<Grade> l = GradeDAO.findOne(fd, val);
		if (l.isEmpty()) {
			//ev.setMessage("The Grade with these attributes was not found!");
			throw new NoSuchElementException("The Grade with these attributes was not found!");
		}
		return l;
	}

	public List<Grade> listAllGrades() {
		List<Grade> l = GradeDAO.findAll();
		if (l.isEmpty()) {
			//ev.setMessage("There are no Grades in the database!");
			throw new NoSuchElementException("There are no Grades in the database!");
		}
		return l;
	}

	public void insertGrade(Grade t) throws Exception {
		int i = GradeDAO.insert(t);
		if (i == 0) {
			throw new Exception("Insert failed");
		}
	}

	public void updateGradeInformation(ArrayList<String> val, ArrayList<String> fd) throws Exception {
		int i = GradeDAO.update(val, fd);
		if (i == 0) {
			throw new Exception("Update failed!");
		}
	}

	public void deleteGrade(ArrayList<String> fd, ArrayList<String> val) throws Exception {
		int i = GradeDAO.delete(fd, val);
		if (i == 0) {
			throw new Exception("Delete failed");
		}
	}
}