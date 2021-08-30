package com.revature.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.pojo.Employee;

public class EmployeeDAO {
	private String jdbcURL = "jdbc:mysql://localhost:3306/project1test?useSSL=false";
	private String jdbcUsername = "root";
	private String jdbcPassword = "6921mist019";

	private static final String INSERT_EMPLOYEE_SQL = "INSERT INTO employee"
			+ "  (username, password, firstname, lastname, email) VALUES " + " (?, ?, ?,?,?);";
	private static final String SELECT_EMPLOYEE_BY_ID = "select id,username,password,firstname,lastname,email from employee where id =?";
	private static final String SELECT_ALL_EMPLOYEE = "select * from employee";
	private static final String DELETE_EMPLOYEE_SQL = "delete from employee where id =?;";
	private static final String UPDATE_EMPLOYEE_SQL = "update employee set username = ?,"
			+ "password= ?,firstname= ?, lastname= ?, email =? where id = ?;";

	public EmployeeDAO() {
	}

	protected Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}

	public void createEmployee(Employee employee) throws SQLException {
		System.out.println(INSERT_EMPLOYEE_SQL);

		// try-with-resource statement will auto close the connection.
		try (Connection connection = getConnection();
				PreparedStatement ps = connection.prepareStatement(INSERT_EMPLOYEE_SQL)) {
			ps.setString(1, employee.getUsername());
			ps.setString(2, employee.getPassword());
			ps.setString(3, employee.getFirstName());
			ps.setString(4, employee.getLastName());
			ps.setString(5, employee.getEmail());
			System.out.println(ps);
			ps.executeUpdate();

		} catch (SQLException e) {
			printSQLException(e);
		}
	}

	public List<Employee> queryAll() throws SQLException {
		List<Employee> employeeList = new ArrayList<>();

		try (Connection connection = getConnection();
				PreparedStatement ps = connection.prepareStatement(SELECT_ALL_EMPLOYEE);) {
			System.out.println(ps);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {

				int id = rs.getInt("id");
				String username = rs.getString("username");
				String password = rs.getString("password");
				String firstname = rs.getString("firstname");
				String lastname = rs.getString("lastname");
				String email = rs.getString("email");
				employeeList.add(new Employee(id, username, password, firstname, lastname, email));

			}
		} catch (SQLException e) {
			printSQLException(e);
		}

		return employeeList;

	}

	public boolean deleteEmployee(int id) throws SQLException {
		boolean rowDeleted;
		try (Connection connection = getConnection();
				PreparedStatement ps = connection.prepareStatement(DELETE_EMPLOYEE_SQL);) {

			ps.setInt(1, id);
			rowDeleted = ps.executeUpdate() > 0;

		}
		return rowDeleted;
	}

	public boolean updateEmployee(Employee employee) throws SQLException {

		boolean rowUpdated;
		try (Connection connection = getConnection();
				PreparedStatement ps = connection.prepareStatement(UPDATE_EMPLOYEE_SQL);) {
			System.out.println(ps);

			ps.setString(1, employee.getUsername());
			ps.setString(2, employee.getPassword());
			ps.setString(3, employee.getFirstName());
			ps.setString(4, employee.getLastName());
			ps.setString(5, employee.getEmail());
			ps.setInt(6, employee.getId());

			rowUpdated = ps.executeUpdate() > 0;

		}
		return rowUpdated;
	}

	public Employee selectEmployeeById(int id) {

		Employee employee = null;
		try (Connection connection = getConnection();
				PreparedStatement ps = connection.prepareStatement(SELECT_EMPLOYEE_BY_ID);) {
			ps.setInt(1, id);
			System.out.println(ps);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				String username = rs.getString("username");
				String password = rs.getString("password");
				String firstname = rs.getString("firstname");
				String lastname = rs.getString("lastname");
				String email = rs.getString("email");
				employee = new Employee(id, username, password, firstname, lastname, email);

			}
		} catch (SQLException e) {
			printSQLException(e);

		}
		return employee;
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
	}

}