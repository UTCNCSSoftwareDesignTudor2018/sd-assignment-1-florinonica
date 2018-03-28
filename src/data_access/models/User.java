package data_access.models;

public class User {
	private String username;
	private String password;
	private String firstName;
	private String lastName;
	private String address;
	private String email;
	private String CNP;
	private String identityCardNumber;

	public User(String username, String password, String firstName, String lastName, String address, String email,
			String CNP, String identityCardNumber) {
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.email = email;
		this.CNP = CNP;
		this.identityCardNumber = identityCardNumber;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCNP() {
		return CNP;
	}

	public void setCNP(String cNP) {
		CNP = cNP;
	}

	public String getidentityCardNumber() {
		return identityCardNumber;
	}

	public void setidentityCardNumber(String identityCardNumber) {
		this.identityCardNumber = identityCardNumber;
	}

	@Override
	public String toString() {
		return "User: " + this.firstName + this.lastName;
	}
}
