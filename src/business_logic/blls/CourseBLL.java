package business_logic.blls;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import data_access.daos.CourseDAO;
import data_access.models.Course;

public class CourseBLL {
	private CourseDAO CourseDAO;

	public CourseBLL() {
		CourseDAO = new CourseDAO();
	  }

	public List<Course> findCourse(ArrayList<String> fd, ArrayList<String> val) {
		List<Course> l = CourseDAO.findOne(fd, val);
		if (l.isEmpty()) {
			throw new NoSuchElementException("The Course with these attributes was not found!");
		}
		return l;
	}

	public List<Course> listAllCourses() {
		List<Course> l = CourseDAO.findAll();
		if (l.isEmpty()) {
			throw new NoSuchElementException("There are no Courses in the database!");
		}
		return l;
	}
	
	public List<String> getCourseNames() {
		List<Course> l = CourseDAO.findAll();
		if (l.isEmpty()) {
			throw new NoSuchElementException("There are no Courses in the database!");
		}
		List<String> s = new ArrayList<String>();
		for(Course c: l) {
			s.add(c.getCourseName());
		}
		return s;
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
