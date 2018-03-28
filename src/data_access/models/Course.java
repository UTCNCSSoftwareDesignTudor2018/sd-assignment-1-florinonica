package data_access.models;

import java.util.List;

public class Course {
	private String courseID;
	private String courseName;
	private List<Student> courseStudents;
	private Teacher teacher;

	public Course(String courseID, String courseName, List<Student> courseStudents, Teacher teacher) {
		super();
		this.courseID = courseID;
		this.courseName = courseName;
		this.courseStudents = courseStudents;
		this.teacher = teacher;
	}

	public String getCourseID() {
		return courseID;
	}

	public void setCourseID(String courseID) {
		this.courseID = courseID;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public List<Student> getCourseStudents() {
		return courseStudents;
	}

	public void setCourseStudents(List<Student> courseStudents) {
		this.courseStudents = courseStudents;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	
	@Override
	public String toString() {
		return this.getCourseName();
	}

}
