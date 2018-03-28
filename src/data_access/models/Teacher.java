package data_access.models;

public class Teacher extends User {
	private String teacherID;
	public Teacher(String username, String password, String firstName, String lastName, String address, String email,
			String CNP, String identityCardNumber, String teacherID) {
		super(username, password, firstName, lastName, address, email, CNP, identityCardNumber);
		this.teacherID = teacherID;
	}

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
