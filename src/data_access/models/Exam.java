package data_access.models;

import java.util.Date;

public class Exam {
	private String examID;
	private Course course;
	private Date date;

	public Exam(String examID, Course course, Date date) {
		super();
		this.examID = examID;
		this.course = course;
		this.date = date;
	}

	public String getExamID() {
		return examID;
	}

	public void setExamID(String examID) {
		this.examID = examID;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	@Override
	public String toString() {
		return "Exam for:" + this.getCourse().toString();
	}

}
