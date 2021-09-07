package com.revature.web;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;


import com.revature.dao.LoginDAO1;
import com.revature.pojo.LoginBean;



/**
 * Servlet implementation class LoginController
 */
@WebServlet("/loginAdmin")
public class LoginController1 extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private LoginDAO1 loginDao1;

    public void init() {
        loginDao1 = new LoginDAO1();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        LoginBean loginBean1 = new LoginBean();
        loginBean1.setUsername(username);
        loginBean1.setPassword(password);

        try {
            if (loginDao1.validate(loginBean1)) {
                //HttpSession session = request.getSession();
                // session.setAttribute("username",username);
                response.sendRedirect("login-success-Admin.jsp");
            } else {
                HttpSession session = request.getSession();
                //session.setAttribute("user", username);
                //response.sendRedirect("login.jsp");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
