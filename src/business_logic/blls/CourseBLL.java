package business_logic.blls;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import data_access.daos.CourseDAO;
import data_access.entities.Course;

public class CourseBLL {
	private CourseDAO courseDAO;

	public CourseBLL() {
		courseDAO = new CourseDAO();
	  }
	
	public List<Course> findByID(String id) {
		List<Course> l = courseDAO.findByID(id);
		if (l.isEmpty()) {
			throw new NoSuchElementException("The  with these attributes was not found!");
		}
		return l;
	}
	
	public List<Course> findByTeacher(String id) {
		List<Course> l = courseDAO.findByTeacherID(id);
		if (l.isEmpty()) {
			throw new NoSuchElementException("The  with these attributes was not found!");
		}
		return l;
	}
	
	public List<Course> findByName(String name) {
		List<Course> l = courseDAO.findByName(name);
		if (l.isEmpty()) {
			throw new NoSuchElementException("The  with these attributes was not found!");
		}
		return l;
	}

	public List<Course> listAllCourses() {
		List<Course> l = courseDAO.findAll();
		if (l.isEmpty()) {
			throw new NoSuchElementException("There are no Courses in the database!");
		}
		return l;
	}
	
	public List<String> getCourseNames() {
		List<Course> l = courseDAO.findAll();
		if (l.isEmpty()) {
			throw new NoSuchElementException("There are no Courses in the database!");
		}
		List<String> s = new ArrayList<String>();
		for(Course c: l) {
			s.add(c.getCourseName());
		}
		return s;
	}

}
