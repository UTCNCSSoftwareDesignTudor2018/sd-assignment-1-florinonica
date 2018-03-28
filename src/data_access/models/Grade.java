package data_access.models;

import java.util.Date;

public class Grade {
	private String gradeID;
	private int value;
	private Exam exam;
	private Date date;
	
	public Grade(String gradeID, int value, Exam exam, Date date) {
		super();
		this.gradeID = gradeID;
		this.value = value;
		this.exam = exam;
		this.date = date;
	}

	public String getGradeID() {
		return gradeID;
	}

	public void setGradeID(String gradeID) {
		this.gradeID = gradeID;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public Exam getExam() {
		return exam;
	}

	public void setExam(Exam exam) {
		this.exam = exam;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	@Override
	public String toString() {
		return this.getExam().toString() + " Grade:" + this.getValue();
	}
}
