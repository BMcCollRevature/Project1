package com.revature.web;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;

import com.revature.dao.ReimbursementDAO;
import com.revature.pojo.Reimbursement;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ReimbursementController
 */
@WebServlet("/registerReimb")
public class ReimbursementController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ReimbursementDAO reimbursementDAO;

	public void init() {
		reimbursementDAO = new ReimbursementDAO();
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
			case "/insertReimb":
				insertReimb(request, response);
				break;
			case "/delete":
				deleteReimb(request, response);
				break;
			case "/edit":
				showEditForm(request, response);
				break;
			case "/update":
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
		List<Reimbursement> listReimb = reimbursementDAO.getAllReimbursement();
		request.setAttribute("listEmployee", listReimb);
		RequestDispatcher dispatcher = request.getRequestDispatcher("employee-list.jsp");
		dispatcher.forward(request, response);
	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("register.jsp");
		dispatcher.forward(request, response);
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Reimbursement existingReimb = reimbursementDAO.getReimbursement(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("register.jsp");
		request.setAttribute("reimbursement", existingReimb);
		dispatcher.forward(request, response);

	}

	private void insertReimb(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		
		
		Calendar cal = Calendar.getInstance();
		java.util.Date now = cal.getTime();
		Timestamp sub = new Timestamp(now.getTime());
		Timestamp submitted = Reimbursement.setReimSubmitted(sub);
		
		Calendar cal1 = Calendar.getInstance();
		java.util.Date now1 = cal1.getTime();
		Timestamp resolve = new Timestamp(now1.getTime());
		Timestamp resolved = Reimbursement.setReimResolved(resolve);
		
		String status = Reimbursement.setReimbStatus("PENDING");
		double amount = Double.parseDouble(request.getParameter("amount"));
		String author = request.getParameter("author");
		String description = request.getParameter("description");
		String type = request.getParameter("type");
		Reimbursement newReimb = new Reimbursement(0, amount,  submitted, resolved, author, description, status, type);
		reimbursementDAO.saveReimbursement(newReimb);
		response.sendRedirect("list");
	}

	private void updateReimb(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		double amount = Double.parseDouble(request.getParameter("amount"));
		Timestamp submitted = Timestamp.valueOf(request.getParameter("submitted"));
		Timestamp resolved = Timestamp.valueOf(request.getParameter("resolved"));
		String author = request.getParameter("author");
		String description = request.getParameter("decription");
		String status = request.getParameter("status");
		String type = request.getParameter("type");

		Reimbursement reimb = new Reimbursement(id, amount, submitted, resolved, author, description, status, type);
		reimbursementDAO.updateReimbursement(reimb);
		response.sendRedirect("list");
	}

	private void deleteReimb(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		reimbursementDAO.deleteReimbursement(id);
		response.sendRedirect("list");
	}
}
