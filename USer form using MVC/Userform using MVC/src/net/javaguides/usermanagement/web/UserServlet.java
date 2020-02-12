package net.javaguides.usermanagement.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.javaguides.usermanagement.dao.UserDAO;
import net.javaguides.usermanagement.model.User;


@WebServlet("/UserDAO")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDAO userDAO;

	
	public void init() {
		 userDAO = new UserDAO();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = "/insert";
		System.out.println("servlet1");
		System.out.println(action);

		try {
			switch (action) {
			case "/insert":
				insertUser(request, response);
				break;
			case "/New":
				showNewForm(request, response);
				break;
			case "/list":
				listUser(request, response);
				break;
			
			default:
				RequestDispatcher dispatcher = request.getRequestDispatcher("user-form.jsp");
				dispatcher.forward(request, response);
				break;
			}
		} catch (SQLException ex) {
			 throw new ServletException(ex); 
			
			//System.out.println("message"+ ex);
	       
	                                     
	    
		}
}

	private void listUser(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<User> listUser = userDAO.selectAllUsers();
		request.setAttribute("listUser", listUser);
		RequestDispatcher dispatcher = request.getRequestDispatcher("user-list.jsp");
		dispatcher.forward(request, response);
		System.out.println("servlet2");	
	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("user-form.jsp");
		dispatcher.forward(request, response);
	}

	
	private void insertUser(final HttpServletRequest request, final HttpServletResponse response) 
			throws SQLException, IOException, ServletException {
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		String phone = request.getParameter("phone");
		String salary = request.getParameter("salary");
		String net = request.getParameter("net");
		String total = request.getParameter("total");
		User newUser = new User(id,name, address, phone, salary, net,total);
		@SuppressWarnings("unused")
		int res = userDAO.insertUser(newUser);
		listUser(request, response);
		//response.sendRedirect("user-list.jsp");
		System.out.println("servlet");
	}

	
}
