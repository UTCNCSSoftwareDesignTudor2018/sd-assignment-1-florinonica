package data_access.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import data_access.connection.ConnectionFactory;
import data_access.models.StudentEnrollment;

public class StudentEnrollmentDAO {
	public List<StudentEnrollment> createStudentEnrollmentObject(ResultSet studentEnrollmentSet) {
		List<StudentEnrollment> studentEnrollmentList = new ArrayList<StudentEnrollment>();
		try {
			while (studentEnrollmentSet.next()) {
				StudentEnrollment se = new StudentEnrollment();
				se.setCourseID(studentEnrollmentSet.getString("courseid"));
				se.setStudentID(studentEnrollmentSet.getString("studentid"));
				studentEnrollmentList.add(se);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return studentEnrollmentList;
	}
	public List<StudentEnrollment> findAll() {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT * FROM enrollments");
		String query = sb.toString();
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.prepareStatement(query);
			resultSet = statement.executeQuery();
			return createStudentEnrollmentObject(resultSet);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionFactory.close(resultSet);
			ConnectionFactory.close(statement);
			ConnectionFactory.close(connection);
		}
		return null;
	}
	public List<StudentEnrollment> findByStudentID(String id) {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		String query = "SELECT * FROM enrollments WHERE studentid = ?";
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.prepareStatement(query);
			statement.setObject(1, id);
			resultSet = statement.executeQuery();
			return createStudentEnrollmentObject(resultSet);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionFactory.close(resultSet);
			ConnectionFactory.close(statement);
			ConnectionFactory.close(connection);
		}
		return null;
	}
	
	public List<StudentEnrollment> findByCourseID(String id) {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		String query = "SELECT * FROM enrollments WHERE courseid = ?";
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.prepareStatement(query);
			statement.setObject(1, id);
			resultSet = statement.executeQuery();
			return createStudentEnrollmentObject(resultSet);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionFactory.close(resultSet);
			ConnectionFactory.close(statement);
			ConnectionFactory.close(connection);
		}
		return null;
	}
	
	public List<StudentEnrollment> findByBothID(String sid, String cid) {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		String query = "SELECT * FROM enrollments WHERE courseid = ? AND studentid = ?";
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.prepareStatement(query);
			statement.setObject(1, cid);
			statement.setObject(2, sid);
			resultSet = statement.executeQuery();
			return createStudentEnrollmentObject(resultSet);
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
		String query = "DELETE * FROM enrollments WHERE teacherid = ?";
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
	
	public void createEnrollment(String id, String studentid, String courseid) {
		Connection connection = null;
		PreparedStatement statement = null;
		String query = "INSERT INTO enrollments (enrollmentid, studentid, courseid) VALUES (?, ?, ?)";
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.prepareStatement(query);
			statement.setObject(1, id);
			statement.setObject(2, studentid);
			statement.setObject(3, courseid);
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionFactory.close(statement);
			ConnectionFactory.close(connection);
		}
	}
	
	public void updateEnrollment(String id, String studentid, String courseid) {
		Connection connection = null;
		PreparedStatement statement = null;
		String query = "UPDATE enrollments SET studentid = ?, courseid = ?, WHERE enrollmentid = ?";
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.prepareStatement(query);
			statement.setObject(1, studentid);
			statement.setObject(2, courseid);
			statement.setObject(3, id);
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionFactory.close(statement);
			ConnectionFactory.close(connection);
		}
	}
}
