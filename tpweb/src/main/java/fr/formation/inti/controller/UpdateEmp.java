package fr.formation.inti.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.formation.inti.entity.Employee;
import fr.formation.inti.service.EmployeeService;
import fr.formation.inti.service.EmployeeServiceImpl;

/**
 * Servlet implementation class CustomerController
 */
@WebServlet("/update")
public class UpdateEmp extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EmployeeService employeeService;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateEmp() {
		this.employeeService = new EmployeeServiceImpl();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		Integer id = Integer.parseInt(request.getParameter("empId"));
		Employee emp = employeeService.findById(id);
		session.setAttribute("emp",emp);
		
		request.getServletContext().getRequestDispatcher("/WEB-INF/view/updateEmp.jsp").forward(request, response);
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Integer id = Integer.parseInt(request.getParameter("empId"));
		Employee emp = employeeService.findById(id);

		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String title = request.getParameter("title");

		String startDate = request.getParameter("startDate");

		Date date = null;
		try {
			date = new SimpleDateFormat("yyyy-mm-dd").parse(startDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		emp.setEmpId(id);
		emp.setFirstName(firstName);
		emp.setLastName(lastName);
		emp.setStartDate(date);
		emp.setTitle(title);

		employeeService.save(emp);
		request.getServletContext().getRequestDispatcher("/employees").forward(request, response);
	}

}
