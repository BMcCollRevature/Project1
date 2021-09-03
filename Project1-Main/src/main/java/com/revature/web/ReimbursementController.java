package com.revature.web;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.dao.ReimbursementDAO;
import com.revature.pojo.Reimbursement;

/**
 * Servlet implementation class ReimbursementController
 */
@WebServlet("/reimbregister")
public class ReimbursementController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ReimbursementDAO reimbDAO;

	public void init() {
		reimbDAO = new ReimbursementDAO();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();

		try {
			switch (action) {
			case "/new":
				showNewForm(request, response);
				break;
			case "/insertReimb":
				insertReimb(request, response);
				break;
			case "/deleteReimb":
				deleteReimb(request, response);
				break;
			case "/editReimb":
				showEditForm(request, response);
				break;
			case "/updateReimb":
				updateReimb(request, response);
				break;
			default:
				listReimb(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

	private void listReimb(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<Reimbursement> listReimb = reimbDAO.getAllReimb();
		request.setAttribute("listReimb", listReimb);
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
		Reimbursement existingReimb = reimbDAO.getReimb(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("user-form.jsp");
		request.setAttribute("reimbursement", existingReimb);
		dispatcher.forward(request, response);

	}

	private void insertReimb(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		Double amount = Double.parseDouble(request.getParameter("amount"));
		String author = request.getParameter("author");
		String description = request.getParameter("description");
		Timestamp resolved = Timestamp.valueOf(request.getParameter("resolved"));
		String status = request.getParameter("status");
		Timestamp submitted = Timestamp.valueOf(request.getParameter("submitted"));
		String type = request.getParameter("type");
		Reimbursement newReimb = new Reimbursement(0, amount, submitted, resolved, author, description, status, type);
		reimbDAO.saveReimb(newReimb);
		response.sendRedirect("register-success");
	}

	private void updateReimb(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Double amount = Double.parseDouble(request.getParameter("amount"));
		String author = request.getParameter("author");
		String description = request.getParameter("description");
		Timestamp resolved = Timestamp.valueOf(request.getParameter("resolved"));
		String status = request.getParameter("status");
		Timestamp submitted = Timestamp.valueOf(request.getParameter("submitted"));
		String type = request.getParameter("type");

		Reimbursement reimb = new Reimbursement(id, amount, submitted, resolved, author, description, status, type);
		reimbDAO.updateReimb(reimb);
		response.sendRedirect("register-success");
	}

	private void deleteReimb(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		reimbDAO.deleteReimb(id);
		response.sendRedirect("register-success");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
