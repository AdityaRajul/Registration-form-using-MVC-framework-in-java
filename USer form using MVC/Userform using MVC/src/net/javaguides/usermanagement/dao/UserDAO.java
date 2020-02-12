package net.javaguides.usermanagement.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import net.javaguides.usermanagement.model.User;


public class UserDAO {
	private String jdbcURL = "jdbc:mysql://localhost:3306/db";
	private String jdbcUsername = "root";
	private String jdbcPassword = "root";

	private static final String INSERT_USERS_SQL = "INSERT INTO data (id, name, address, phone, salary, net, total) VALUES (?,?,?,?,?,?,?)";

	private static final String SELECT_USER_BY_ID = "select id, name, address, phone, salary, net, total from data where id =?";
	private static final String SELECT_ALL_USERS = "select * from data";
	
	//public UserDAO() {
	//}

	protected Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
		} catch (SQLException e) {
			
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
		return connection;
	}

	public int insertUser(User user) throws SQLException {
		System.out.println(INSERT_USERS_SQL);
		int res= 0;
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
			preparedStatement.setInt(1, user.getId());
			preparedStatement.setString(2, user.getName());
			preparedStatement.setString(3, user.getAddress());
			preparedStatement.setString(4, user.getPhone());
			preparedStatement.setString(5, user.getSalary());
			preparedStatement.setString(6, user.getNet());
			preparedStatement.setString(7, user.getTotal());
			System.out.println(preparedStatement);
			res= preparedStatement.executeUpdate();
			preparedStatement.close();
		        disconnect();
		       
		} catch (SQLException e) {
			System.out.println(e);
			
		}
		System.out.println(res);
		return res;
		
	}protected void disconnect() throws SQLException {
	   }
	     

	public User selectUser(int id) {
		User user = null;
		
		try (Connection connection = getConnection();
				
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_ID);) {
			preparedStatement.setInt(1, id);
			System.out.println(preparedStatement);
			
			ResultSet rs = preparedStatement.executeQuery();

			
			while (rs.next()) {
				String name = rs.getString("name");
				String address = rs.getString("address");
				String phone = rs.getString("phone");
				String salary = rs.getString("salary");
				String net = rs.getString("net");
				String total = rs.getString("total");
				user = new User(id, name, address, phone, salary, net, total);
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
		return user;
	}

	public List<User> selectAllUsers() throws SQLException {

		List<User> users = new ArrayList<>();
		
		try (Connection connection = getConnection();

			
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS);) {
			System.out.println(preparedStatement);
			
			ResultSet rs = preparedStatement.executeQuery();

			
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String address = rs.getString("address");
				String phone = rs.getString("phone");
				String salary = rs.getString("salary");
				String net = rs.getString("net");
				String total = rs.getString("total");
				users.add(new User(id, name, address, phone,salary, net,total));
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
        disconnect();
		return users;
	}

	/*public boolean deleteUser(int id) throws SQLException {
		boolean rowDeleted;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(DELETE_USERS_SQL);) {
			statement.setInt(1, id);
			rowDeleted = statement.executeUpdate() > 0;
		}
		return rowDeleted;
	}

	public boolean updateUser(User user) throws SQLException {
		boolean rowUpdated;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(UPDATE_USERS_SQL);) {
			/*statement.setString(1, user.getName());
			statement.setString(2, user.getEmail());
			statement.setString(3, user.getCountry());
			statement.setInt(4, user.getId());
			
		//	statement.setString(1, user.getId());
			statement.setString(1, user.getName());
			statement.setString(2, user.getAddress());
			statement.setString(3, user.getPhone());
			statement.setString(4, user.getSalary());
			statement.setString(5, user.getNet());
			statement.setString(6, user.getTotal());
			rowUpdated = statement.executeUpdate() > 0;
		}
		return rowUpdated;
	}

	private void printSQLException(SQLException ex) {
		for (Throwable e : ex) {
			if (e instanceof SQLException) {
				e.printStackTrace(System.err);
				System.err.println("SQLState: " + ((SQLException) e).getSQLState());
				System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
				System.err.println("Message: " + e.getMessage());
				Throwable t = ex.getCause();
				while (t != null) {
					System.out.println("Cause: " + t);
					t = t.getCause();
				}
			}
		}
	}*/

}
