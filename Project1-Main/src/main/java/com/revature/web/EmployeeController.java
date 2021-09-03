package com.revature.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.dao.EmployeeDAO;
import com.revature.pojo.Employee;

/**
 * Servlet implementation class EmployeeController
 */
@WebServlet("/register")
public class EmployeeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EmployeeDAO employeeDAO;

	public void init() {
		employeeDAO = new EmployeeDAO();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();

		try {
			switch (action) {
			case "/new":
				showNewForm(request, response);
				break;
			case "/insertEmployee":
				insertEmployee(request, response);
				break;
			case "/delete":
				deleteEmployee(request, response);
				break;
			case "/edit":
				showEditForm(request, response);
				break;
			case "/update":
				updateEmployee(request, response);
				break;
			default:
				listEmployee(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

	private void listEmployee(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<Employee> listEmployee = employeeDAO.getAllEmployee();
		request.setAttribute("listEmployee", listEmployee);
		RequestDispatcher dispatcher = request.getRequestDispatcher("user-list.jsp");
		dispatcher.forward(request, response);
	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("user-form.jsp");
		dispatcher.forward(request, response);
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Employee existingEmployee = employeeDAO.getEmployee(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("user-form.jsp");
		request.setAttribute("employee", existingEmployee);
		dispatcher.forward(request, response);

	}

	private void insertEmployee(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String email = request.getParameter("email");
		Employee newEmployee = new Employee(0, username, password, firstname, lastname, email);
		employeeDAO.saveEmployee(newEmployee);
		response.sendRedirect("register-success");
	}

	private void updateEmployee(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String email = request.getParameter("email");

		Employee employee = new Employee(id, username, password, firstname, lastname, email);
		employeeDAO.updateEmployee(employee);
		response.sendRedirect("register-success");
	}

	private void deleteEmployee(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		employeeDAO.deleteEmployee(id);
		response.sendRedirect("register-success");
	}
}
/**
 * @see HttpServlet#HttpServlet()
 */
//	private void register(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//
//		String username = request.getParameter("username");
//		String password = request.getParameter("password");
//
//		String firstname = request.getParameter("firstname");
//
//		String lastname = request.getParameter("lastname");
//
//		String email = request.getParameter("email");
//
//		Employee employee = new Employee();
//		employee.setUsername(username);
//		employee.setPassword(password);
//		employee.setFirstName(firstname);
//		employee.setLastName(lastname);
//		employee.setEmail(email);
//
//		employeeDAO.saveEmployee(employee);
//
//		RequestDispatcher dispatcher = request.getRequestDispatcher("register-success.jsp");
//		dispatcher.forward(request, response);
//
//	}
//
//	/**
//	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
//	 *      response)
//	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		response.sendRedirect("register.jsp");
//	}
//
//	/**
//	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
//	 *      response)
//	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		register(request, response);
//	}
//
//}
