package data_access.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import data_access.connection.ConnectionFactory;
import data_access.entities.Teacher;

public class TeacherDAO {
	public List<Teacher> createTeacherObject(ResultSet teacherSet) {
		List<Teacher> teacherList = new ArrayList<Teacher>();
		try {
			while (teacherSet.next()) {
				Teacher t = new Teacher();
				t.setTeacherID(teacherSet.getString("teacherid"));
				t.setUsername(teacherSet.getString("username"));
				t.setPassword(teacherSet.getString("password"));
				t.setFirstName(teacherSet.getString("firstname"));
				t.setLastName(teacherSet.getString("lastname"));
				t.setCNP(teacherSet.getString("cnp"));
				t.setIdentityCardNumber(teacherSet.getString("identitycardnumber"));
				t.setEmail(teacherSet.getString("email"));
				t.setAddress(teacherSet.getString("address"));
				teacherList.add(t);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return teacherList;
	}
	public List<Teacher> findAll() {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT * FROM teachers");
		String query = sb.toString();
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.prepareStatement(query);
			resultSet = statement.executeQuery();
			return createTeacherObject(resultSet);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionFactory.close(resultSet);
			ConnectionFactory.close(statement);
			ConnectionFactory.close(connection);
		}
		return null;
	}
	public List<Teacher> findByID(String id) {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		String query = "SELECT * FROM teachers WHERE teacherid = ?";
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.prepareStatement(query);
			statement.setObject(1, id);
			resultSet = statement.executeQuery();
			return createTeacherObject(resultSet);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionFactory.close(resultSet);
			ConnectionFactory.close(statement);
			ConnectionFactory.close(connection);
		}
		return null;
	}
	
	public List<Teacher> findByLoginCredentials(String username, String password) {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		String query = "SELECT * FROM teachers WHERE username = ? AND `password` = ?";
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.prepareStatement(query);
			statement.setObject(1, username);
			statement.setObject(2, password);
			resultSet = statement.executeQuery();
			return createTeacherObject(resultSet);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionFactory.close(resultSet);
			ConnectionFactory.close(statement);
			ConnectionFactory.close(connection);
		}
		return null;
	}
	
	public void updateTeacher(String id, String username, String password, String email, String address) {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		String query = "UPDATE teachers SET username = ?, password = ?, email = ?, "
				+ "address = ? WHERE teacherid = ?";
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
