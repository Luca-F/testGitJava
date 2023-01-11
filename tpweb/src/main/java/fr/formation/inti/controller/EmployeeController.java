package fr.formation.inti.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.formation.inti.entity.Employee;
import fr.formation.inti.service.EmployeeService;
import fr.formation.inti.service.EmployeeServiceImpl;

/**
 * Servlet implementation class CustomerController
 */
@WebServlet("/save")
public class EmployeeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private EmployeeService employeeService;   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeController() {
        this.employeeService = new EmployeeServiceImpl();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action");
		if("find".equals(action)) {
			
			Integer id = Integer.parseInt(request.getParameter("id"));
			Employee emp = employeeService.findById(id);
			System.out.println(emp);
		}else {
			List<Employee> customers = employeeService.findAll();
			customers.forEach(System.out::println);
			
		}
			
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String postalCode = request.getParameter("POSTAL_CODE");
		String city = request.getParameter("CITY");
		String address = request.getParameter("ADDRESS");
		String state = request.getParameter("STATE");
		String custTypeCd = request.getParameter("CUST_TYPE_CD");
		String fedId = request.getParameter("FED_ID");
		
		Employee cust = new Employee();
		employeeService.save(cust);
		String contextPath = request.getContextPath();
		response.sendRedirect(contextPath);
		
	}

}
