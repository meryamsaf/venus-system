package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.StaffDAO;
import model.Staff;


/**
 * Servlet implementation class LoginController
 */
@WebServlet("/LoginStaffController")
public class LoginStaffController extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try { 
			PrintWriter out = response.getWriter();
			Staff staff = new Staff();
			staff.setStaffID(request.getParameter("staffID"));
			staff.setsPassword(request.getParameter("sPassword"));
			staff = StaffDAO.login(staff);
			if (staff.isValid()) { // logged-in page
				HttpSession session = request.getSession(true);
				session.setAttribute("sName", staff.getsName());
				session.setAttribute("sPassword", staff.getsPassword());
				session.setAttribute("staffID", staff.getStaffID());
				request.setAttribute("listStaff", StaffDAO.getAllStaff());
				RequestDispatcher rd = request.getRequestDispatcher("dashboard-staff.jsp");
				rd.forward(request, response);
			} else {
				//response.sendRedirect("customerLogin.jsp");
				 out.println("<script type=\"text/javascript\">");
				 out.println("alert('ID or password incorrect');");
				 out.println("location='staffLogin.jsp';");
				 out.println("</script>");
				// error page 
			}
		}
		catch(Throwable theException)
		{
			System.out.println(theException);
		}
	}

}
