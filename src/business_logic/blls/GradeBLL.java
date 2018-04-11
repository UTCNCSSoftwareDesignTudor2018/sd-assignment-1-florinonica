package business_logic.blls;

import java.sql.Date;
import java.util.List;
import java.util.NoSuchElementException;

import data_access.daos.GradeDAO;
import data_access.entities.Grade;

public class GradeBLL {
	private GradeDAO gradeDAO;

	public GradeBLL() {
		gradeDAO = new GradeDAO();
	}

	public List<Grade> findByID(String id) {
		List<Grade> l = gradeDAO.findByID(id);
		if (l.isEmpty()) {
			throw new NoSuchElementException("The Grade with these attributes was not found!");
		}
		return l;
	}

	public List<Grade> listAllGrades() {
		List<Grade> l = gradeDAO.findAll();
		if (l.isEmpty()) {
			throw new NoSuchElementException("There are no Grades in the database!");
		}
		return l;
	}

	public void insertGrade(String id, String studentid, String examid, Date date, int value) {
		gradeDAO.createGrade(id, studentid, examid, date, value);
	}

	public void updateGradeInformation(String id, String studentid, String examid, Date date, int value) {
		gradeDAO.updateGrade(id, studentid, examid, date, value);
	}

	public void deleteGrade(String id){
		gradeDAO.deleteByID(id);
	}
}