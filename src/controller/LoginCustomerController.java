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

import dao.CustomerDAO;
import model.Customer;


/**
 * Servlet implementation class LoginController
 */
@WebServlet("/LoginCustomerController")
public class LoginCustomerController extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try { 
			PrintWriter out = response.getWriter();
			Customer customer = new Customer();
			customer.setcEmail(request.getParameter("cEmail"));
			customer.setcPassword(request.getParameter("cPassword"));
			customer = CustomerDAO.login(customer);
			if (customer.isValid()) { // logged-in page
				HttpSession session = request.getSession(true);
				session.setAttribute("cName", customer.getcName());
				session.setAttribute("cEmail", customer.getcPassword());
				session.setAttribute("custID", customer.getCustID());
				request.setAttribute("customerList", CustomerDAO.getAllCustomer() );
				RequestDispatcher rd = request.getRequestDispatcher("dashboard-customer.jsp");
				rd.forward(request, response);
			} else 
				{
					//response.sendRedirect("customerLogin.jsp");
					 out.println("<script type=\"text/javascript\">");
					 out.println("alert('Email or password incorrect');");
					 out.println("location='customerLogin.jsp';");
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
