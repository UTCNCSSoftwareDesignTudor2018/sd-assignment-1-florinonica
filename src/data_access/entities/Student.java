package data_access.entities;

public class Student extends User {
	private String studentID;
	private int group;

	public String getStudentID() {
		return studentID;
	}

	public void setStudentID(String studentID) {
		this.studentID = studentID;
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
