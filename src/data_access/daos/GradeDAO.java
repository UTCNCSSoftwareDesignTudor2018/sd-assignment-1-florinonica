package data_access.daos;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import data_access.connection.ConnectionFactory;
import data_access.entities.Grade;

public class GradeDAO {
	public List<Grade> createGradeObject(ResultSet gradeSet) {
		List<Grade> gradeList = new ArrayList<Grade>();
		try {
			while (gradeSet.next()) {
				Grade g = new Grade();
				g.setGradeID(gradeSet.getString("gradeid"));
				g.setStudentID(gradeSet.getString("studentid"));
				g.setExamID(gradeSet.getString("examid"));
				g.setDate(gradeSet.getDate("date"));
				g.setValue(gradeSet.getInt("value"));
				gradeList.add(g);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return gradeList;
	}
	public List<Grade> findAll() {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT * FROM grades");
		String query = sb.toString();
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.prepareStatement(query);
			resultSet = statement.executeQuery();
			return createGradeObject(resultSet);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionFactory.close(resultSet);
			ConnectionFactory.close(statement);
			ConnectionFactory.close(connection);
		}
		return null;
	}
	public List<Grade> findByID(String id) {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		String query = "SELECT * FROM grades WHERE studentid = ?";
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.prepareStatement(query);
			statement.setObject(1, id);
			resultSet = statement.executeQuery();
			return createGradeObject(resultSet);
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
		String query = "DELETE * FROM grades WHERE studentid = ?";
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
	
	public void createGrade(String id, String studentid, String examid, Date date, int value) {
		Connection connection = null;
		PreparedStatement statement = null;
		String query = "INSERT INTO grades (gradeid, studentid, examid, date, value) VALUES (?, ?, ?, ?, ?)";
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.prepareStatement(query);
			statement.setObject(1, id);
			statement.setObject(2, studentid);
			statement.setObject(3, examid);
			statement.setObject(4, date);
			statement.setObject(5, value);
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionFactory.close(statement);
			ConnectionFactory.close(connection);
		}
	}
	
	public void updateGrade(String id, String studentid, String examid, Date date, int value) {
		Connection connection = null;
		PreparedStatement statement = null;
		String query = "UPDATE grades SET studentid = ?, examid = ?, date = ?, value = ? WHERE gradeid = ?";
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.prepareStatement(query);
			statement.setObject(1, studentid);
			statement.setObject(2, examid);
			statement.setObject(3, date);
			statement.setObject(4, value);
			statement.setObject(5, id);
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionFactory.close(statement);
			ConnectionFactory.close(connection);
		}
	}
}
