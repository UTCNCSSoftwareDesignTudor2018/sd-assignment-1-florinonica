package data_access.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import data_access.connection.ConnectionFactory;
import data_access.models.Exam;

public class ExamDAO {
	public List<Exam> createExamObject(ResultSet examSet) {
		List<Exam> examList = new ArrayList<Exam>();
		try {
			while (examSet.next()) {
				Exam e = new Exam();
				e.setExamID(examSet.getString("examid"));
				e.setCourseID(examSet.getString("courseid"));
				e.setDate(examSet.getDate("date"));
				examList.add(e);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return examList;
	}

	public List<Exam> findAll() {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT * FROM exams");
		String query = sb.toString();
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.prepareStatement(query);
			resultSet = statement.executeQuery();
			return createExamObject(resultSet);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionFactory.close(resultSet);
			ConnectionFactory.close(statement);
			ConnectionFactory.close(connection);
		}
		return null;
	}

	public List<Exam> findByID(String id) {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		String query = "SELECT * FROM exams WHERE examid = ?";
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.prepareStatement(query);
			statement.setObject(1, id);
			resultSet = statement.executeQuery();
			return createExamObject(resultSet);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionFactory.close(resultSet);
			ConnectionFactory.close(statement);
			ConnectionFactory.close(connection);
		}
		return null;
	}

	public List<Exam> findByCourseID(String id) {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		String query = "SELECT * FROM exams WHERE courseid = ?";
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.prepareStatement(query);
			statement.setObject(1, id);
			resultSet = statement.executeQuery();
			return createExamObject(resultSet);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionFactory.close(resultSet);
			ConnectionFactory.close(statement);
			ConnectionFactory.close(connection);
		}
		return null;
	}
}
