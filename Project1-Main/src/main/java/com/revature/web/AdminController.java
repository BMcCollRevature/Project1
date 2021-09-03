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

import com.revature.dao.AdminDAO;
import com.revature.pojo.Admin;

/**
 * Servlet implementation class AdminController
 */
@WebServlet("/adminregister")
public class AdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AdminDAO adminDAO;

	public void init() {
		adminDAO = new AdminDAO();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();

		try {
			switch (action) {
			case "/new":
				showNewForm(request, response);
				break;
			case "/insertAdmin":
				insertAdmin(request, response);
				break;
			case "/delete":
				deleteAdmin(request, response);
				break;
			case "/edit":
				showEditForm(request, response);
				break;
			case "/update":
				updateAdmin(request, response);
				break;
			default:
				listAdmin(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

	private void listAdmin(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<Admin> listAdmin = adminDAO.getAllAdmin();
		request.setAttribute("listAdmin", listAdmin);
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
		Admin existingAdmin = adminDAO.getAdmin(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("user-form.jsp");
		request.setAttribute("employee", existingAdmin);
		dispatcher.forward(request, response);

	}

	private void insertAdmin(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String email = request.getParameter("email");
		Admin newAdmin = new Admin(0, username, password, firstname, lastname, email);
		adminDAO.saveAdmin(newAdmin);
		response.sendRedirect("list");
	}

	private void updateAdmin(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String email = request.getParameter("email");

		Admin admin = new Admin(id, username, password, firstname, lastname, email);
		adminDAO.updateAdmin(admin);
		response.sendRedirect("list");
	}

	private void deleteAdmin(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		adminDAO.deleteAdmin(id);
		response.sendRedirect("list");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
