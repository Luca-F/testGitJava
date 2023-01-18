package fr.formation.inti.controller.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.net.*;

/**
 * Servlet Filter implementation class ExampleFilter
 */
@WebFilter("/*")
public class ExampleFilter implements Filter {

	/**
	 * Default constructor.
	 */
	public ExampleFilter() {

	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	enum URL{
		login, 
		employees,
		save,
		update,
		delete, 
		loggedout,
		error,
	}
	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		System.out.println("doFilter : avant");
		System.out.println("path:" + httpRequest.getContextPath());
		System.out.println("path:" + httpRequest.getServletPath());
		System.out.println("methode:" + httpRequest.getMethod());
		HttpSession session = httpRequest.getSession(false);
		
		System.out.println("session :" + session);
		
		String email = httpRequest.getParameter("email");
		String password = httpRequest.getParameter("password");
		
		System.out.println("email : " + email);
		System.out.println("password" + password);
		
		boolean urlExist = false;
		
		//Verifie tous les URL
		for (URL url : URL.values()) {
			String urlComplete = "/" + url;
			String urlCompleteJSP = "/WEB-INF/view/" + url + ".jsp"; //Les points ne sont pas pris en compte dans enum
			
			if(urlComplete.equals(httpRequest.getServletPath()) || 
					urlCompleteJSP.equals(httpRequest.getServletPath())) {
				urlExist = true;
			}
		}		
		
		System.out.println("urlExist : " + urlExist);
		
		//Permet d'acceder à la landing page et au login
		boolean urlExistLanding = false;
		if("/tpweb/".equals(httpRequest.getServletPath()) || 
				"/tpweb".equals(httpRequest.getServletPath()) ||
				"/index.jsp".equals(httpRequest.getServletPath()) ||
				"/login".equals(httpRequest.getServletPath()))	{
			urlExistLanding = true;
			System.out.println("je suis dans le if landing");
		}
		
		System.out.println("contextPath : " + httpRequest.getContextPath());
		System.out.println("ServletPath : " + httpRequest.getServletPath());
		System.out.println("urlExistLanding : " + urlExistLanding);
		
		// pass the request along the filter chain
		if((session != null && urlExist) || urlExistLanding) {
		chain.doFilter(request, response);
		}
		else 
			httpResponse.sendRedirect(httpRequest.getContextPath());
		
		System.out.println("doFilter : après");
		System.out.println("session :" + session);
		System.out.println("========================");
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {

	}

}
