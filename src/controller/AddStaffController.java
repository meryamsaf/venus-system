package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.StaffDAO;
import model.Staff;

/**
 * Servlet implementation class AddStaffController
 */
@WebServlet("/AddStaffController")
public class AddStaffController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private StaffDAO dao;
	
    public AddStaffController() {
        super();
        dao = new StaffDAO();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String staffID = (request.getParameter("staffID"));
		
		RequestDispatcher view = request.getRequestDispatcher("admin-add-staff.jsp");
		view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//retrieve input and set values
		Staff sup = new Staff();
		
		sup.setStaffID(request.getParameter("staffID"));
		sup.setsName(request.getParameter("sName"));
		sup.setsNum(request.getParameter("sNum"));
		sup.setsPassword(request.getParameter("sPassword"));
		sup.setAdminID(request.getParameter("adminID"));
		
		//invoke addStaff method in StaffDAO
		dao.addStaff(sup);
		
		request.setAttribute("staff", StaffDAO.getAllStaff());
		RequestDispatcher view = request.getRequestDispatcher("listStaff.jsp");
		view.forward(request, response);
	}

}
