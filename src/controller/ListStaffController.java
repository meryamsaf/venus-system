package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.StaffDAO;

/**
 * Servlet implementation class ListStaffController
 */
@WebServlet("/ListStaffController")
public class ListStaffController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private StaffDAO dao;
	public ListStaffController()
	{
		super();
		dao = new StaffDAO();
	}
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		request.setAttribute("staff", StaffDAO.getAllStaff());
		RequestDispatcher view = request.getRequestDispatcher("listStaff.jsp");
		view.forward(request, response);
	}
}