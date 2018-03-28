package business_logic;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import data_access.daos.CourseDAO;
import data_access.models.Course;

public class CourseBLL {
	private CourseDAO CourseDAO;
	//private ErrView ev;

	public CourseBLL() {
		CourseDAO = new CourseDAO();
		//ev = new ErrView();
	  }

	public List<Course> findCourse(ArrayList<String> fd, ArrayList<String> val) {
		List<Course> l = CourseDAO.findOne(fd, val);
		if (l.isEmpty()) {
			//ev.setMessage("The Course with these attributes was not found!");
			throw new NoSuchElementException("The Course with these attributes was not found!");
		}
		return l;
	}

	public List<Course> listAllCourses() {
		List<Course> l = CourseDAO.findAll();
		if (l.isEmpty()) {
			//ev.setMessage("There are no Courses in the database!");
			throw new NoSuchElementException("There are no Courses in the database!");
		}
		return l;
	}

	public void insertCourse(Course t) throws Exception {
		int i = CourseDAO.insert(t);
		if (i == 0) {
			throw new Exception("Insert failed");
		}
	}

	public void updateCourseInformation(ArrayList<String> val, ArrayList<String> fd) throws Exception {
		int i = CourseDAO.update(val, fd);
		if (i == 0) {
			throw new Exception("Update failed!");
		}
	}

	public void deleteCourse(ArrayList<String> fd, ArrayList<String> val) throws Exception {
		int i = CourseDAO.delete(fd, val);
		if (i == 0) {
			throw new Exception("Delete failed");
		}
	}
}
