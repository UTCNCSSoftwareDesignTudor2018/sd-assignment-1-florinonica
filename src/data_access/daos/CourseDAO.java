package data_access.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import data_access.connection.ConnectionFactory;
import data_access.models.Course;

public class CourseDAO {
	public List<Course> createCourseObject(ResultSet courseSet) {
		List<Course> courseList = new ArrayList<Course>();
		try {
			while (courseSet.next()) {
				Course c = new Course();
				c.setCourseID(courseSet.getString("courseid"));
				c.setCourseName(courseSet.getString("coursename"));
				c.setTeacherID(courseSet.getString("teacherid"));
				courseList.add(c);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return courseList;
	}

	public List<Course> findAll() {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT * FROM courses");
		String query = sb.toString();
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.prepareStatement(query);
			resultSet = statement.executeQuery();
			return createCourseObject(resultSet);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionFactory.close(resultSet);
			ConnectionFactory.close(statement);
			ConnectionFactory.close(connection);
		}
		return null;
	}

	public List<Course> findByID(String id) {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		String query = "SELECT * FROM courses WHERE courseid = ?";
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.prepareStatement(query);
			statement.setObject(1, id);
			resultSet = statement.executeQuery();
			return createCourseObject(resultSet);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionFactory.close(resultSet);
			ConnectionFactory.close(statement);
			ConnectionFactory.close(connection);
		}
		return null;
	}

	public List<Course> findByTeacherID(String id) {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		String query = "SELECT * FROM courses WHERE teacherid = ?";
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.prepareStatement(query);
			statement.setObject(1, id);
			resultSet = statement.executeQuery();
			return createCourseObject(resultSet);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionFactory.close(resultSet);
			ConnectionFactory.close(statement);
			ConnectionFactory.close(connection);
		}
		return null;
	}
	
	public List<Course> findByName(String name) {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		String query = "SELECT * FROM courses WHERE coursename = ?";
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.prepareStatement(query);
			statement.setObject(1, name);
			resultSet = statement.executeQuery();
			return createCourseObject(resultSet);
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
