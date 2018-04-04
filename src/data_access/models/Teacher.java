package data_access.models;

public class Teacher extends User {
	private String teacherID;

	public String getTeacherID() {
		return teacherID;
	}

	public void setTeacherID(String teacherID) {
		this.teacherID = teacherID;
	}
	
	@Override
	public String toString() {
		return "Teacher: " + this.getFirstName() + this.getLastName();
	}
}
