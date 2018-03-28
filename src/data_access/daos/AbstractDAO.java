package data_access.daos;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import data_access.connection.ConnectionFactory;

public class AbstractDAO<T> {
	protected static final Logger LOGGER = Logger.getLogger(AbstractDAO.class.getName());
	private final Class<T> type;
	@SuppressWarnings("unchecked")
	public AbstractDAO() {
		this.type = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}

	protected String createSelectQuery(ArrayList<String> fd) {
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT ");
		sb.append(" * ");
		sb.append(" FROM ");
		sb.append(type.getSimpleName().toLowerCase(Locale.ROOT));
		sb.append(" WHERE ");
		for (String s : fd) {
			sb.append(s + "=?, AND ");
		}
		sb.setLength(sb.length() - 6);
		return sb.toString();
	}

	public static ArrayList<String> retrieveProperties(Object object) {
		ArrayList<String> s = new ArrayList<String>();
		for (Field field : object.getClass().getDeclaredFields()) {
			field.setAccessible(true);
			try {
				s.add(field.get(object).toString());
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}
		return s;
	}

	public List<T> findAll() {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		StringBuilder sb = new StringBuilder();
		System.out.println(sb);
		sb.append("SELECT ");
		sb.append("*");
		sb.append(" FROM ");
		sb.append(type.getSimpleName().toLowerCase(Locale.ROOT));
		String query = sb.toString();
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.prepareStatement(query);
			resultSet = statement.executeQuery();
			return createObjects(resultSet);
		} catch (SQLException e) {
			LOGGER.log(Level.WARNING, type.getName() + "DAO:find " + e.getMessage());
		} finally {
			ConnectionFactory.close(resultSet);
			ConnectionFactory.close(statement);
			ConnectionFactory.close(connection);
		}
		return null;
	}

	public List<T> findOne(ArrayList<String> fd, ArrayList<String> val) {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		String query = createSelectQuery(fd);
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.prepareStatement(query);
			int i = 1;
			for (String s : val) {
				statement.setObject(i++, s);
			}
			resultSet = statement.executeQuery();
			return createObjects(resultSet);
		} catch (SQLException e) {
			LOGGER.log(Level.WARNING, type.getName() + "DAO:find " + e.getMessage());
		} finally {
			ConnectionFactory.close(resultSet);
			ConnectionFactory.close(statement);
			ConnectionFactory.close(connection);
		}
		return null;
	}

	protected List<T> createObjects(ResultSet resultSet) {
		List<T> list = new ArrayList<T>();
		try {
			while (resultSet.next()) {
				T instance = type.newInstance();
				for (Field field : type.getDeclaredFields()) {
					Object value = resultSet.getObject(field.getName());
					PropertyDescriptor propertyDescriptor = new PropertyDescriptor(field.getName(), type);
					Method method = propertyDescriptor.getWriteMethod();
					method.invoke(instance, value);
				}
				list.add(instance);
			}
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IntrospectionException e) {
			e.printStackTrace();
		}
		return list;
	}

	protected String createInsertQuery() {
		StringBuilder sb = new StringBuilder();
		sb.append("INSERT INTO ");
		sb.append(type.getSimpleName().toLowerCase(Locale.ROOT));
		sb.append(" (");
		int i = 0;
		for (Field field : type.getDeclaredFields()) {
			sb.append(field.getName() + ", ");
			i++;
		}
		sb.setLength(sb.length() - 2);
		sb.append(") VALUES");
		sb.append(" (");
		for (int j = 0; j < i; j++)
			sb.append("?, ");
		sb.setLength(sb.length() - 2);
		sb.append(")");
		return sb.toString();
	}
	
	public int insertEnroll(String studentid, String courseid) {
		StringBuilder sb = new StringBuilder();
		sb.append("INSERT INTO enrollment (studentid, courseid) VALUES (?, ?)");
		Connection connection = null;
		PreparedStatement statement = null;
		int resultSet = 0;
		String query = createInsertQuery();
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.prepareStatement(query);
				try {
					statement.setObject(0, studentid);
					statement.setObject(1, courseid);
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				}
			resultSet = statement.executeUpdate();
			return resultSet;
		} catch (SQLException e) {
			LOGGER.log(Level.WARNING, type.getName() + "DAO:insert " + e.getMessage());
		} finally {
			ConnectionFactory.close(statement);
			ConnectionFactory.close(connection);
		}
		return 0;
	}

	public int insert(T t) {
		Connection connection = null;
		PreparedStatement statement = null;
		int resultSet = 0;
		String query = createInsertQuery();
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.prepareStatement(query);
			int i = 1;
			for (Field field : t.getClass().getDeclaredFields())
				try {
					field.setAccessible(true);
					statement.setObject(i++, field.get(t));
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				}
			resultSet = statement.executeUpdate();
			return resultSet;
		} catch (SQLException e) {
			LOGGER.log(Level.WARNING, type.getName() + "DAO:insert " + e.getMessage());
		} finally {
			ConnectionFactory.close(statement);
			ConnectionFactory.close(connection);
		}
		return 0;
	}

	protected String createUpdateQuery(ArrayList<String> fd) {
		StringBuilder sb = new StringBuilder();
		sb.append("UPDATE ");
		sb.append(type.getSimpleName().toLowerCase(Locale.ROOT));
		sb.append(" SET ");
		for (String s : fd) {
			sb.append(s + "=?, ");
		}
		sb.setLength(sb.length() - 2);
		sb.append(" WHERE id=?");
		return sb.toString();
	}

	public int update(ArrayList<String> val, ArrayList<String> fd) {
		String query = createUpdateQuery(fd);
		Connection connection = null;
		PreparedStatement statement = null;
		int resultSet = 0;
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.prepareStatement(query);
			int i = 1;
			for (String s : val) {
				statement.setObject(i++, s);
			}
			statement.setObject(i++, val.get(0));
			resultSet = statement.executeUpdate();
			return resultSet;
		} catch (SQLException e) {
			LOGGER.log(Level.WARNING, type.getName() + "DAO:update " + e.getMessage());
		} finally {
			ConnectionFactory.close(statement);
			ConnectionFactory.close(connection);
		}
		return 0;
	}

	private String createDeleteQuery(ArrayList<String> fd) {
		StringBuilder sb = new StringBuilder();
		sb.append("DELETE ");
		sb.append("FROM ");
		sb.append(type.getSimpleName().toLowerCase(Locale.ROOT));
		sb.append(" WHERE ");
		for (String s : fd) {
			sb.append(s + "=?, AND ");
		}
		sb.setLength(sb.length() - 6);
		return sb.toString();
	}

	public int delete(ArrayList<String> fd, ArrayList<String> val) {
		String query = createDeleteQuery(fd);
		Connection connection = null;
		PreparedStatement statement = null;
		int resultSet = 0;
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.prepareStatement(query);
			int i = 1;
			for (String s : val) {
				statement.setObject(i++, s);
			}
			resultSet = statement.executeUpdate();
			return resultSet;
		} catch (SQLException e) {
			LOGGER.log(Level.WARNING, type.getName() + "DAO:delete " + e.getMessage());
		} finally {
			ConnectionFactory.close(statement);
			ConnectionFactory.close(connection);
		}
		return 0;
	}
}
