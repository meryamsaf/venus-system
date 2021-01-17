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
 * Servlet implementation class DeleteStaffController
 */
@WebServlet("/DeleteStaffController")
public class DeleteStaffController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	private StaffDAO dao;
    public DeleteStaffController() {
        super();
        dao = new StaffDAO();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
        if (action.equalsIgnoreCase("delete")){
        String staffID= (request.getParameter("staffID"));
        
        dao.deleteStaff(staffID);
        
        action = "admin-view-staff.jsp";
        request.setAttribute("staff", StaffDAO.getAllStaff());
        }
        RequestDispatcher view = request.getRequestDispatcher("admin-view-staff.jsp");
        view.forward(request, response);
	}

}
