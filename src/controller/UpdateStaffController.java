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


@WebServlet("/UpdateStaffController")
public class UpdateStaffController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private StaffDAO dao;
    public UpdateStaffController() {
        super();
        dao = new StaffDAO();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String staffID = (request.getParameter("staffID"));
        Staff sup2 = dao.getStaffById(staffID); 
        request.setAttribute("staff", sup2);
        RequestDispatcher view = request.getRequestDispatcher("admin-update-staff.jsp");
        view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Staff sup = new Staff();
        sup.setStaffID(request.getParameter("staffID"));
        sup.setsName(request.getParameter("sName"));
        sup.setsNum(request.getParameter("sNum"));
        sup.setsPassword(request.getParameter("sPassword"));
        //sup.setAdminID(request.getParameter("adminID"));
        dao.updateStaff(sup); //dalam dao
        
        request.setAttribute("staff", StaffDAO.getAllStaff());
        RequestDispatcher view = request.getRequestDispatcher("listStaff.jsp");
        view.forward(request, response);
	}

}
