package fr.formation.inti.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.formation.inti.entity.User;
import fr.formation.inti.service.userService;
import fr.formation.inti.service.userServiceImpl;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private userService userservice;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginController() {
		this.userservice = new userServiceImpl();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if(session == null) {
			response.sendRedirect(request.getContextPath());
		}else {
			request.getServletContext().getRequestDispatcher("/employee").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String email = request.getParameter("email");
		String password = request.getParameter("password");
//		request.setAttribute("email", email);
//		request.setAttribute("password", password);
		
		User user = userservice.findUserBy(email, password);

		if(user != null) {
		HttpSession session = request.getSession();
		session.setAttribute("user", user);
		request.getServletContext().getRequestDispatcher("/user").forward(request, response);
		
		}else {
			request.setAttribute("message", "erreur");
			request.getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
		}
	}

}
