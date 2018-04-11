package data_access.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import data_access.connection.ConnectionFactory;
import data_access.entities.Student;

public class StudentDAO {
	public List<Student> createStudentObject(ResultSet studentSet) {
		List<Student> studentList = new ArrayList<Student>();
		try {
			while (studentSet.next()) {
				Student s = new Student();
				s.setStudentID(studentSet.getString("studentid"));
				s.setUsername(studentSet.getString("username"));
				s.setPassword(studentSet.getString("password"));
				s.setFirstName(studentSet.getString("firstname"));
				s.setLastName(studentSet.getString("lastname"));
				s.setCNP(studentSet.getString("cnp"));
				s.setIdentityCardNumber(studentSet.getString("identitycardnumber"));
				s.setEmail(studentSet.getString("email"));
				s.setAddress(studentSet.getString("address"));
				s.setGroup(studentSet.getInt("group"));
				studentList.add(s);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return studentList;
	}

	public List<Student> findAll() {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT * FROM students");
		String query = sb.toString();
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.prepareStatement(query);
			resultSet = statement.executeQuery();
			return createStudentObject(resultSet);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionFactory.close(resultSet);
			ConnectionFactory.close(statement);
			ConnectionFactory.close(connection);
		}
		return null;
	}

	public List<Student> findByID(String id) {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		String query = "SELECT * FROM students WHERE studentid = ?";
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.prepareStatement(query);
			statement.setObject(1, id);
			resultSet = statement.executeQuery();
			return createStudentObject(resultSet);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionFactory.close(resultSet);
			ConnectionFactory.close(statement);
			ConnectionFactory.close(connection);
		}
		return null;
	}
	
	public List<Student> findByLoginCredentials(String username, String password) {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		String query = "SELECT * FROM students WHERE username = ? AND `password` = ?";
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.prepareStatement(query);
			statement.setObject(1, username);
			statement.setObject(2, password);
			resultSet = statement.executeQuery();
			return createStudentObject(resultSet);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionFactory.close(resultSet);
			ConnectionFactory.close(statement);
			ConnectionFactory.close(connection);
		}
		return null;
	}
	
	public List<Student> findByGroup(int group) {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		String query = "SELECT * FROM students WHERE groupid = ?";
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.prepareStatement(query);
			statement.setObject(1, group);
			resultSet = statement.executeQuery();
			return createStudentObject(resultSet);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionFactory.close(resultSet);
			ConnectionFactory.close(statement);
			ConnectionFactory.close(connection);
		}
		return null;
	}
	
	public void deleteByID(String id) {
		Connection connection = null;
		PreparedStatement statement = null;
		String query = "DELETE FROM students WHERE studentid = ?";
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.prepareStatement(query);
			statement.setObject(1, id);
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionFactory.close(statement);
			ConnectionFactory.close(connection);
		}
	}
	
	public void createStudent(String id, String username, String password, String firstname, 
			String lastname, String CNP, String identityCardNumber, 
			String email, String address, int group) {
		Connection connection = null;
		PreparedStatement statement = null;
		String query = "INSERT INTO students (studentid, username, password, firstname, lastname,"
				+ " cnp, identitycardnumber, email, address, `group`) "
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.prepareStatement(query);
			statement.setObject(1, id);
			statement.setObject(2, username);
			statement.setObject(3, password);
			statement.setObject(4, firstname);
			statement.setObject(5, lastname);
			statement.setObject(6, CNP);
			statement.setObject(7, identityCardNumber);
			statement.setObject(8, email);
			statement.setObject(9, address);
			statement.setObject(10, group);
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionFactory.close(statement);
			ConnectionFactory.close(connection);
		}
	}
	
	public void updateStudent(String id, String username, String password, String email, String address) {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		String query = "UPDATE students SET username = ?, password = ?, email = ?, "
				+ "address = ? WHERE studentid = ?";
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.prepareStatement(query);
			statement.setObject(1, username);
			statement.setObject(2, password);
			statement.setObject(3, email);
			statement.setObject(4, address);
			statement.setObject(5, id);
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionFactory.close(resultSet);
			ConnectionFactory.close(statement);
			ConnectionFactory.close(connection);
		}
	}
}
