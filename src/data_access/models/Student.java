package data_access.models;

import java.util.List;

public class Student extends User {
	private String studentID;
	private int group;
	private List<Course> enrollments;
	private List<Grade> grades;

	public Student(String username, String password, String firstName, String lastName, String address, String email,
			String CNP, String identityCardNumber, String studentID, int group, List<Course> enrollments, List<Grade> grades) {
		super(username, password, firstName, lastName, address, email, CNP, identityCardNumber);
		this.studentID = studentID;
		this.enrollments = enrollments;
		this.grades = grades;
		this.group = group;
	}

	public String getStudentID() {
		return studentID;
	}

	public void setStudentID(String studentID) {
		this.studentID = studentID;
	}

	public List<Course> getEnrollments() {
		return enrollments;
	}

	public void setEnrollments(List<Course> enrollments) {
		this.enrollments = enrollments;
	}

	public List<Grade> getGrades() {
		return grades;
	}

	public void setGrades(List<Grade> grades) {
		this.grades = grades;
	}
	
	public void enrollToCourse(Course c) {
		this.enrollments.add(c);
	}
	
	@Override
	public String toString() {
		return "Student: " + this.getFirstName() + this.getLastName();
	}

	public int getGroup() {
		return group;
	}

	public void setGroup(int group) {
		this.group = group;
	}
}
